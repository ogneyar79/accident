package accident.control;


import accident.service.AccidentTemplateS;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexControl {

 //   AccidentJdbcTemplate service;
      private final AccidentTemplateS service;
// Accident TemplateS service need ?

    public IndexControl(AccidentTemplateS service) {
        this.service = service;
    }

    @GetMapping("/")
    public String index(Model model) {
        System.out.println(" IndexController");
        // this.service.add(new Accident("First", " Try Understand Spring", "Moscow"));
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("list", service.findAccidents());
        return "index";
    }
}
