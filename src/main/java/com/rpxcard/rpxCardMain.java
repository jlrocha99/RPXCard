package main.java.com.rpxcard;

import main.java.com.rpxcard.model.Card;
import main.java.com.rpxcard.model.Client;
import main.java.com.rpxcard.service.CardServices;
import main.java.com.rpxcard.service.PrintMenu;
import main.java.com.rpxcard.service.ClientServices;
import main.java.com.rpxcard.util.FileUtils;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class rpxCardMain {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner input = new Scanner(System.in);

    PrintMenu printMenu = new PrintMenu();
    int choice = printMenu.showMainMenu();

    System.out.println("Numero digitado: " + choice);

    Client client;
    while (choice != 8) {
      switch (choice) {
        case 1:
          ClientServices clientServices = new ClientServices();
          clientServices.menuRegisterClients();
          clientServices.registerClients();
          //criar arquivo e guardar dados do client
          break;

        case 2:
          CardServices cardServices = new CardServices();
          cardServices.menuRegisterCards();
          //Card cards = cardServices.registerCards(client);
          break;

        case 3:
          System.out.println("Em fase de construção");
          break;

        case 4:
          System.out.println("Em fase de construção");
          break;

        case 5:
          System.out.println("Em fase de construção");
          break;

        case 6:
          System.out.println("Em fase de construção");
          break;

        case 7:
          System.out.println("Em fase de construção");
          break;
      }
      try {
        Thread.sleep(2000);
        choice = printMenu.showMainMenu();
      } catch (InterruptedException ie) {
        ie.printStackTrace();
      }
    }
  }
}
