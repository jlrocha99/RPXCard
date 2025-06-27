package main.java.com.rpxcard.service;

import main.java.com.rpxcard.repository.FileRepository;

public class RegisterClients {
  public void MenuRegisterClients() {
    FileRepository fileRepository = new FileRepository();
    fileRepository.readFile();

    //preciso ler as perguntas do formulario.txt e armazenar as respostas em um objeto do tipo Client
  }

}
