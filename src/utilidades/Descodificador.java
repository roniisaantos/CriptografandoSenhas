package utilidades;

import java.util.ArrayList;

public class Descodificador {

    public static ArrayList<Character> senhaDescodificada = new ArrayList<>();

    public static void descodificarSenha(String senha) {

        int controleSenha = 0;
        int index;
        String stringIndex;

        while (senhaDescodificada.size() < senha.length() / 7) {

            stringIndex = "" + senha.charAt(controleSenha) + senha.charAt(controleSenha + 1);
            index = Integer.parseInt(stringIndex);

            senhaDescodificada.add(Codificador.caracteres[index]);
            controleSenha += 7;
        }
    }
}

