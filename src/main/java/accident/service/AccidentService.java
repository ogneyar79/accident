package accident.service;

import accident.model.Accident;
import accident.repository.AccidentMem;
import org.springframework.stereotype.Service;

@Service
public class AccidentService {

    public final AccidentMem store;

    public AccidentService(AccidentMem store) {
        this.store = store;
    }

    public boolean add(Accident accident) {
        if (store.getAccidents().containsKey(accident.getId())) {
            return false;
        }
        store.getAccidents().put(accident.getId(), accident);
        return true;
    }

    public boolean update(Accident accident) {
        if (store.getAccidents().containsKey(accident.getId())) {
            store.getAccidents().put(accident.getId(), accident);
            return true;
        }
        return false;
    }

    public Accident remove(Accident accident) {
        return store.getAccidents().remove(accident.getId());
    }

    public Accident getById(int id) {
        return store.getAccidents().containsKey(id) ? store.getAccidents().get(id)
                : new Accident("zero", "Zero", "@zero");
    }
}
