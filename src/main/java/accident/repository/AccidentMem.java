package accident.repository;

import accident.model.Accident;
import org.springframework.stereotype.Repository;

import java.util.HashMap;


@Repository
public class AccidentMem {

    private final HashMap<Long, Accident> accidents = new HashMap<>();

    public HashMap<Long, Accident> getAccidents() {
        return accidents;
    }
}
