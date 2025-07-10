package main.java.com.rpxcard.service;


import main.java.com.rpxcard.model.Client;
import main.java.com.rpxcard.repository.FileRepository;
import main.java.com.rpxcard.util.inputValidator;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ClientServices {
  Scanner input  = new Scanner(System.in);

  //Serviço de Menu de clients
  public void menuRegisterClients() {
    FileRepository fileRepository = new FileRepository();
    fileRepository.readClientForm();
  }

  //Serviço de cadastro de Clientes
  public ArrayList<Client> registerClients() {
    String idClientStr, nameClient, cpfClient, emailClient, birthDateClient;
    ArrayList<Client> clientList = new ArrayList<>();

    System.out.println();
    System.out.println("--------- REGISTRO DE CLIENTE -----------");

    // Id
    while (true) {
      System.out.print("Id: ");
      idClientStr = input.next();
      if(inputValidator.isValidId(idClientStr)) {
        break;
      }
      System.out.println("Id inválido, deve conter (6 dígitos)");
    }

    // Name
    input.nextLine(); //Buffer
    while (true) {
      System.out.print("Nome: ");
      nameClient = input.nextLine();
      if (inputValidator.isValidName(nameClient)) {
        break;
      }
      System.out.println("Nome inválido, deve conter (nome + sobrenome)");
    }

    // Cpf
    while (true) {
      System.out.print("Cpf: ");
      cpfClient = input.next();
      if (inputValidator.isValidCpf(cpfClient)) {
        break;
      }
      System.out.println("Cpf inválido, deve conter (somente números e 11 dígitos)");
    }

    // Email
    while (true) {
      System.out.print("Email: ");
      emailClient = input.next();
      if (inputValidator.isValidEmail(emailClient)) {
        break;
      }
      System.out.println("Email inválido");
    }

    //birthDate
    while (true) {
      System.out.print("Data de nascimento: ");
      birthDateClient = input.next();
      if (inputValidator.isValidBirthDate(birthDateClient)) {
        System.out.println("Deu bom!");
        break;
      }
      System.out.println("Data inválida, deve conter (dd/MM/yyyy)");
    }

    //Conversão String -> Int
    Integer idClient = Integer.parseInt(idClientStr);

    clientList.add(new Client(idClient, nameClient, cpfClient, emailClient, birthDateClient));

    return clientList;

  }

  //Criação e nomeação do arquivo com dados do usuário e salvar em arquivo os dados do cliente
  public void createClientFileData(ArrayList<Client> clientsList) {

    String entirePath = clientsList.getFirst().getBirthDate().toString()+ "-" + clientsList.getFirst().getName().toUpperCase() + ".txt";
    String pathNoSpace = entirePath.replaceAll("\\s+", "");

    File dataClientFile = new File("C:\\Users\\redev\\OneDrive\\Documentos\\RPXCard\\src\\main\\java\\com\\rpxcard\\data\\clientRegistration\\" + pathNoSpace);

    if (!dataClientFile.exists()) {
      try {
        boolean created = dataClientFile.createNewFile();
        if (created) {
          System.out.println("Arquivo criado com sucesso!");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    //Inserir dados do usuário no arquivo criado
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(dataClientFile, true))) {
      bw.write("1 - " + clientsList.getFirst().getId());
      bw.newLine();
      bw.write("2 - " + clientsList.getFirst().getName());
      bw.newLine();
      bw.write("3 - " + clientsList.getFirst().getCpf());
      bw.newLine();
      bw.write("4 - " + clientsList.getFirst().getEmail());
      bw.newLine();
      bw.write("5 - " + clientsList.getFirst().getBirthDate());
      bw.newLine();
      System.out.println("Cliente salvo com sucesso!");
    } catch (IOException ioe) {
      System.out.println("Erro ao salvar o cliente: " + ioe.getMessage());
    }
  }

}

