package br.com.fintech.modules;

// import bibliotecas
import java.util.Scanner;

public class Login {
    // declaração variaveis
    private String senha;
    private String email;
    private boolean logado;

    // getter
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public boolean getLogado() {return logado; }

    // setters
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public void setEmail(String email) {this.email = email;}
    public void setLogado(boolean logado) {this.logado = logado;}


    // polimorfismo - makelogin - login
    public void makeLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite seu email: ");
        String email = sc.next();
        System.out.println("Digite sua senha: ");
        String senha = sc.next();
        System.out.println("Digite seu Nome");
        String nomeLogin = sc.next();

        setLogado(true);

        // passa pro login
        setEmail(email);
        setSenha(senha);
        Conta.setNome(nomeLogin);
    }

    // constutor padrão
    public Login() {}
}
