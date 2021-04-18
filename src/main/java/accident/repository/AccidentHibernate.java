package accident.repository;

import accident.model.Accident;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

public class AccidentHibernate {

    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public Accident add(Accident accident) {
        Accident accident1;
        try (Session session = sf.openSession()) {
            session.getTransaction().begin();
            Serializable id = session.save(accident);
            accident1 = session.get(Accident.class, id);
            session.getTransaction().commit();
            return accident1;
        }
    }


    public boolean update(Accident accident) {
        if (accident.getId() == 0) {
            return false;
        }
        try (Session session = sf.openSession()) {
            session.getTransaction().begin();
            session.update(accident);
            if (!session.get(Accident.class, accident.getId()).equals(accident)) {
                return false;
            }
            session.getTransaction().commit();
        }
        return true;
    }

    public List<Accident> findAccidents() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("from accident")
                    .list();
        }
    }

    public Accident getById(int id) {
        Accident accident;
        try (Session session = sf.openSession()) {
            session.getTransaction().begin();
            accident = session.get(Accident.class, id);
            session.getTransaction().commit();
        }
        return accident;
    }

    public Accident remove(long id) {
        Accident removed = null;
        try (Session session = sf.openSession()) {
            session.getTransaction().begin();
            removed = session.get(Accident.class, id);
            session.remove(removed);
            session.getTransaction().commit();
        }
        return removed;
    }
}
