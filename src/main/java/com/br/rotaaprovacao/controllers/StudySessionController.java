package com.br.rotaaprovacao.controllers;

import com.br.rotaaprovacao.domain.session.StudySession;
import com.br.rotaaprovacao.dtos.StudySessionDTO;
import com.br.rotaaprovacao.repositories.StudySessionRepository;
import com.br.rotaaprovacao.services.StudySessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sessions")
@CrossOrigin(origins = "*")
public class StudySessionController {

  @Autowired
  private StudySessionService service;

  @Autowired
  private StudySessionRepository repository;

  @PostMapping
  public ResponseEntity<StudySession> createSession(@RequestBody StudySessionDTO data) throws Exception {
    StudySession newSession = service.createStudySession(data);
    return new ResponseEntity<>(newSession, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<StudySession>> getAllSessions() {
    List<StudySession> sessions = repository.findAll();
    return new ResponseEntity<>(sessions, HttpStatus.OK);
  }

}
