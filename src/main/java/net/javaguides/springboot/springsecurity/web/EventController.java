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


    @GetMapping
    public String stepOneSurvey(Model model) {

        List<User> userList = eventService.getAllByPseudo();
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

    @ModelAttribute("event")
    public Event event() {
        return new Event();
    }

    @PostMapping
    public String eventCreated(@ModelAttribute("event") @Valid Event event) {
        eventService.saveUserParticipant(event);
        System.out.println(event.toString());
        return "index";
    }
    @GetMapping
    public String eventParticipant(Model model, Principal principal) {
        List<Event> eventParticipantList = eventService.getEventParticipant(principal.getName());
        List<String> eventList = new ArrayList<>();

        for (Event event : eventParticipantList) {
            eventList.add(event.toString());
        }
        if(eventList.size()==0){
            eventList.add("Pas d'évènements à venir");
            model.addAttribute("eventList", eventList);

        }
        else {
            model.addAttribute("eventList", eventList);
        }

        return "index";
    }
}
