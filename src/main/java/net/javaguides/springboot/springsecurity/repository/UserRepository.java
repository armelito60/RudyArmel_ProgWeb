package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository < User, Long > {
    User findByEmail(String email);
    User findByPseudo(String pseudo);
    List<User> findAllOrderByEmailNotNull();

}