package serializacao.ui;

import serializacao.controle.CadastroPessoas;
import java.util.Scanner;

public class Agenda {

    private CadastroPessoas cadastro;

    public Agenda() {
        cadastro = new CadastroPessoas();
    }

    public void executa() {
        char opcao = ' ';
        Scanner entrada = new Scanner(System.in);
        while (opcao != '0') {
            System.out.println("Opcoes: ");
            System.out.println("   [0] Sair do programa");
            System.out.println("   [1] Pre-cadastrar pessoas");
            System.out.println("   [2] Mostrar cadastro de pessoas");
            System.out.println("   [3] Gravar cadastro de pessoas");
            System.out.println("   [4] Ler cadastro de pessoas");
            System.out.print("Digite a opcao desejada: ");
            opcao = entrada.next().charAt(0);
            switch (opcao) {
                case '1':
                    preCadastrar();
                    break;
                case '2':
                    mostrarCadastro();
                    break;
                case '3':
                    gravarCadastro();
                    break;
                case '4':
                    lerCadastro();
                case '0':
                    break;
                default:
                    System.out.println("Opcao invalida! Redigite.");
            }
        }
    }

    private void preCadastrar() {
       if(cadastro.inicializa() == 0)
           System.out.println("Pessoas foram pre-cadastradas.");
       else
           System.out.println("Erro: nao foi possivel cadastradas pessoas");
    }

    private void mostrarCadastro() {
        String retorno = cadastro.consultaCadastro();
        if(retorno.equals(""))
            System.out.println("Nao ha pessoas cadastradas.");
        else {
            System.out.println("Dados do cadastro:");
            System.out.println(retorno);
        }
    }

    private void gravarCadastro() {
        if(cadastro.gravaPessoas() == 0)
            System.out.println("Cadastro salvo.");
        else
            System.out.println("Erro: gravacao no arquivo.");
    }

    private void lerCadastro() {
        int cod = cadastro.lePessoas();
        switch (cod) {
            case 0:
                System.out.println("Cadastro lido.");
                break;
            case 1:
                System.out.println("Erro: classe serializacao. Pessoa nao encontrada!");
                break;
            default:
                System.out.println("Erro: leitura de arquivo.");
        }
    }
}
