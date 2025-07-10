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

    String birthDate = null;
    String name;

    //findClientFile(bir, name);

    return null;

  }

  //Método que localiza um client específico
  public static String findClientFile(Scanner birthDate, Scanner name) {
    Scanner input = new Scanner(System.in);
    String birthDateClient;
    String clientName;
    /*
    ClientServices validation = new ClientServices();
    birthDateClient = ClientServices.nameClientValidation(birthDate);
    System.out.println(birthDateClient);

     */

    //System.out.println(birthDateClient);
    


    //Nota: Preciso pensar se eu continuo fazendo essa validação ou se
    //de alguma forma eu reutilizo as validações do ClientServices para a
    //criação do meu Card.

    return null;

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
    return null;
  }
}

