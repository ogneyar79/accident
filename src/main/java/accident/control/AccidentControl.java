package accident.control;


import accident.model.Accident;
import accident.service.AccidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccidentControl {
    private final AccidentService service;

    public AccidentControl(AccidentService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create() {
        return "accident/create";
    }

    @PostMapping("/save")
    public String save(@RequestParam String nombre, @RequestParam String desc, @RequestParam String location, Model model) {
        Accident accident = new Accident(nombre, desc, location);
        service.add(accident);
        return "redirect:/";
    }

}
