package accident.service;

import accident.model.Accident;
import accident.repository.AccidentJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccidentTemplateS {

    private AccidentJdbcTemplate store;

    public AccidentTemplateS() {
    }

    public AccidentTemplateS(AccidentJdbcTemplate store) {
        this.store = store;
    }

    public Accident getById(int id) {
        return store.getById(id);
    }

    public Accident add(Accident accident) {
        return store.add(accident);
    }

    public List<Accident> findAccidents() {
        return store.findAccidents();
    }

    public void update(int id, Accident accident) {
        store.update(id, accident);
    }
}
