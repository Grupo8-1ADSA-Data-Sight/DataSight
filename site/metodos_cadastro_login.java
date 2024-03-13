package site;

import java.util.ArrayList;
import java.util.List;

public class metodos_cadastro_login {
    public void recepcao() {
        System.out.println("_______________________");
        System.out.println("Bem vindo ao DataSight");
        System.out.println("_______________________");

        System.out.println();

        System.out.println("Digite 1 para se cadastrar");
        System.out.println("Digite 2 se já tem cadastro");

    }

    public String cadastro(String nomeCompleto, String email, String senha) {
        String cadastrado = "Cadastro não efetuado";
        List<String> nomeUsuario = new ArrayList<>();
        List<String> emailUsuario = new ArrayList<>();
        List<String> senhaUsuario = new ArrayList<>();

        if ( nomeCompleto == null && nomeCompleto.length()<1){
            return cadastrado = "Nome muito curto \n" +
                    "Cadastro não efetuado!";

        } else if (
                email.contains("@") &&
                email.endsWith(".com")) {
            return cadastrado = "O email precisa conter ao menos um '@' e finalizar com '.com' \n" +
                    "Cadastro não efetuado!";
        } else if (
                senha.length() < 6 &&
                        senha.length()>16
//                        &&
//                        senha.contains()


        ) {

        }

//
//
//        ) {
//
//        } else {
//            return cadastrado;
//        }

//        nomeUsuario.add(nomeCompleto);
//        emailUsuario.add(email);
//        senhaUsuario.add(senha);




        return cadastrado;
    }

}
