package site;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Metodos_cadastro_login {
    public void recepcao() {
        System.out.println("_______________________");
        System.out.println("Bem vindo ao DataSight");
        System.out.println("_______________________");

        System.out.println();

        System.out.println("Digite 1 para se cadastrar");
        System.out.println("Digite 2 se já tem cadastro");

    }

    public String cadastrar(
            String nomeCompleto,
            String email,
            String senha,
            List<String> listaNomeUsuario,
            List<String> listaEmailUsuario,
            List<String> listaSenhaUsuario) {

        String cadastrado = " Cadastro não efetuado";

        if (nomeCompleto.length() < 2) {
            return cadastrado += " Nome muito curto ";

        } else if (
                !email.contains("@") ||
                        !email.endsWith(".com")) {
            return cadastrado = " O email precisa conter ao menos um '@' e finalizar com '.com' \n" +
                    "Cadastro não efetuado!";

        } else if (
                senha.length() < 6 ||
                        senha.length() > 16) {
            return cadastrado = " O tamanho da sua senha é invalido";

        } else if (
                senha.contains("!") ||
                        senha.contains("@") ||
                        senha.contains("#") ||
                        senha.contains("$") ||
                        senha.contains("%") ||
                        senha.contains("¨") ||
                        senha.contains("&") ||
                        senha.contains("*") ||
                        senha.contains("(") ||
                        senha.contains(")") ||
                        senha.contains("+") ||
                        senha.contains("=") ||
                        senha.contains("-") ||
                        senha.contains("_")

        ) {
            listaNomeUsuario.add(nomeCompleto);
            listaEmailUsuario.add(email);
            listaSenhaUsuario.add(senha);

            return cadastrado = " cadastro efetuado";
        } else {
            return cadastrado = " A senha precisa conter ao menos 1 caractére especial";
        }
    }

    public Boolean verificarCadastro(
            List<String> listaNomeUsuario,
            List<String> listaEmailUsuario,
            List<String> listaSenhaUsuario,
            String email,
            String senha,
            Boolean encerrar) {

        String verificaUsuario = " email ou senha invalidos";


        for (int i = 0; i < listaEmailUsuario.size(); i++) {

            if (Objects.equals(listaEmailUsuario.get(i), email)
            ) {
                if (Objects.equals(listaSenhaUsuario.get(i), senha)) {
                    System.out.println("Usuario logado \n" +
                            " Bem vindo " + listaNomeUsuario.get(i));

                    encerrar = true;
                }
            }
        }
        return encerrar;
    }
}
