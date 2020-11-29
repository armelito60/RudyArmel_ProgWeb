package net.javaguides.springboot.springsecurity.web;

import javax.validation.Valid;

import net.javaguides.springboot.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.service.UserService;
import net.javaguides.springboot.springsecurity.web.dto.UserRegistrationDto;

import java.sql.PseudoColumnUsage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
                                      BindingResult result) {

        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()) {
            return "registration";
        }
        existing = userService.findByPseudo(userDto.getPseudo());
        if (existing != null) {
            result.rejectValue("pseudo", null, "There is already an account registered with that pseudo");
        }

        if (result.hasErrors()) {
            return "registration";
        }

        userService.save(userDto);
        filtrePseudo();
        return "redirect:/registration?success";
    }

    public List<String> filtrePseudo(){

        List<User> listUser = userRepository.findAll();
        List<String> listPseudo = new ArrayList<>();
        for (User user: listUser) {
            listPseudo.add(user.getPseudo().toLowerCase());

        }
        Collections.sort(listPseudo);
        for (String pseudo:listPseudo) {
            System.out.println(pseudo);

        }

        return listPseudo;
        var jqxhr = $.get( "example.php", function() {
            alert( "success" );
        })
    }
}