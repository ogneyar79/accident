package accident.model;


import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Accident {

    private int countAccident = 0;

    private int id;
    private String name;
    private String text;
    private String address;

    public Accident() {
    }

    public Accident(String name, String text, String address) {
        this.id = ++countAccident;
        this.name = name;
        this.text = text;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accident accident = (Accident) o;
        return countAccident == accident.countAccident && id == accident.id && Objects.equals(name, accident.name) && Objects.equals(text, accident.text) && Objects.equals(address, accident.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countAccident, id, name, text, address);
    }
}
