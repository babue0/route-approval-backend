package com.br.rotaaprovacao.domain.session;


import com.br.rotaaprovacao.domain.sprint.Sprint;
import com.br.rotaaprovacao.domain.subject.Subject;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "study_sessions")
@Table(name = "study_sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class StudySession {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer durationMinutes;
  private Integer questionsAnswered;
  private Integer correctAnswers;
  private LocalDateTime sessionDate;

  @ManyToOne
  @JoinColumn(name = "sprint_id")
  private Sprint sprint;

  @ManyToOne
  @JoinColumn(name = "subject_id")
  private Subject subject;
}
