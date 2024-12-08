package utilidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Codificador {

    public static char[] caracteres = new char[104];
    public static ArrayList<String> senhaCodificada = new ArrayList<>();

    public static Random sortear = new Random();


    public static void preenchendoCaracteres() {

        for (int i = 0; i < caracteres.length; i++) {
            if (i < 10){
                caracteres[i] = '0';
            } else {
                caracteres[i] = (char) (33 + (i - 10));
            }

        }
    }


    public static String gerarStringsAleatorias() {

        ArrayList<String> listaEmbaralhada = new ArrayList<>();

        String primeiroValor = "" + caracteres[sortear.nextInt(42, 68)];
        listaEmbaralhada.add(0, "" + sortear.nextInt(10));
        listaEmbaralhada.add(1, "" + sortear.nextInt(10));
        listaEmbaralhada.add(2, "" + caracteres[sortear.nextInt(42, 68)]);
        listaEmbaralhada.add(3, "" + caracteres[sortear.nextInt(42, 68)]);


        Collections.shuffle(listaEmbaralhada);

        return primeiroValor +
                listaEmbaralhada.get(0) + listaEmbaralhada.get(1) +
                listaEmbaralhada.get(2) + listaEmbaralhada.get(3);
    }


    public static void codificarSenha(String senha) {

        int controleSenha = 0;
        int controleComparacao = 10;

        while (controleSenha < senha.length()) {

            if (senha.charAt(controleSenha) != caracteres[controleComparacao]) {
                controleComparacao++;
            } else {
                senhaCodificada.add(controleComparacao + gerarStringsAleatorias());
                controleSenha++;
                controleComparacao = 10;
            }
        }
    }
}
