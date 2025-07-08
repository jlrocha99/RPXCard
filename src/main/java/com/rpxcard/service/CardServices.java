package main.java.com.rpxcard.service;

import main.java.com.rpxcard.model.Card;
import main.java.com.rpxcard.model.Client;
import main.java.com.rpxcard.repository.FileRepository;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CardServices {
  Scanner input = new Scanner(System.in);

  //Serviço do Menu de cartão
  public void menuRegisterCards() {
    FileRepository fileRepository = new FileRepository();
    fileRepository.readCardForm();

    //Serviço de menu do cartão

  }

  //Serviço de cadastro de cartões
  public ArrayList<Card> registerCards(ArrayList<Client> clientLists) {
    Integer id, cardNumber;
    Double totalLimit, availableLimit;
    String status;
    LocalDateTime cardCreationDate;
    Client client;

    ArrayList<Card> cardList = new ArrayList<>();
    System.out.println();
    System.out.println("---------------- REGISTRO DE CARTÕES ----------------");
    id = idCardValidation(input);
    System.out.println("idNumber: " + id);
    cardNumber = cardNumberValidation(input);
    System.out.println("cardNumber: " + cardNumber);

    return null;

  }

  //Método que localiza um client específico
  public static File findClientFile(Scanner birthDate, Scanner name) {
    String birthDateClient;
    String clientName;
    Pattern BIRTH_DATE_PATTERN = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$");
    Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\p{L}'\\\\s]+ [a-zA-Z\\p{L}'\\\\s]+$");

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    while (true) {
      System.out.print("Digite a data de aniversário do cliente: ");
      birthDateClient = birthDate.nextLine();
      //Validar o formato da data
      if (!BIRTH_DATE_PATTERN.matcher(birthDateClient).matches()) {
        System.out.println("Formato de data Inválido!");
        continue;
      }
      //Validar o nome
      System.out.print("Digite o nome do client: ");
      clientName = name.nextLine();
      if (clientName == null && !NAME_PATTERN.matcher(clientName).matches()) {
        System.out.println("Nome inválido");
        continue;
      }

      //formata e valida a data
      try {
        LocalDate data = LocalDate.parse(birthDateClient, formatter);
        //Ex: 1999-12-22

      } catch (DateTimeParseException dtpe) {
        System.out.println("Data inexistente no calendário!");
      }
    }

    //Nota: Preciso pensar se eu continuo fazendo essa validação ou se
    //de alguma forma eu reutilizo as validações do ClientServices para a
    //criação do meu Card.



  }
  //Serviço de validação dos inputs dos cartões
  public static Integer idCardValidation(Scanner input) {
    //recebe o valor e valida o ID
    Integer idCard;

    while (true) {
      try {
        System.out.print("Id: ");
        if (input.hasNextInt()) {
          idCard = input.nextInt();
          input.nextLine(); //Buffer id
          System.out.println("foi");
          return idCard;
        }
        else {
          System.out.println("Entrada inválida, Digite um número inteiro");
          input.nextLine(); //consumir o buffer evitando um loop infinito
        }
      } catch (InputMismatchException ime) {
        System.out.println(ime.getMessage());
      }
    }
  }

  public static Integer cardNumberValidation(Scanner input) {
    Integer cardNumber;
    while (true) {
      try {
        System.out.print("Id: ");
        if (input.hasNextInt()) {
          cardNumber = input.nextInt();
          input.nextLine(); //Buffer id
          System.out.println("foi");
          return cardNumber;
        }
        else {
          System.out.println("Entrada inválida, Digite um número inteiro");
          input.nextLine(); //consumir o buffer evitando um loop infinito
        }
      } catch (InputMismatchException ime) {
        System.out.println(ime.getMessage());
      }
    }

  }

  public static Double totalLimitCardValidation(Scanner input) {

  }
}

