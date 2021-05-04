package accident.control;


import accident.model.Accident;
import accident.service.AccidentTemplateS;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccidentControl {
    private final AccidentTemplateS service;

    public AccidentControl(AccidentTemplateS service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String create() {
        return "accident/create";
    }

//    @PostMapping("/save")
//    public String save(@RequestParam String nombre, @RequestParam String desc, @RequestParam String location, Model model) {
//        Accident accident = new Accident(nombre, desc, location);
//        service.add(accident);
//        return "redirect:/";
//    }

    @PostMapping("/save")
    public String save(@ModelAttribute("accident") Accident accident) {
        System.out.println(" AccidentController Method save with Model Attribute");
        System.out.println(" Accident id :" + accident.getId());
        service.add(accident);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String correctAccident(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", service.getById(id));
        return "accident/edit";
    }

//    @PostMapping("/update")
//    public String updateAccident(@RequestParam String nombre, @RequestParam String desc, @RequestParam String location, @RequestParam String id) {
//        System.out.println(" Location 58 :" + location);
//        Accident accident = new Accident(nombre, desc, location);
//        accident.setId(Integer.parseInt(id));
//        service.update(accident);
//        return "redirect:/";
//    }

    @PostMapping("/update")
    public String updateAccident(@RequestParam("id") String id, @ModelAttribute("accident") Accident accident) {
        System.out.println(" AccidentController Method update with Model Attribute");

        System.out.println(" Accident id :" + accident.getId());
        System.out.println(" Accident Desc :" + accident.getDesc());
        System.out.println(" Accident Location :" + accident.getLocation());
        accident.setId(Integer.parseInt(id));
        System.out.println(" Accident Location 62 :" + accident.getLocation());
        service.update(Integer.parseInt(id), accident);
        return "redirect:/";
    }
}
