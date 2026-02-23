package com.br.rotaaprovacao.domain.sprint;


import com.br.rotaaprovacao.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity(name = "sprints")
@Table(name = "sprints")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Sprint {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate startDate;
  private LocalDate endDate;
  private String goal;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
