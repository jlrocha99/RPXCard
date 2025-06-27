package main.java.com.rpxcard.service;

import java.util.Scanner;

public class PrintMenu {
  public int showMainMenu() {
    Scanner input = new Scanner(System.in);

    System.out.println("========================================================");
    System.out.println("             RPXCard - Sistema de Cartões               ");
    System.out.println("========================================================");

    System.out.println("Bem-vindo ao RPXCard!");
    System.out.println("Escolha uma das opções abaixo para começar:");

    System.out.println("[1] Cadastrar novos clientes");
    System.out.println("[2] Emitir novo cartão");
    System.out.println("[3] Consultar Cliente");
    System.out.println("[4] Consultar cartões de cliente");
    System.out.println("[5] Realizar Compra");
    System.out.println("[6] Registrar pagamento");
    System.out.println("[7] Consultar extrato do cartão");
    System.out.println("[8] Sair");

    System.out.println();
    System.out.println("========================================================");

    //validação do meu input
    return numberInRange(input);

  }

  //Validação da entrada
  public int numberInRange(Scanner input) {
    while (true) {
      System.out.print("Digite um número de 1 a 8: ");

      if (input.hasNextInt()) {
        int num = input.nextInt();
        input.nextLine();
        if (num >= 1 && num <= 8) {
          return num;
        }
        else {
          System.out.println("Número Fora do intervalo, tente novamente!");
        }
      }
      else {
        System.out.println("Entrada Inválida. Digite apenas números.");
        input.nextLine();
      }
    }
  }
}
