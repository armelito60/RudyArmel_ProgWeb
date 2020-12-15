package net.javaguides.springboot.springsecurity.service;

import net.javaguides.springboot.springsecurity.model.Event;
import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.web.dto.UserRegistrationDto;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);

    User findByPseudo(String pseudo);

    Event saveUserParticipant(Event event);

    List<User> getAllByEmail();

    List<Event> getEventParticipant(String pseudo);

}