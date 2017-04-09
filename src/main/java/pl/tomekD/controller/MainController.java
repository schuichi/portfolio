package pl.tomekD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomekD.dao.ProjectRepository;
import pl.tomekD.model.FormContact;
import pl.tomekD.model.Project;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping("/")
    public String index(Model model) {
        List<Project> project = (List<Project>) projectRepository.findAll();
        model.addAttribute("project", project);



        model.addAttribute("emailClass", new FormContact());
        model.addAttribute("success", false);



        return "index";
    }


    @RequestMapping(value = "/addproject", method = RequestMethod.GET)
    public String addProject(Model model){
        model.addAttribute("addproject", new Project());
        model.addAttribute("project", projectRepository.findAll());
        return "addproject";

    }


    @RequestMapping(value = "/addproject", method = RequestMethod.POST)
    public String addProjectPost(@ModelAttribute Project project, Model model){

        projectRepository.save(project);

        model.addAttribute("add", true);

        return "redirect:/addproject";
    }


    @Transactional
    @RequestMapping(value = "/addproject/delete/{id}", method = RequestMethod.GET)
    public String deleteProject(@PathVariable Long id, Model model){
        projectRepository.delete(id);
        model.addAttribute("project", projectRepository.findAll());

        return "redirect:/addproject";
    }



    @Transactional
    @RequestMapping(value = "/addproject/edit/{id}", method = RequestMethod.GET)
    public String editProject(@PathVariable Long id, Model model){
        Project project = projectRepository.findOne(id);
        model.addAttribute("addproject", project);

        return "addproject";
    }




    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String confirmedForm(@ModelAttribute("emailClass") FormContact form, Model model) {
        // tutaj będzie się znajdować logika wysylania maila

        model.addAttribute("success", true);

        System.out.println("WYSŁANO MAILA DO: " + form.getEmail());



        model.addAttribute("project", projectRepository.findAll());

        return "index";
    }



}
