package accident.model;


import org.springframework.stereotype.Component;

@Component
public class Accident {

    private int countAccident = 0;

    private final int id;
    private final String name;
    private final String text;
    private final String address;

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
}
