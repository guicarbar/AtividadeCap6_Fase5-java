package br.com.fintech.modules;

// import biblioteca
import br.com.fintech.resorce.ResorceChat;

import java.util.Scanner;

public class Cadastro extends Login {
    private String cpf;
    private String confirmaSenha;
    private String newEmail = getEmail();
    private String newSenha = getSenha();

    //Seters
    public String getNewSenha() {
        return newSenha;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public String getConfirmaSenha() {
        return confirmaSenha;
    }

    public String getCpf() {
        return cpf;
    }


    //Gueters
    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public void setNewSenha(String newSenha) {
        this.newSenha = newSenha;
    }

    public void setConfirmaSenha(String confirmaSenha) {
        this.confirmaSenha = confirmaSenha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public void makeLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu email:");
        String newEmail = sc.next();
        System.out.println("Digite sua senha:");
        String newSenha = sc.next() + sc.nextLine();
        System.out.println("Confirme sua senha:");
        String confirmaSenha = sc.next() + sc.nextLine();

        setNewSenha(newSenha);
        setConfirmaSenha(confirmaSenha);


        // verificar senha
        if (newSenha == confirmaSenha) {
            System.out.println("Digite seu CPF");
            String cpf = sc.next();
            System.out.println("Digite seu Nome");
            String nomeCadastro = sc.next();
            setLogado(true);

            // passo pra variavel
            setCpf(cpf);
            setNewEmail(newEmail);
            Conta.setNome(nomeCadastro);
        } else {
            System.out.println(ResorceChat.breakLineResorc() + "As senhas precisam ser identicas!" + ResorceChat.breakLineResorc());
            setLogado(false);
        }
    }
}
