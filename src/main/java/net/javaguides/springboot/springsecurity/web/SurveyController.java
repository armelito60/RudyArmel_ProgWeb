package net.javaguides.springboot.springsecurity.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SurveyController {

    @GetMapping("/survey")
    public String survey() {
        return "survey";
    }

}
