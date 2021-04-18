package accident.service;

import accident.model.Accident;
import accident.repository.AccidentHibernate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AccidentService {

    public final AccidentHibernate store;

    private AtomicInteger countAccident = new AtomicInteger(0);

    public AccidentService(AccidentHibernate store) {
        this.store = store;
    }

    public boolean add(Accident accident) {
        Accident accident1 = this.store.add(accident);
        if (!this.store.add(accident).getLocation().equals(accident.getLocation())) {
            return false;
        }
        return true;
    }

    public boolean update(Accident accident) {
        return this.store.update(accident);
    }

    public Collection<Accident> findAccidents() {
        return this.store.findAccidents();
    }

    public Accident remove(Accident accident) {
        return store.remove(accident.getId());
    }

    public Accident getById(int id) {
        return store.getById(id);
    }
}
