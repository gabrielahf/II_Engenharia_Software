import java.util.Scanner;

public class AppLobos {
    private Matilha matilha;
    private Scanner entrada;

    public AppLobos() {
        matilha = new Matilha();
        entrada = new Scanner(System.in);
    }

    public void executar() {
        System.out.println("Iniciando a execucao...");
        menu();
        int opcao = entrada.nextInt();
        entrada.nextLine();
        System.out.println("====================================");
        while(opcao != 0) {
            switch (opcao) {
                case 1:
                    cadastrarLobo();
                    break;
                case 2:
                    consultarLoboPeloNome();
                    break;
                case 3:
                    alterarIdade(); // ALTERADO
                    break;
                case 0:
                    break;
                case 99:
                    easterEgg();
                    break;
                default:
                    System.out.println("Opcao invalida. Redigite.");
            }
            menu();
            opcao = entrada.nextInt();
            entrada.nextLine();
            System.out.println("====================================");
        }
        System.out.println("Fim da execucao...");
    }

    private void menu() {
        System.out.println("====================================");
        System.out.println("Opcoes:");
        System.out.println("[1] Cadastrar um lobo");
        System.out.println("[2] Consultar um lobo pelo nome");
        System.out.println("[3] Alterar a idade de um lobo"); // ALTERADO
        System.out.println("[0] Sair");
        System.out.print("Digite a opcao desejada: ");
    }

    private void cadastrarLobo() {
        System.out.println("CADASTRAR UM LOBO");
        System.out.print("Digite o nome do lobo: ");
        String nome = entrada.nextLine();
        System.out.print("Digite a idade do lobo: ");
        int idade = entrada.nextInt();
        System.out.print("Digite a velocidade do lobo: ");
        double velocidade = entrada.nextDouble();
        entrada.nextLine();
        Lobo lobo = new Lobo(nome,idade, velocidade);
        matilha.cadastraLobo(lobo);
        System.out.println("Lobo cadastrado!");
    }

    private void consultarLoboPeloNome() {
        System.out.println("CONSULTAR LOBO POR NOME");
        System.out.print("Digite o nome do lobo: ");
        String nome = entrada.nextLine();
        Lobo lobo = matilha.consultaPorNome(nome);
        if(lobo == null)
            System.out.println("Nenhum lobo encontrado com este nome.");
        else {
            System.out.println("Nome do lobo: " + lobo.getNome());
            System.out.println("Idade do lobo: " + lobo.getIdade());
            System.out.println("Velocidade do lobo: " + lobo.getVelocidade());
        }
    }

    // Cadastra alguns lobos
    private void easterEgg() {
        System.out.println("Easter egg!");
        Lobo lobo = new Lobo("Lobo mau",10,40.0);
        matilha.cadastraLobo(lobo);
        lobo = new Lobo("Maugrim",11,41.1);
        matilha.cadastraLobo(lobo);
        lobo = new Lobo("Nymeria",12,41.1);
        matilha.cadastraLobo(lobo);
        lobo = new Lobo("Shaggydog",13,43.3);
        matilha.cadastraLobo(lobo);
        lobo = new Lobo("Grey Win",15,41.1);
        matilha.cadastraLobo(lobo);
        lobo = new Lobo("Lady",15,45.5);
        matilha.cadastraLobo(lobo);
        lobo = new Lobo("Ghost",15,46.6);
        matilha.cadastraLobo(lobo);
    }

// IMPLEMENTACAO
    private void alterarIdade() {
        System.out.println("ALTERAR A IDADE DO LOBO");
        System.out.println("Digite o nome do lobo que deseja alterar a idade: ");
        String nome = entrada.nextLine();
        Lobo lobo = matilha.consultaPorNome(nome);

        if (lobo == null) {
            System.out.println("Lobo inexistente");
        } else {
            System.out.println("Digite a nova idade: ");
            int novaIdade = entrada.nextInt();

            lobo.setIdade(novaIdade);
            System.out.println("Idade alterada para " + novaIdade);
        }
    }




}