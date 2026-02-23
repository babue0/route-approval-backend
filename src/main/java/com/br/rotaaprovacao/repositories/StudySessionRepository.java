package com.br.rotaaprovacao.repositories;

import com.br.rotaaprovacao.domain.session.StudySession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudySessionRepository extends JpaRepository<StudySession, Long> {
}
