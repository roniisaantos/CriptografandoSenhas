package utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static Scanner entrada = new Scanner(System.in);

    public static void menuPrincipal() {

        int opcao = 0;

        while (true) {

            System.out.print("""
                    -------------- MENU PRINCIPAL --------------
                    [1] - CODIFICAR SENHA
                    [2] - DESCODIFICAR SENHA
                    [3] - FECHAR PROGRAMA
                    --------------------------------------------
                    --> Escolha uma opção:""" + " ");

            try {
                opcao = entrada.nextInt();
                entrada.nextLine();

                switch (opcao) {
                    case 1: {
                        System.out.print("\nDigite uma senha para criptografar: ");
                        String senha = entrada.nextLine();
                        Codificador.codificarSenha(senha);
                        Codificador.exibirSenhaCodificada(Codificador.senhaCodificada);
                        Codificador.senhaCodificada.clear();
                        System.out.println("\n");
                        continue;
                    }
                    case 2: {
                        System.out.print("\nDigite uma senha criptografada: ");
                        String senha = entrada.nextLine();
                        Descodificador.descodificarSenha(senha);
                        System.out.println("\n");
                        continue;
                    }
                    case 3: {
                        System.exit(0);
                    }
                    default: {
                        System.out.println("\nEscolha uma opção válida!\n");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Use somente números para navegar pelo menu! ;)\n");
                entrada.nextLine();
            }
        }
    }
}
