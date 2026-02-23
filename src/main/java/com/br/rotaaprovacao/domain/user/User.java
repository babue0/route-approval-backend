package com.br.rotaaprovacao.domain.user;


import com.br.rotaaprovacao.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @Column(unique = true)
  private String email;

  private String password;

  private String targetExam;

  public User(UserDTO data){
    this.name = data.name();
    this.email = data.email();
    this.password = data.password();
    this.targetExam = data.targetExam();
  }
}
