package main.java.com.rpxcard.util;

import main.java.com.rpxcard.model.Client;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

  //Cria e nomeia o arquivo
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
      bw.write("1 - " + client.getId());
      bw.newLine();
      bw.write("2 - " + client.getName());
      bw.newLine();
      bw.write("3 - " + client.getCpf());
      bw.newLine();
      bw.write("4 - " + client.getEmail());
      bw.newLine();
      bw.write("5 - " + client.getBirthDate());
      bw.newLine();
      System.out.println("Cliente salvo com sucesso!");
    } catch (IOException ioe) {
      System.out.println("Erro ao salvar o cliente: " + ioe.getMessage());
    }
  }
}
