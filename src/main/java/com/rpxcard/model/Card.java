package main.java.com.rpxcard.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Card {
  private Integer id;
  private Integer cardNumber;
  private Double totalLimit;
  private Double availableLimit;
  private String status;
  private LocalDateTime cardCreationDate;
  private Client client;

  public Card(Integer id, Integer cardNumber, Double totalLimit, Double availableLimit, String status, LocalDate cardCreationDate, Client client) {
    this.id = id;
    this.cardNumber = cardNumber;
    this.totalLimit = totalLimit;
    this.availableLimit = availableLimit;
    this.status = status;
    this.cardCreationDate = cardCreationDate.atStartOfDay();
    this.client = client;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(Integer cardNumber) {
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

  public LocalDateTime getCardCreationDate() {
    return cardCreationDate;
  }

  public void setCardCreationDate(LocalDateTime cardCreationDate) {
    this.cardCreationDate = cardCreationDate;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }
}

