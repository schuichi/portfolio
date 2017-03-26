package pl.tomekD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomekD.model.FormContact;
import pl.tomekD.service.ProjectService;

@Controller
public class MainController {

    @Autowired
    ProjectService projectService;

    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("project", projectService.findAll());

        model.addAttribute("emailClass", new FormContact());
        model.addAttribute("success", false);
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String confirmedForm(@ModelAttribute("emailClass") FormContact form, Model model) {
        // tutaj będzie się znajdować logika wysylania maila
        // z dzisiejszej lekcji
        model.addAttribute("success", true);
        System.out.println("WYSŁANO MAILA DO: " + form.getEmail());
        return "index";
    }


}
