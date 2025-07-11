package main.java.com.rpxcard.service;


import main.java.com.rpxcard.model.Client;
import main.java.com.rpxcard.repository.FileRepository;
import main.java.com.rpxcard.util.FileUtils;
import main.java.com.rpxcard.util.inputValidator;
import java.util.Scanner;

public class ClientServices {
  Scanner input  = new Scanner(System.in);

  //Serviço de Menu de clients
  public void menuRegisterClients() {
    FileRepository fileRepository = new FileRepository();
    fileRepository.readClientForm();
  }

  //Serviço de cadastro de Clientes
  public void registerClients() {
    String idClient, nameClient, cpfClient, emailClient, birthDateClient;

    System.out.println();
    System.out.println("--------- REGISTRO DE CLIENTE -----------");

    // Id
    while (true) {
      System.out.print("Id: ");
      idClient = input.next();
      if(inputValidator.isValidId(idClient)) {
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

    input.nextLine();//buffer
    while (true) {
      System.out.print("Data de nascimento: ");
      birthDateClient = input.nextLine();
      if (inputValidator.isValidBirthDate(birthDateClient)) {
        break;
      }
      System.out.println("Data inválida, deve conter (dd/MM/yyyy)");
    }
    FileUtils fileUtils = new FileUtils();

    Client client = new Client(idClient, nameClient, cpfClient, emailClient, birthDateClient);
    fileUtils.SaveClientDataFile(client);
  }



}

