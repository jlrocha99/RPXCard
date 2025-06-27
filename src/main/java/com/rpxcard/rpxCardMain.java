package main.java.com.rpxcard;

import main.java.com.rpxcard.service.PrintMenu;
import main.java.com.rpxcard.service.RegisterClients;

import java.util.Locale;
import java.util.Scanner;

public class rpxCardMain {
  public static void main(String[] args) {
    Locale.setDefault(Locale.US);
    Scanner input = new Scanner(System.in);

    PrintMenu printMenu = new PrintMenu();
    int choice  = printMenu.showMainMenu();

    System.out.println("Numero digitado: " + choice);

    switch (choice) {
      case 1:
        RegisterClients registerClients = new RegisterClients();
        registerClients.MenuRegisterClients();
        break;

      case 2:
        System.out.println("Em fase de construção");
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

      case 8:
        System.out.println("Em fase de construção");
        break;
    }


  }
}
