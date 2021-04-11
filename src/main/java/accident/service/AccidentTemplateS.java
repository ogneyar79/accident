package accident.service;

import accident.model.Accident;
import accident.repository.AccidentJdbcTemplate;

import java.util.List;

public class AccidentTemplateS {

    private final AccidentJdbcTemplate store;

    public AccidentTemplateS(AccidentJdbcTemplate store) {
        this.store = store;
    }

    public Accident getById(int id) {

        return this.store.getJdbc().query("select * from accident where id=?", (rs, row) -> {
            Accident accident = new Accident();
            accident.setId(rs.getInt("id"));
            accident.setNombre(rs.getString("nombre"));
            return accident;
        }, new Object[]{id}).stream().findAny().orElse(new Accident());
    }


    public Accident add(Accident accident) {
        this.store.getJdbc().update("insert into accident (nombre) values (?)",
                accident.getNombre());
        return accident;
    }

    public List<Accident> findAccidents() {
        return this.store.getJdbc().query("select * from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setNombre(rs.getString("nombre"));
                    return accident;
                });
    }

    public void update(int id, Accident accident) {
        this.store.getJdbc().update("update accident set nombre=? where id=?", accident.getNombre(), id);
    }

}
