package com.br.rotaaprovacao.controllers;

import com.br.rotaaprovacao.domain.subject.Subject;
import com.br.rotaaprovacao.dtos.SubjectDTO;
import com.br.rotaaprovacao.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@CrossOrigin(origins = "*")
public class SubjectController {

  @Autowired
  private SubjectRepository repository;

  @PostMapping
  public ResponseEntity<Subject> createSubject(@RequestBody SubjectDTO data){
    Subject newSubject = new Subject(data);
    this.repository.save(newSubject);
    return new ResponseEntity<>(newSubject, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Subject>> getAllSubjects(){
    List<Subject> subjects = this.repository.findAll();
    return new ResponseEntity<>(subjects, HttpStatus.OK);
  }
}
