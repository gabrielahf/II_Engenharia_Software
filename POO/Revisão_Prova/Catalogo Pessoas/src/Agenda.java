import java.util.Scanner;

public class Agenda {
    private Scanner entrada;
    private CatalogoPessoas catalogoPessoas;

    public Agenda() {
        catalogoPessoas = new CatalogoPessoas();
        entrada = new Scanner(System.in);
    }

    public void inicializa() {
        Pessoa p1;
        Telefone telefone;

        p1 = new Pessoa("Joao");
        telefone = new Telefone(51,"1111-11111");
        p1.adicionaTelefone(telefone);
        catalogoPessoas.adicionaPessoa(p1);

        p1 = new Pessoa("Maria");
        telefone = new Telefone(51,"2222-22222");
        p1.adicionaTelefone(telefone);
        telefone = new Telefone(51,"3333-33333");
        p1.adicionaTelefone(telefone);
        catalogoPessoas.adicionaPessoa(p1);

        telefone = new Telefone(41,"4444-44444");
        p1 = new Pessoa("Pedro",telefone);
        catalogoPessoas.adicionaPessoa(p1);
    }

    public void processa() {
        System.out.print("Digite o nome desejado: ");
        String nome = entrada.nextLine();
        Pessoa aux = catalogoPessoas.consultaPessoa(nome);
        if(aux != null) {
            System.out.println("Dados da pessoa: " + aux);
        }
        else {
            System.out.println("Nome nao encontrado.");
        }

        System.out.print("Digite o DDD desejado: ");
        int ddd = entrada.nextInt();
        entrada.nextLine();
        System.out.print("Digite o numero desejado: ");
        String numero = entrada.nextLine();
        aux = catalogoPessoas.consultaPessoa(ddd,numero);
        if(aux != null) {
            System.out.println("Dados da pessoa: " + aux);
        }
        else {
            System.out.println("Telefone nao encontrado.");
        }
    }

}