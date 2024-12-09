package utilidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Codificador {

    public static char[] caracteres = new char[94];
    public static ArrayList<String> senhaCodificada = new ArrayList<>();

    public static Random sortear = new Random();


    public static void preenchendoCaracteres() {

        for (int i = 0; i < caracteres.length; i++) {
            caracteres[i] = (char) (33 + i);
        }
    }


    public static String gerarStringsAleatorias() {

        ArrayList<String> listaEmbaralhada = new ArrayList<>();

        String primeiroValor = "" + caracteres[sortear.nextInt(32, 58)];
        listaEmbaralhada.add(0, "" + sortear.nextInt(10));
        listaEmbaralhada.add(1, "" + sortear.nextInt(10));
        listaEmbaralhada.add(2, "" + caracteres[sortear.nextInt(32, 58)]);
        listaEmbaralhada.add(3, "" + caracteres[sortear.nextInt(32, 58)]);


        Collections.shuffle(listaEmbaralhada);

        return primeiroValor +
                listaEmbaralhada.get(0) + listaEmbaralhada.get(1) +
                listaEmbaralhada.get(2) + listaEmbaralhada.get(3);
    }


    public static void codificarSenha(String senha) {

        int controleSenha = 0;
        int controleComparacao = 0;

        while (controleSenha < senha.length()) {

            if (senha.charAt(controleSenha) != caracteres[controleComparacao]) {
                controleComparacao++;
            } else {
                String indiceFormatado = String.format("%02d", controleComparacao);
                senhaCodificada.add(indiceFormatado + gerarStringsAleatorias());
                controleSenha++;
                controleComparacao = 0;
            }
        }
    }

    public static void exibirSenhaCodificada(ArrayList<String> senhaCodificada) {

        System.out.print("\nSenha codificada: ");
        for (String s : senhaCodificada) {
            System.out.print(s);
        }
    }
}
