import java.util.Scanner;

public class Aplicacao {
    private Equipe equipe;
    private Scanner entrada;

    public Aplicacao() {
        equipe = new Equipe();
        entrada = new Scanner(System.in);
    }

    public void inicializa() {
        Gerente g;
        Vendedor v;
        g = new Gerente("Maria",1111.11,11.11,"Mobile",1.1);
        equipe.addFuncionario(g);
        g = new Gerente("Pedro",222.22,22.22,"Web",2.2);
        equipe.addFuncionario(g);
        v = new Vendedor("Ana", 2000,20,"Financeiro",3.3,1000);
        equipe.addFuncionario(v);

    }

    public void executa() {
        int opcao = 0;
        do {
            System.out.println("===================");
            System.out.println("Opcoes:");
            System.out.println("[0] Sair");
            System.out.println("[1] Consulta por nome");
            System.out.println("[2] Cadastrar vendedor");
            System.out.print("Digite a opcao desejada: ");
            opcao = entrada.nextInt();
            entrada.nextLine();
            switch(opcao) {
                case 1:
                    consultaPorNome();
                    break;

                case 2:
                    cadastrarVendedor();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        } while(opcao != 0);
    }

    private void consultaPorNome() {
        System.out.println("===================");
        System.out.print("Digite o nome do funcionario: ");
        String nome = entrada.nextLine();
        Funcionario f = equipe.pesquisaNome(nome);
        if(f == null)
            System.out.println("Erro. Nao ha funcionario com este nome");
        else {
            System.out.println(f.geraDescricao());
        }
    }

    private void cadastrarVendedor(){

        System.out.println("===================");
        System.out.print("Digite o nome do Vendedor: ");
        String nome = entrada.nextLine();
        System.out.print("Digite o salario base do Vendedor: ");
        double salarioBase = entrada.nextDouble();
        System.out.print("Digite os descontos do Vendedor: ");
        double descontos = entrada.nextDouble();
        System.out.print("Digite o setor do Vendedor: ");
        String setor = entrada.nextLine();
        entrada.nextLine();
        System.out.print("Digite o adicional do salario do Vendedor: ");
        double adicionalSalario = entrada.nextDouble();
        System.out.print("Digite a comissao do Vendedor: ");
        double comissao = entrada.nextDouble();

        Vendedor v = new Vendedor(nome,salarioBase,descontos,setor,adicionalSalario,comissao);
        equipe.addFuncionario(v);

        System.out.println("" + nome + ", " + salarioBase + "," + descontos + "," + setor + "," + adicionalSalario + "," + comissao);
        entrada.nextLine();
        System.out.println("Vendedor cadastrado!");

    }

}
