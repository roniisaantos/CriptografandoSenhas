package utilidades;

import java.util.ArrayList;

public class Descodificador {

    public static ArrayList<Character> senhaDescodificada = new ArrayList<>();

    public static void descodificarSenha(String senhaCodificada){

        int controleSenha = 0;
        int index;
        String stringIndex;

        senhaDescodificada.clear();

        if (!testarFormatoSenha(senhaCodificada)){
            System.out.println("\nErro! O token de senha inserido não foi gerado pelo nosso sistema.");
            return;
        }

        while (senhaDescodificada.size() < senhaCodificada.length() / 7) {

            stringIndex = "" + senhaCodificada.charAt(controleSenha) + senhaCodificada.charAt(controleSenha + 1);
            index = Integer.parseInt(stringIndex);

            senhaDescodificada.add(Codificador.caracteres[index]);
            controleSenha += 7;

        }
        exibirSenhaDescodificada();
    }

    public static void exibirSenhaDescodificada(){

        System.out.print("\nSenha descodificada: ");
        for (Character c : senhaDescodificada) {
            System.out.print(c);
        }
    }

    public static boolean testarFormatoSenha(String senhaCodificada) {
        // Verifica se a senha é nula ou vazia
        if (senhaCodificada == null || senhaCodificada.isEmpty()) {
            return false;
        }

        // Verifica se o comprimento da senha é múltiplo de 7
        if (senhaCodificada.length() % 7 != 0) {
            return false;
        }

        // Verifica cada bloco de 7 caracteres
        for (int i = 0; i < senhaCodificada.length(); i += 7) {
            try {
                // Extrai os dois primeiros caracteres como índice
                String stringIndex = senhaCodificada.substring(i, i + 2);
                int index = Integer.parseInt(stringIndex);

                // Verifica se o índice está dentro do intervalo válido
                if (index < 0 || index >= Codificador.caracteres.length) {
                    return false;
                }
            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                // Retorna falso se a conversão falhar ou o bloco for malformado
                return false;
            }
        }

        return true;
    }
}

