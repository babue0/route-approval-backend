package com.br.rotaaprovacao.repositories;

import com.br.rotaaprovacao.domain.session.StudySession;
import com.br.rotaaprovacao.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudySessionRepository extends JpaRepository<StudySession, Long> {

  List<StudySession> findBySprintUser(User user);
}
