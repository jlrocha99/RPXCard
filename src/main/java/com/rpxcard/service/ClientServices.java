package main.java.com.rpxcard.service;


import main.java.com.rpxcard.model.Client;
import main.java.com.rpxcard.repository.FileRepository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ClientServices {
  Scanner input  = new Scanner(System.in);

  //Serviço de Menu de clients
  public void menuRegisterClients() {
    FileRepository fileRepository = new FileRepository();
    fileRepository.readFile();

    //preciso ler as perguntas do formulario.txt e armazenar as respostas em um objeto do tipo Client
  }

  //Serviço de cadastro de Clientes
  public ArrayList<Client> registerClients() {
    Integer idClient;
    String nameClient, cpfClient, emailClient;
    //data
    ArrayList<Client> clientsList = new ArrayList<>();

    System.out.println();
    System.out.println("--------- REGISTRO DE CLIENTE -----------");

    idClient = idClientValidation(input);
    System.out.println("IdClient realizado com sucesso: " + idClient);
    nameClient = nameClientValidation(input);
    System.out.println("NameCLient realizado com sucesso: " + nameClient);
    cpfClient = cpfClientValidation(input);
    System.out.println("CpfCLient realizado com sucesso: " + cpfClient);
    emailClient = emailClientValidation(input);
    System.out.println("EmailCLient realizado com sucesso: " + emailClient);

    return null;
  }

  public static Integer idClientValidation (Scanner input) {
    //Receber e validar o Id
    Integer idClient;

    while(true) {
      try {
        System.out.print("Id: ");
        if (input.hasNextInt()) {
          idClient = input.nextInt();
          input.nextLine(); //buffer do id
          return idClient;
        }
        else {
          System.out.println("Entrada Inválida. Digite um número inteiro");
          input.nextLine();
        }

      }catch (InputMismatchException ime) {
        System.out.println(ime.getMessage());
        input.nextLine();
      }
    }
  }

  public static String nameClientValidation (Scanner input) {
    //Receber e validar o nome

    String nameClient;
    Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z]+ [a-zA-Z]+$");

    while (true) {
      try {
        System.out.print("Nome: ");
        nameClient = input.nextLine();
        if (nameClient == null || !NAME_PATTERN.matcher(nameClient).matches()) {
          System.out.println("Nome inválido (Digite nome e sobrenome e apenas letras!)");
        } else {
          return nameClient;
        }
      } catch (InputMismatchException ime) {
        System.out.println(ime.getMessage());
      }
    }
  }

  public static String cpfClientValidation (Scanner input) {
    //Receber e validar o Cpf
    String cpfClient;
    Pattern CPF_PATTERN = Pattern.compile("^[0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-?[0-9]{2}");

    while (true) {
      try {
        System.out.print("Cpf: ");
        cpfClient = input.next();
        if (cpfClient == null || !CPF_PATTERN.matcher(cpfClient).matches()) {
          System.out.println("Cpf inválido, siga o padrão - XXX.XXX.XXX-XX");
        } else {
          return cpfClient;
        }
      } catch (InputMismatchException ime) {
        System.out.println(ime.getMessage());
      }
    }
  }

  public static String emailClientValidation (Scanner input) {
    //Receber e validar email
    String emailClient;
    Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z][@][a-zA-Z][.com]$"); //Organizar esse Pattern

    while (true) {
      try {
        System.out.print("Email: ");
        emailClient = input.next();
        if (emailClient == null || EMAIL_PATTERN.matcher(emailClient).matches()) {
          System.out.println("Email inválido, siga o padrão - xxxxx@xxx.com");
        } else {
          System.out.println("Deu certo");
          return emailClient;
        }
      } catch (InputMismatchException ime) {
        System.out.println(ime.getMessage());
      }
    }
  }

  //Criar a validação do birthDate
}
