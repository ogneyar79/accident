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

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    private Accident save(Accident accident) {
        jdbc.update("insert into accident (name) values (?)",
                accident.getNombre());
        return accident;
    }
    private List<Accident> findAccidents() {
        return jdbc.query("select id, name from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setNombre(rs.getString("name"));
                    return accident;
                });
    }

}
