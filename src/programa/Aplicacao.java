package programa;

import utilidades.Codificador;
import utilidades.Descodificador;

import java.util.Scanner;

public class Aplicacao {

    public static void main(String[] args) {

        Codificador.preenchendoCaracteres();

        System.out.print("Digite uma senha para criptografar: ");

        Scanner entrada = new Scanner(System.in);
        String senha = entrada.nextLine();

        Codificador.codificarSenha(senha);

        System.out.print("Senha criptografada: ");
        for (int i = 0; i < Codificador.senhaCodificada.size(); i++) {
            System.out.print(Codificador.senhaCodificada.get(i));
        }

        System.out.println("\n\n\nAgora vamos descodificar a senha!");
        System.out.print("Digite a senha criptografada: ");
        String senhaCodificada = entrada.nextLine();

        Descodificador.descodificarSenha(senhaCodificada);

        System.out.print("\nSenha descriptografada: ");
        for (int i = 0; i < Descodificador.senhaDescodificada.size(); i++) {
            System.out.print(Descodificador.senhaDescodificada.get(i));
        }
    }
}