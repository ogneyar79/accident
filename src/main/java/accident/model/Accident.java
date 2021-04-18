package accident.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "accident")
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String desc;
    private String location;

    public Accident() {
    }

    public Accident(String nombre, String desc, String location) {
        this.id = 0;
        this.nombre = nombre;
        this.desc = desc;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDesc() {
        return desc;
    }

    public String getLocation() {
        return location;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accident accident = (Accident) o;
        return id == accident.id && Objects.equals(nombre, accident.nombre) && Objects.equals(desc, accident.desc) && Objects.equals(location, accident.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, desc, location);
    }
}
