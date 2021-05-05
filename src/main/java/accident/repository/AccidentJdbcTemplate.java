package accident.repository;

import accident.model.Accident;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccidentJdbcTemplate {

    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }


    public Accident getById(int id) {
        return this.jdbc.query("select * from accident where id=?", (rs, row) -> {
            Accident accident = new Accident();
            accident.setId(rs.getInt("id"));
            accident.setNombre(rs.getString("nombre"));
            return accident;
        }, new Object[]{id}).stream().findAny().orElse(new Accident());
    }

    public Accident add(Accident accident) {
        this.jdbc.update("insert into accident (nombre) values (?)",
                accident.getNombre());
        return accident;
    }

    public Accident save(Accident accident) {
        jdbc.update("insert into accident (name) values (?)",
                accident.getNombre());
        return accident;
    }

    public List<Accident> findAccidents() {
        return jdbc.query("select id, nombre, description, address from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setNombre(rs.getString("nombre"));
                    accident.setDesc("description");
                    accident.setLocation("address");
                    return accident;
                });
    }

    public void update(int id, Accident accident) {
        this.jdbc.update("update accident set nombre=? where id=?", accident.getNombre(), id);
    }
}
