package net.javaguides.springboot.springsecurity.web;

import net.javaguides.springboot.springsecurity.model.Event;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/survey")
public class EventController {

    @Autowired
    private UserService eventService;

    public String creator;

    @GetMapping
    public String stepOneSurvey(Model model) {

        List<User> userList = eventService.getAllByEmail();
        List<String> emailList = new ArrayList<>();

        for (User user: userList) {
            emailList.add(user.getEmail());
        }

        Collections.sort(emailList);
        System.out.println(emailList);
        System.out.println(userList);

        model.addAttribute("email", emailList);
        return "survey";
    }

    @ModelAttribute("event")
    public Event event() {
        return new Event();
    }

    @PostMapping
    public String eventCreated(@ModelAttribute("event") @Valid Event event, Principal principal) {
        event.setCreator(principal.getName());
        eventService.saveUserParticipant(event);
        System.out.println(event.toString());
        creator = event.getCreator();
        System.out.println(event.getCreator());
        return "confirmedEvent";
    }

}
