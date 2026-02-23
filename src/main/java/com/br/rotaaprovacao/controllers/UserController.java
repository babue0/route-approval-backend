package com.br.rotaaprovacao.controllers;

import com.br.rotaaprovacao.domain.user.User;
import com.br.rotaaprovacao.dtos.UserDTO;
import com.br.rotaaprovacao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserRepository repository;

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody UserDTO data){
    User newUser = new User();
    this.repository.save(newUser);
    return new ResponseEntity<>(newUser, HttpStatus.CREATED);
  }
}
