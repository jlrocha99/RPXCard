package main.java.com.rpxcard.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileRepository {
  String path = "C:\\Users\\redev\\OneDrive\\Documentos\\RPXCard\\src\\main\\java\\com\\rpxcard\\data\\formulario.txt";

  public void readFile() {
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
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

}
