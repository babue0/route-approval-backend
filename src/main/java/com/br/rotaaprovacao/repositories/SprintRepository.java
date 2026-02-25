package com.br.rotaaprovacao.repositories;

import com.br.rotaaprovacao.domain.sprint.Sprint;
import com.br.rotaaprovacao.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SprintRepository extends JpaRepository<Sprint, Long> {

  List<Sprint> findByUser(User user);
}
