package net.javaguides.springboot.springsecurity.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfirmedController {

    @GetMapping("/confirmedEvent")
    public String confirmedEvent() {
        return "confirmedEvent";
    }

    @GetMapping("/deletedEvent")
    public String deletedEvent() {
        return "deletedEvent";
    }
}
