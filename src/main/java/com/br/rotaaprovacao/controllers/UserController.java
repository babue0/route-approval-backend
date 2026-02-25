package com.br.rotaaprovacao.controllers;

import com.br.rotaaprovacao.domain.sprint.Sprint;
import com.br.rotaaprovacao.domain.user.User;
import com.br.rotaaprovacao.dtos.UserDTO;
import com.br.rotaaprovacao.repositories.SprintRepository;
import com.br.rotaaprovacao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

  @Autowired
  private UserRepository repository;

  @Autowired
  private SprintRepository sprintRepository;

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody UserDTO data){
    String ecryptedPassword = new BCryptPasswordEncoder().encode(data.password());

    User newUser = new User(data);
    newUser.setPassword(ecryptedPassword);
    this.repository.save(newUser);

    Sprint sprint = new Sprint();
    sprint.setUser(newUser);
    sprint.setGoal("Aprovação na " + data.targetExam());
    sprint.setStartDate(LocalDate.now());
    sprint.setEndDate(LocalDate.now().plusDays(7));
    this.sprintRepository.save(sprint);

    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }
}

