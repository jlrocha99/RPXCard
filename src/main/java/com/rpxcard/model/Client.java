package main.java.com.rpxcard.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
  private Integer id;
  private String name;
  private String cpf;
  private String email;
  private LocalDate birthDate;

  //Constructors
  public Client() {
  }
  public Client(String id, String name, String cpf, String email, String birthDate) {
    this.id = Integer.parseInt(id);
    this.name = name;
    this.cpf = cpf;
    this.email = email;
    this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    //conversões de tipo na instanciação por conta da validação com Regex.
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

  public String toString() {
    return (
        id + name + cpf + email + birthDate
        );
  }

}
