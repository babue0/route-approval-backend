package com.br.rotaaprovacao.controllers;

import com.br.rotaaprovacao.domain.sprint.Sprint;
import com.br.rotaaprovacao.dtos.SprintDTO;
import com.br.rotaaprovacao.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sprints")
public class SprintController {

  @Autowired
  private SprintService sprintService;

  @PostMapping
  public ResponseEntity<Sprint> createSprint(@RequestBody SprintDTO data) throws  Exception{
    Sprint newSprint = sprintService.createSprint(data);
    return new ResponseEntity<>(newSprint, HttpStatus.CREATED);
  }
}
