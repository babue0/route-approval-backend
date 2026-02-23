package com.br.rotaaprovacao.services;

import com.br.rotaaprovacao.domain.session.StudySession;
import com.br.rotaaprovacao.domain.sprint.Sprint;
import com.br.rotaaprovacao.domain.subject.Subject;
import com.br.rotaaprovacao.dtos.StudySessionDTO;
import com.br.rotaaprovacao.repositories.SprintRepository;
import com.br.rotaaprovacao.repositories.StudySessionRepository;
import com.br.rotaaprovacao.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudySessionService {

  @Autowired
  private StudySessionRepository sessionRepository;

  @Autowired
  private SprintRepository sprintRepository;

  @Autowired
  private SubjectRepository subjectRepository;


  public StudySession createStudySession(StudySessionDTO data) throws Exception {
    Sprint sprint = sprintRepository.findById(data.sprintId())
            .orElseThrow(() -> new Exception("Sprint not found"));

    Subject subject = subjectRepository.findById(data.subjectId())
            .orElseThrow(() -> new Exception("Subject not found"));

    StudySession session = new StudySession();
    session.setSprint(sprint);
    session.setSubject(subject);
    session.setDurationMinutes(data.durationMinutes());
    session.setQuestionsAnswered(data.questionsAnswered());
    session.setCorrectAnswers(data.correctAnswers());
    session.setSessionDate(LocalDateTime.now());


    return sessionRepository.save(session);
  }
}
