package com.br.rotaaprovacao.domain.subject;

import com.br.rotaaprovacao.dtos.SubjectDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "subjects")
@Table(name = "subjects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Subject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private Integer importanceWeight;

  public Subject(SubjectDTO data){
    this.name = data.name();
    this.importanceWeight = data.importanceWeight();
  }
}
