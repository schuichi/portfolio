package pl.tomekD.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomekD.dao.UserProjectRepository;
import pl.tomekD.model.UserProject;

@Controller
public class UserProjectController {

    @Autowired
    UserProjectRepository userProjectRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("userProject", new UserProject());

        return "login";

    }

}
