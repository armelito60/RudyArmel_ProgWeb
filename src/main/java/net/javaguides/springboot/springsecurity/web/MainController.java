package net.javaguides.springboot.springsecurity.web;

import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

    @GetMapping("/survey")
    public String stepOneSurvey(Model model) {

        List<User> userList = userService.getAllByPseudo();
        List<String> pseudoList = new ArrayList<>();

        for (User user: userList) {
            pseudoList.add(user.getPseudo());
        }

        Collections.sort(pseudoList);
        System.out.println(pseudoList);
        System.out.println(userList);

        model.addAttribute("pseudo", pseudoList);
        return "survey";
    }

}