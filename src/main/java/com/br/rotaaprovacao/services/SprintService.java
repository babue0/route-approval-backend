package com.br.rotaaprovacao.services;

import com.br.rotaaprovacao.domain.sprint.Sprint;
import com.br.rotaaprovacao.domain.user.User;
import com.br.rotaaprovacao.dtos.SprintDTO;
import com.br.rotaaprovacao.repositories.SprintRepository;
import com.br.rotaaprovacao.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SprintService {

  @Autowired
  private SprintRepository sprintRepository;

  @Autowired
  private UserRepository userRepository;

  public Sprint createSprint(SprintDTO data) throws Exception{

    User user = userRepository.findById(data.userId()).orElseThrow(() -> new Exception("User not found"));

    if (data.endDate().isBefore(data.startDate())) {
      throw new Exception("End date is before start date");
    }

    Sprint sprint = new Sprint();
    sprint.setUser(user);
    sprint.setStartDate(data.startDate());
    sprint.setEndDate(data.endDate());
    sprint.setGoal(data.goal());

    return sprintRepository.save(sprint);
  }
}
