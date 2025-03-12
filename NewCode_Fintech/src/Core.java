// import modulos
import br.com.fintech.modules.*;
import br.com.fintech.resorce.ResorceChat;

// import bibliotecas
import java.security.spec.RSAOtherPrimeInfo;
import java.sql.SQLOutput;
import java.util.Scanner;


public class Core {
    private static Scanner sc = new Scanner(System.in);
    // main function
    public static void main(String[] args) {
        Login login = new Login();
        Cadastro cadastro = new Cadastro();

        //‘Login’ e Cadastro
        int op;
        login.setLogado(false);

        do {
            System.out.println("Bem vindo!" + ResorceChat.breakLineResorc() + "1. Fazer login" + ResorceChat.breakLineResorc() + "2. Cadastrar");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    login.makeLogin();
                    break;
                case 2:
                    cadastro.makeLogin();
                    break;
                default:
                    System.out.println("Escolha uma opção valdia!");
            }
        } while (!login.getLogado());



        // Verificador/analisador da opção selecionada
        String option;
        boolean running = true;
        do {
            // Acessar funcionalidades
            System.out.println(ResorceChat.breakLineResorc() + "O que vamos fazer hoje? Digite apenas o número da opção desejada.");
            System.out.println("1. Depositar valor");
            System.out.println("2. Sacar valor");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Consultar meta");
            System.out.println("5. Adicionar meta");
            System.out.println("6. Adicionar valor para a meta");
            System.out.println("7. sair");

            // Coleta da escolha
            option = sc.next();

            if (isInteger(option)) {
                int choice = Integer.parseInt(option);
                if (choice == 7) {
                    running = false;
                    System.out.println("Finalizando processo ...");
                } else {
                    functions(choice);
                }
            } else {
                System.out.println("Entrada inválida!");
            }

        } while (running);

        // fechar scanner da main
        sc.close();
    }



    // verifica se é ou nn inteiro
    public static boolean isInteger(String str) {
        try {
            // Tenta converter a string para int
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    // ativa as opções
    private static void functions(int choice) {

        //Criando Objeto meta e conta
        Meta meta = new Meta();
        Conta conta = new Conta();

        // switch das opções
        switch (choice) {
            case 1:
                System.out.println("Quanto deseja adcicionar ?");
                double valorDeposito = sc.nextDouble();
                Depositar.depositarValor(valorDeposito);
                break;
            case 2:
                System.out.println("Quanto deseja sacar ?");
                double x = sc.nextDouble();
                Sacar.sacarValor(x);
                break;
            case 3:
                conta.showValor();
                break;
            case 4:
                System.out.println("Consultando Meta ..." + ResorceChat.breakLineResorc());
                meta.showValor();
                break;
            case 5:
                System.out.println("Digite o nome para a meta");
                String userName = sc.next();
                System.out.println("Digite a data final para a meta:");
                String data = sc.next();
                System.out.println("Digite o valor que deseja alcançar");
                double valorDesejado;
                valorDesejado = sc.nextDouble();
                 meta.setNomeMeta(userName);
                 meta.setMesAnoMetaFinal(data);
                 meta.setValorMeta(valorDesejado);
                break;
            case 6:
                System.out.println("Digite o valor que deseja adicionar para a meta:");
                double valorMeta = sc.nextDouble();
                Meta.addInvestimento(valorMeta);
                break;
            default:
                System.out.println("Valor selecionado inválido, digite apenas um dos 7 valores!" + ResorceChat.breakLineResorc());
                break;
        }
    }
}