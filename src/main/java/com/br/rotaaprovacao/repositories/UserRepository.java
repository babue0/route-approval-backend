package com.br.rotaaprovacao.repositories;

import com.br.rotaaprovacao.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
