package main.java.com.rpxcard.service;


import main.java.com.rpxcard.model.Client;
import main.java.com.rpxcard.repository.FileRepository;

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

    Integer idClient;
    String nameClient, cpfClient, emailClient, birthDateClient;
    ArrayList<Client> clientList = new ArrayList<>();

    System.out.println();
    System.out.println("--------- REGISTRO DE CLIENTE -----------");

    idClient = idClientValidation(input);
    nameClient = nameClientValidation(input);
    cpfClient = cpfClientValidation(input);
    emailClient = emailClientValidation(input);
    birthDateClient = String.valueOf(birthDateClientValidation(input));

    clientList.add(new Client(idClient, nameClient, cpfClient, emailClient, birthDateClient));

    return clientList;

  }

  //Serviço de validação dos inputs do cliente
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

    String clientName;
    Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\p{L}'\\\\s]+ [a-zA-Z\\p{L}'\\\\s]+$");

    while (true) {
      try {
        System.out.print("Nome: ");
        clientName = input.nextLine();
        if (clientName == null || !NAME_PATTERN.matcher(clientName).matches()) {
          System.out.println("Nome inválido (Digite nome e sobrenome e apenas letras!)");
        } else {
          return clientName;
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
    Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

    while (true) {
      try {
        System.out.print("Email: ");
        emailClient = input.next();
        if (emailClient == null || !EMAIL_PATTERN.matcher(emailClient).matches()) {
          System.out.println("Email inválido, siga o padrão - xxxxx@xxx.com");
        } else {
          return emailClient;
        }
      } catch (InputMismatchException ime) {
        System.out.println(ime.getMessage());
      }
    }
  }

  public static LocalDate birthDateClientValidation (Scanner input) {
    //Receber e validar a data de nascimento
    input.nextLine(); //buffer
    String birthDateClient;
    Pattern BIRTH_DATE_PATTERN = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    while (true) {
      System.out.print("Data: ");
      birthDateClient = input.nextLine();

      //Validar o formato da data
      if (!BIRTH_DATE_PATTERN.matcher(birthDateClient).matches()) {
        System.out.println("Formato de data Inválido!");
        continue;
      }

      //formata e valida a data
      try {
        LocalDate data = LocalDate.parse(birthDateClient, formatter);
        return data;

      } catch (DateTimeParseException dtpe) {
        System.out.println("Data inexistente no calendário!");
      }
    }
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

