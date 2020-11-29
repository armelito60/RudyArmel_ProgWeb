package net.javaguides.springboot.springsecurity.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.web.dto.UserRegistrationDto;

import java.util.ArrayList;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User findByPseudo(String pseudo);

    User save(UserRegistrationDto registration);
}