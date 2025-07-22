package main.java.com.rpxcard.util;

import main.java.com.rpxcard.model.Card;
import main.java.com.rpxcard.model.Client;

import java.io.*;

public class FileUtils {

  //FILES
  //Cria e nomeia um arquivo Client
  public static File createClientFile(Client client) {
    String entirePath = client.getBirthDate()+ "-" + client.getName().toUpperCase() + ".txt";
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
    return dataClientFile;
  }

  //Preenche arquivo
  public void SaveClientDataFile(Client client) {
    //Inserir dados do usuário no arquivo criado
    File clientPath = createClientFile(client);
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(clientPath, true))) {
      bw.write("ID:  " + client.getId());
      bw.newLine();
      bw.write("Nome: " + client.getName());
      bw.newLine();
      bw.write("CPF: " + client.getCpf());
      bw.newLine();
      bw.write("Email: " + client.getEmail());
      bw.newLine();
      bw.write("Data de Nascimento: " + client.getBirthDate());
      bw.newLine();
    } catch (IOException ioe) {
      System.out.println("Erro ao salvar o cliente: " + ioe.getMessage());
    }
  }

  //CARDS
  //Cria e nomeia um arquivo Card
  public static File createCardFile(Card card) {
    String entirePath = "card" + "_" + card.getCardNumber() + ".txt";
    String pathNoSpace = entirePath.replaceAll("\\s+", "");

    //Caminho completo
    File dataCardFile = new File("C:\\Users\\redev\\OneDrive\\Documentos\\RPXCard\\src\\main\\java\\com\\rpxcard\\data\\cardRegistration\\" + pathNoSpace);

    if (!dataCardFile.exists()) {
      try {
        boolean created = dataCardFile.createNewFile();
        if (created) {
          System.out.println("Arquivo criado com sucesso!");
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return dataCardFile;
  }

  //Ler os dados de um cliente gravado em .txt e reconstruir um objeto Client na memória
  public static Client readClientFile(String pathClientFile) {
    File file = new File(pathClientFile);
    String id = "";
    String name = "", cpf = "", email = "";
    String birthDate = "";

    try {
      BufferedReader br = new BufferedReader(new FileReader(file));
      String line;
      while ((line = br.readLine()) != null) {
        if (line.startsWith("ID: ")) {
          id = line.substring(4).trim();
        }
        else if (line.startsWith("Nome: ")) {
          name = line.substring(6).trim();
        }
        else if (line.startsWith("CPF: ")) {
          cpf = line.substring(4).trim();
        }
        else if (line.startsWith("Email: ")) {
          email = line.substring(7).trim();
        }
        else if (line.startsWith("Data de Nascimento: ")) {
          birthDate = line.substring(20).trim();  //->"yyyy-MM-dd"

          //Mudando a formatação para o padrão "dd/MM/yyyy"
          birthDate = birthDate.replace("-", "/");
          String[] fragments = birthDate.split("/");  //-> ["yyyy", "MM", "dd"]
          birthDate = fragments[2] + "/" + fragments[1] + "/" + fragments[0]; // -> "dd/MM/yyyy"
        }
      }
    } catch (IOException ioe) {
      System.out.println(ioe.getMessage());
    }
    //retorno meu objeto Client montado
    return new Client (id, name, cpf, email, birthDate);

  }

  //Preenche o arquivo card.txt
  public static void saveCardDataFile(Card card) {
    File cardPath = createCardFile(card);

    try(BufferedWriter bw = new BufferedWriter(new FileWriter(cardPath, true))) {
      bw.write("Id do cartão: " + card.getId());
      bw.newLine();
      bw.write("Número do cartão: " + card.getCardNumber());
      bw.newLine();
      bw.write("limite Total: " + card.getTotalLimit());
      bw.newLine();
      bw.write("Limite Disponível: " + card.getAvailableLimit());
      bw.newLine();
      bw.write("Status: " + card.getStatus());
      bw.newLine();
      bw.write("Hora da Criação: " + card.getCardCreationDate());
      bw.newLine();
      bw.write("Cliente: " + card.getClient().getName());
      bw.newLine();
      //encerramento do arquivo automático
    } catch (IOException ioe) {
      System.out.println("Erro ao salvar o cartão: " + ioe.getMessage());
      //deu tudo certo, mas surgiu esse erro e o arquivo só está sendo criado após encerrar o programa
    }
  }
}
