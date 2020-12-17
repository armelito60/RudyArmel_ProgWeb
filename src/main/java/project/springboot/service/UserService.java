package project.springboot.service;

import project.springboot.model.Event;
import org.springframework.security.core.userdetails.UserDetailsService;

import project.springboot.model.User;
import project.springboot.web.dto.UserRegistrationDto;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);

    User findByPseudo(String pseudo);

    Event saveUserParticipant(Event event);

    List<User> getAllByEmail();

    List<Event> getEventParticipant(String email, String creator);

    void deletedEvent(String creator);

    List<Event> getEventCreator(String creator);

}