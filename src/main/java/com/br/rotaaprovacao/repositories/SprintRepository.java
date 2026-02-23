package com.br.rotaaprovacao.repositories;

import com.br.rotaaprovacao.domain.sprint.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SprintRepository extends JpaRepository<Sprint, Long> {
}
