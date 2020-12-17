package project.springboot.web;

import project.springboot.model.Event;
import project.springboot.model.User;
import project.springboot.service.UserService;
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
    public String stepOneSurvey(Model model, Principal principal) {

        List<User> userList = eventService.getAllByEmail();
        List<String> emailList = new ArrayList<>();

        for (User user: userList) {
            emailList.add(user.getEmail());
        }

        emailList.remove(principal.getName());

        Collections.sort(emailList);

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
        return "confirmedEvent";
    }

}
