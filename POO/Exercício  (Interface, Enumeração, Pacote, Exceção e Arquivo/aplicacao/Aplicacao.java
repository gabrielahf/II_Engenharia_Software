package aplicacao;

import dados.*;
import java.io.*;

public class Aplicacao {
    private Agenda agenda;

    public Aplicacao() {
        agenda = new Agenda();
    }

    public void executar() {
        cadastraPessoas();
        mostraPessoas(agenda);
        salvaArquivo();
        limpaAgenda();
        carregaArquivo();
        mostraPessoas(agenda);
    }

    // Cria algumas pessoas e adiciona na agenda
    private void cadastraPessoas() {
        Pessoa p = new Pessoa("Casado", EstadoCivil.CASADO);
        agenda.addPessoa(p);
        p = new Pessoa("Divorciado", EstadoCivil.DIVORCIADO);
        agenda.addPessoa(p);
        p = new Pessoa("Solteiro", EstadoCivil.SOLTEIRO);
        agenda.addPessoa(p);
        p = new Pessoa("Nulo", null);
        agenda.addPessoa(p);
        p = new Pessoa("Viuvo", EstadoCivil.VIUVO);
        agenda.addPessoa(p);
    }

    // Mostra as pessoas da agenda
    private void mostraPessoas(Iterador iter) {
        iter.reset();
        while (iter.hasNext()) {
            try {
                Pessoa aux = (Pessoa) iter.next();
                System.out.println("=========================");
                System.out.println("Nome da pessoa: " + aux.getNome());
                System.out.println("Estado civil da pessoa: " + aux.getEstadoCivil().getExtenso());
            } catch (Exception e) {
                System.out.println("Erro no estado civil: " + e.getMessage());
            }
        }
    }

    // Salva em arquivo
    private void salvaArquivo() {
        try {
            System.out.println("=========================");
            System.out.println("Salvando em arquivo...");
            agenda.salvaEmArquivo();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    // Limpa a agenda
    private void limpaAgenda() {
        System.out.println("=========================");
        agenda.clear();
        System.out.println("Agenda limpa.");
    }

    // Carrega de Arquivo
    private void carregaArquivo() {
        try {
            System.out.println("=========================");
            System.out.println("Carregando de arquivo...");
            agenda.carregaDeArquivo();
        }
        catch(EOFException e) {

        }
        catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }


}