package main.java.com.rpxcard.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRepository {
  String pathClient = "C:\\Users\\redev\\OneDrive\\Documentos\\RPXCard\\src\\main\\java\\com\\rpxcard\\data\\clientForm.txt";
  String pathCard = "C:\\Users\\redev\\OneDrive\\Documentos\\RPXCard\\src\\main\\java\\com\\rpxcard\\data\\cardForm.txt";
  public void readClientForm() {
    try (BufferedReader br = new BufferedReader(new FileReader(pathClient))) {
      String line = br.readLine();

      //Enquanto houver conteúdo, leia!
      while (line != null) {
        System.out.println(line);
        line = br.readLine();
      }
    } catch (IOException ie) {
      System.out.println(ie.getMessage());
    }
  }

  public void readCardForm() {
    try (BufferedReader br = new BufferedReader(new FileReader(pathCard))) {
      String line = br.readLine();

      while (line != null) {
        System.out.println(line);
        line = br.readLine();
      }
    } catch (IOException ie) {
      System.out.println(ie.getMessage());
    }
  }
}
