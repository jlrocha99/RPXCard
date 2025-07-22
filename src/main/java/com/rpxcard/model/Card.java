package main.java.com.rpxcard.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Card {
  private Integer id;
  private StringBuilder cardNumber;
  private Double totalLimit;
  private Double availableLimit;
  private String status;
  private LocalTime cardCreationDate;
  private Client client;  //elo de ligação entre Client e Card

  public Card() {
  }
  public Card(Integer id, StringBuilder cardNumber, Double totalLimit, Double availableLimit, String status, String cardCreationDate, Client client) {
    this.id = id;
    this.cardNumber = cardNumber;
    this.totalLimit = totalLimit;
    this.availableLimit = availableLimit;
    this.status = status;
    this.cardCreationDate = LocalTime.parse(cardCreationDate);
    this.client = client;
  }

  public long getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public StringBuilder getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(StringBuilder cardNumber) {
    this.cardNumber = cardNumber;
  }

  public Double getTotalLimit() {
    return totalLimit;
  }

  public void setTotalLimit(Double totalLimit) {
    this.totalLimit = totalLimit;
  }

  public Double getAvailableLimit() {
    return availableLimit;
  }

  public void setAvailableLimit(Double availableLimit) {
    this.availableLimit = availableLimit;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public LocalTime getCardCreationDate() {
    return cardCreationDate;
  }

  public void setCardCreationDate(LocalTime cardCreationDate) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String formated = cardCreationDate.format(formatter);
    this.cardCreationDate = LocalTime.parse(formated);
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public String toString() {
    return ("\nid do cartão: " + id + "\n"
        + "Número do cartão: " + cardNumber.toString() + "\n"
        + "Limite do cartão: " + totalLimit + "\n"
        + "Limite Disponível: " + availableLimit + "\n"
        + "Status: " + status + "\n"
        + "Data de criação do cartão: " + cardCreationDate + "\n"
        + "Cliente vinculado: " + client.getName() + "\n");
  }
}

