package accident.repository;

import accident.model.Accident;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class AccidentMem {

    private final HashMap<Integer, Accident> accidents = new HashMap<>();

    public HashMap<Integer, Accident> getAccidents() {
        return accidents;
    }
}
