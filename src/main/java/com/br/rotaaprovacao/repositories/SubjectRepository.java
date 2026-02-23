package com.br.rotaaprovacao.repositories;

import com.br.rotaaprovacao.domain.subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
