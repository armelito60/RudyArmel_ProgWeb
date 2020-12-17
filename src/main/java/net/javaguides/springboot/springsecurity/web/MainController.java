package net.javaguides.springboot.springsecurity.web;

import javafx.event.EventHandler;
import net.javaguides.springboot.springsecurity.model.Event;
import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService eventService;

    @Autowired
    private UserService userService;

    public EventController eventController = new EventController();

    @GetMapping("/")
    public String root(Model model, Principal principal) {
        List<Event> eventParticipantList = eventService.getEventParticipant(principal.getName(), principal.getName());
        List<Event> eventCreatorList = eventService.getEventCreator(principal.getName());
        List<String> eventList = new ArrayList<>();
        List<String> creatorList = new ArrayList<>();

        for (Event event1 : eventParticipantList) {
            eventList.add("Evènement aura lieu le " + event1.getDate() + " à " + event1.getLieu() + " organisé par " + event1.getCreator());
        }

        if(eventList.size()==0){
            eventList.add("Pas d'évènements à venir");
            model.addAttribute("eventList", eventList);
        }
        else {
            model.addAttribute("eventList", eventList);
        }

        for(Event event2 : eventCreatorList) {
            creatorList.add("Evènement crée le " + event2.getDate());
        }

        if(creatorList.size()==0){
            creatorList.add("Pas d'évènements à venir");
            model.addAttribute("creatorList", creatorList);
        }
        else {
            model.addAttribute("creatorList", creatorList);
            eventService.deletedEvent(principal.getName());
        }

        System.out.println(eventList);

        return "index";
    }

    @ModelAttribute("event")
    public Event event() {
        return new Event();
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }

}