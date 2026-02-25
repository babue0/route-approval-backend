package com.br.rotaaprovacao.controllers;

import com.br.rotaaprovacao.domain.user.User;
import com.br.rotaaprovacao.dtos.AuthenticationDTO;
import com.br.rotaaprovacao.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private TokenService tokenService;

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody AuthenticationDTO data){
    var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());

    var auth = this.authenticationManager.authenticate(usernamePassword);

    var token = tokenService.generateToken((User) auth.getPrincipal());

    return ResponseEntity.ok(token);
  }
}
