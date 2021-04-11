package accident.control;


import accident.model.Accident;
import accident.service.AccidentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControl {

    private final AccidentService service;


    public IndexControl(AccidentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        System.out.println(" IndexController");
        this.service.add(new Accident("First", " Try Understand Spring", "Moscow"));
        model.addAttribute("list", service.findAccidents());
        return "index";
    }
}
