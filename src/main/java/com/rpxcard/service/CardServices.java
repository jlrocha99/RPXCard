package main.java.com.rpxcard.service;

import main.java.com.rpxcard.model.Card;
import main.java.com.rpxcard.model.Client;
import main.java.com.rpxcard.repository.FileRepository;
import main.java.com.rpxcard.util.inputValidator;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

import static main.java.com.rpxcard.util.FileUtils.*;

public class CardServices {
  Scanner input = new Scanner(System.in);

  //Serviço do Menu de cartão
  public void menuRegisterCards() {
    FileRepository fileRepository = new FileRepository();
    fileRepository.readCardForm();

    //Serviço de menu do cartão

  }

  //Serviço de cadastro de cartões
  public void registerCards() {
    String idCard, numberCard;
    String birthDateClient,nameClient;
    Double totalLimit, availableLimit;
    String status;
    LocalDateTime cardCreationDate;

    Client client;

    System.out.println();
    System.out.println("---------------- REGISTRO DE CARTÕES ----------------");

    String pathClientFile = clientFinder();

    if (pathClientFile == null) {
      return;
    }

    //Instanciação do card
    Card card = new Card();
    card.setId(generateIdCard());
    card.setCardNumber(generateNumberCard());
    card.setTotalLimit(generateLimit());
    card.setAvailableLimit(generateLimit());
    card.setStatus("ATIVO");
    card.setCardCreationDate(LocalTime.now());

    //Salvar card em arquivo.txt
    createCardFile(card);

    //System.out.println("caminho do arquivo" + pathCardFile);

    //Leitura do cliente vinculado ao cartão
    client = readClientFile(pathClientFile);
    //Vinculação client-card
    card.setClient(client);

    //Preenchimento do arquivo card com a vinculação concluída
    saveCardDataFile(card);
    System.out.println("\nDados do cartão: " + card);
  }

  //Método monta uma string recebida e localiza a existência do cliente específico no meu clientRegistration
  public static String clientFinder() {
    Scanner input = new Scanner(System.in);
    String birthDateClient;
    String clientName;

    //Valída a data de nascimento
    while (true) {
      System.out.print("Data de nascimento do Cliente: ");
      birthDateClient = input.next();
      if (inputValidator.isValidBirthDate(birthDateClient)) {
        birthDateClient = String.valueOf(LocalDate.parse(birthDateClient, DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Data Válida");
        break;
      }
      System.out.println("Data inválida, deve ter o formato (dd/MM/yyyy)");
    }

    //Valida o nome do cliente
    input.nextLine();//buffer
    while (true) {
      System.out.print("Nome do Cliente: ");
      clientName = input.nextLine();
      if (inputValidator.isValidName(clientName)) {
        System.out.println("Nome Válido");
        break;
      }
      System.out.println("Nome inválido, deve conter (nome + sobrenome)");
    }

    String pathNoSpace = clientName.replaceAll("\\s+", "");
    clientName = pathNoSpace.toUpperCase();
    String completePath = birthDateClient + "-" + clientName + ".txt"; //String completa

    //Path completo
    File file = new File("C:\\Users\\redev\\OneDrive\\Documentos\\RPXCard\\src\\main\\java\\com\\rpxcard\\data\\clientRegistration\\" + completePath);

    if (file.exists()) {
      System.out.println("Cliente Encontrado");
      return file.getPath();
    } else {
      System.out.println("Cliente não encontrado");
      return null;
    }

  }

  //Método para gerar os dados do cartão
  public static int generateIdCard() {
    //Gerar um id aleatório de 4 dígitos para o meu card e retornar esse valor.
    Random randomId = new Random();
    long min = 1000L;
    long max = 9999L;
    return (int) (min + randomId.nextInt((int)(max - min + 1)));

  }

  public static StringBuilder generateNumberCard() {
    StringBuilder numberCard = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 16; i++) {
      numberCard.append(random.nextInt(10)); // 0-9
    }
    return numberCard;
  }

  public static Double generateLimit() {
    return 1000.00;
  }

}

