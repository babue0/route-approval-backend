package com.br.rotaaprovacao.controllers;

import com.br.rotaaprovacao.domain.sprint.Sprint;
import com.br.rotaaprovacao.domain.user.User;
import com.br.rotaaprovacao.dtos.SprintDTO;
import com.br.rotaaprovacao.repositories.SprintRepository;
import com.br.rotaaprovacao.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sprints")
@CrossOrigin(origins = "*")
public class SprintController {

  @Autowired
  private SprintService sprintService;

  @Autowired
  private SprintRepository repository;

  @GetMapping
  public ResponseEntity<List<Sprint>> getUserSprints() {
    User loggedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    List<Sprint> sprints = repository.findByUser(loggedUser);
    return new ResponseEntity<>(sprints, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Sprint> createSprint(@RequestBody SprintDTO data) throws  Exception{
    Sprint newSprint = sprintService.createSprint(data);
    return new ResponseEntity<>(newSprint, HttpStatus.CREATED);
  }
}
