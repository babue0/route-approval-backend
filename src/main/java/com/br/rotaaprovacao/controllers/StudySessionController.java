package com.br.rotaaprovacao.controllers;

import com.br.rotaaprovacao.domain.session.StudySession;
import com.br.rotaaprovacao.dtos.StudySessionDTO;
import com.br.rotaaprovacao.services.StudySessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessions")
public class StudySessionController {

  @Autowired
  private StudySessionService service;

  @PostMapping
  public ResponseEntity<StudySession> createSession(@RequestBody StudySessionDTO data) throws Exception {
    StudySession newSession = service.createStudySession(data);
    return new ResponseEntity<>(newSession, HttpStatus.CREATED);
  }

}
