package br.com.fiap.adcoin;

import

public class User {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Login login = new Login();

        int op;

        do {
            System.out.println("Escolha ente \n1-Logar \n2-Cadastrar:");
            op = sc.nextInt();

            switch (op){
                case 1:
                    System.out.println("Bem vindo de volta! \nDigite o seu Email:");
                    String email = sc.next() + sc.nextLine();
                    System.out.println("Digite a sua Senha:");
                    String senha = sc.next() + sc.nextLine();
                    login.email = email;
                    login.senha = senha;
                    break;

                case 2:
                    System.out.println("Bem vindo ao AdCoin! \nPor Favor digite seu nome:");
                    String nome = sc.next() + sc.nextLine();
                    System.out.println("Digite o seu Email:");
                    String email = sc.next() + sc.nextLine();
                    System.out.println("Confirme a sua senha:");
                    String confirmacao = sc.next() + sc.nextLine();


                    Cadastre cadastre = new Cadastre(nome, confirmacao);
                    login.cadastre = cadastre;
                    break;

            }

        }while (op !=0);

    }






}
