package main.java.com.rpxcard.model;

import java.time.LocalDate;

public class Client {
  private Integer id;
  private String name;
  private String cpf;
  private String email;
  private LocalDate birthDate;

  //Constructors
  public Client(Integer id, String name, String cpf, String email, LocalDate birthDate) {
    this.id = id;
    this.name = name;
    this.cpf = cpf;
    this.email = email;
    this.birthDate = birthDate;
  }

  //Getters and Setters
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }
  public void setName(Integer id) {
    this.name = name;
  }

  public String getCpf() {
    return cpf;
  }
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }
  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  //Methods

}
