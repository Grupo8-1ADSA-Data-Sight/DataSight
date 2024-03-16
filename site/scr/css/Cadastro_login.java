package site.scr.css;

import site.Metodos_cadastro_login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro_login {
    public static void main(String[] args) {
        Scanner respostaUsuario = new Scanner(System.in);
        Scanner respostaUsuario2 = new Scanner(System.in);
        Metodos_cadastro_login cadastro_login = new Metodos_cadastro_login();
        String nomeCompleto = "Maycon Nogueira";
        String email = "maycon@nog.com";
        String senha = "12345@";
        List<String> listaNomeUsuario = new ArrayList<>();
        List<String> listaEmailUsuario = new ArrayList<>();
        List<String> listaSenhaUsuario = new ArrayList<>();
        Boolean finalizar = false;

        listaNomeUsuario.add(nomeCompleto);
        listaEmailUsuario.add(email);
        listaSenhaUsuario.add(senha);

        do {

            cadastro_login.recepcao();
            int numInserido = respostaUsuario.nextInt();

            if (numInserido == 1) {
                System.out.println("Digite seu nome: ");
                nomeCompleto = respostaUsuario.next();

                System.out.println();

                System.out.println("Digite seu email: ");
                email = respostaUsuario2.nextLine();

                System.out.println();

                System.out.println("Digite a senha: ");
                senha = respostaUsuario2.nextLine();

                System.out.println();

                System.out.println(String.format(cadastro_login.cadastrar(nomeCompleto, email, senha, listaNomeUsuario, listaEmailUsuario, listaSenhaUsuario)));
            } else if (numInserido == 2) {

                System.out.println("Digite seu email: ");
                email = respostaUsuario2.nextLine();

                System.out.println();

                System.out.println("Digite a senha: ");
                senha = respostaUsuario2.nextLine();

                if(
                cadastro_login.verificarCadastro(listaNomeUsuario, listaEmailUsuario, listaSenhaUsuario, email, senha, finalizar)){
                    finalizar=true;
                };

            } else {
                System.out.println("O número inserido é invalido, digite novamente");
            }
        } while (!finalizar);
    }
}
