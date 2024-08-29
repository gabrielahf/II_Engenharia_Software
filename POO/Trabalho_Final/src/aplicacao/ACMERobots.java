package aplicacao;
import java.io.*;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.File;
//import java.io.PrintStream;
//import java.nio.charset.Charset;
//import java.util.Locale;
//import java.util.Scanner;
//import java.util.Date;
//import java.text.ParseException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;

import ManipularArquivos.GravarArquivoRobo;
import dados.Agricola;
import dados.Cliente;
import dados.Domestico;
import dados.Empresarial;
import dados.Individual;
import dados.Industrial;
import dados.Locacao;
import dados.Robo;
import dados.Status;

import javax.swing.*;
import java.util.*;


public class ACMERobots  implements  Serializable{
    private List<Cliente> clienteList;
    private List<Robo> roboList;
    private List<Locacao> locacoes;
    private Queue<Locacao> locacoespendentes;
    private Status status;
    private String nomeArquivo;

    private PrintStream streamSaidaRobo;
    private PrintStream streamSaidaCliente;
    private PrintStream streamSaidaLocacao;
    private GravarArquivoRobo gravarArquivoRobo;

    public ACMERobots() {
        /*
        try {
            streamSaidaRobo = new PrintStream(new File("dadosoutRobo.txt"), Charset.forName("UTF-8"));
            streamSaidaCliente = new PrintStream(new File("dadosoutCliente.txt"), Charset.forName("UTF-8"));
            streamSaidaLocacao = new PrintStream(new File("dadosoutLocacao.txt"), Charset.forName("UTF-8"));
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao criar o arquivo de saída: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        // Implemente aqui o seu codigo adicional do construtor
        clienteList = new ArrayList<>();
        roboList = new ArrayList<>();
        locacoes = new LinkedList<>();
        locacoespendentes = new LinkedList<>();

    }


    public void redirecionarSaida(String tipoSaida) {
        switch (tipoSaida.toLowerCase()) {
            case "robo":
                System.setOut(streamSaidaRobo);
                break;
            case "cliente":
                System.setOut(streamSaidaCliente);
                break;
            case "locacao":
                System.setOut(streamSaidaLocacao);
                break;
            default:
                System.err.println("Tipo de saída desconhecido: " + tipoSaida);
                break;
        }
    }

    public void gravarDadosRobo(Robo robo) {
        gravarArquivoRobo.gravarDados(robo);
    }


    public List<Cliente> getListCliente() {
        return clienteList;
    }

    public List<Robo> getListRobo() {
        return roboList;
    }


    public List<Locacao> getListLocacao() {
        return locacoes;
    }

    // Cadastrar novo robô
    public boolean adicionarRobo(Robo robo) {
        if (consultaPorId(robo.getId()) == null) {
            roboList.add(robo);
            return true;
        } else
            return false;
    }

    public Robo consultaPorId(int id) {
        for (Robo robo : roboList) {
            if (robo.getId() == id) {
                return robo;
            }
        }
        return null;
    }

    // Cadastrar novo cliente
    public boolean adicionarCliente(Cliente cliente) {
        if (consultaPorCodigo(cliente.getCodigo()) == null) {
            clienteList.add(cliente);
            return true;
        } else
            return false;
    }

    public Cliente consultaPorCodigo(int codigo) {
        for (Cliente cliente : clienteList) {
            if (cliente.getCodigo() == codigo) {
                return cliente;
            }
        }
        return null;
    }

    // Cadastrar nova locação
    public boolean cadastrarLocacao(Locacao locacao) {
        for (Locacao locacao1 : locacoes) {
            if (consultaPorNumero(locacao.getNumero()) == null)
                locacoes.add(locacao);
            processarLocacao(); // verificar se este local é apropriado para chamar este metodo
            return true;
        }
        return false;

    }

    public Locacao consultaPorNumero(int numero) {
        for (Locacao locacao : locacoes) {
            if (locacao.getNumero() == numero) {
                return locacao;
            }
        }
        return null;
    }


    //VERIFICAR ONDE APLICAR A FUNCIONALIDADE DESSE METODO
    // Processar locação
    public void processarLocacao() {
        /*
        (a partir da fila de locações pendentes; o sistema fará o
        processamento automático de cada locação. Verifica se é possível locar cada robô
        solicitado. Se todos os robôs solicitados forem locados, a locação passa para a
        situação EXECUTANDO. Se algum robô não estiver disponível, todos os robôs já
        locados são liberados e a locação retorna para a fila de locações pendentes
         */

        while (!locacoespendentes.isEmpty()) {
            Locacao locacao = locacoespendentes.poll();

            boolean disponivel = true;
            for (Robo robo : locacao.getRobos()) {
                if (robo.getStatus() != Status.FINALIZADA) {
                    disponivel = false;
                    break;
                }
            }
            if (disponivel) {
                for (Robo robo : locacao.getRobos()) {
                    robo.setStatus(Status.EXECUTANDO);
                }
                locacao.setStatus(Status.EXECUTANDO);
            } else {
                for (Robo robo : locacao.getRobos()) {
                    if (robo.getStatus() == Status.EXECUTANDO) {
                        robo.setStatus(Status.CANCELADA);
                    }
                }
                locacao.setStatus(Status.CANCELADA);
                locacoespendentes.offer(locacao);
            }

        }
    }


    //mostrarRelatorioGeral
    public String registroGeral() {
        StringBuilder registro = new StringBuilder();

        if (clienteList.isEmpty() && roboList.isEmpty() && locacoes.isEmpty()) {
            registro.append("Nenhum dado cadastrado");
        } else {
            registro.append("#### LISTA DE CLIENTES ####\n");
            for (Cliente cliente : clienteList) {
                registro.append("Cliente: ").append(cliente.toString()).append("\n");
            }

            registro.append("\n#### LISTA DE ROBOS ####\n");
            for (Robo robo : roboList) {
                registro.append("Robo: ").append(robo.toString()).append("\n");
            }

            registro.append("\n#### LISTA DE LOCAÇÕES ####\n");
            for (Locacao locacao : locacoes) {
                registro.append("Locação: ").append(locacao.toString()).append("\n");
            }
        }

        return registro.toString();
    }


    //alterarLocaçao
    public boolean alterarLocacao(int numero, String novoStatus) {
        try {
            // Consultar a locação pelo número usando ACMERobots
            Locacao locacao = consultaPorNumero(numero);

            if (locacao == null) {
                return false; // Retorna false se a locação não foi encontrada
            }

            if (locacao.getStatus() == Status.EXECUTANDO) {
                if ("CANCELADA".equals(novoStatus)) {
                    locacao.setStatus(Status.CANCELADA);
                    System.out.println("Locação cancelada com sucesso.");
                    return true;
                } else if ("FINALIZADA".equals(novoStatus)) {
                    locacao.setStatus(Status.FINALIZADA);
                    System.out.println("Locação finalizada com sucesso.");
                    return true;
                }
            } else if (locacao.getSituacao() == Status.CADASTRADA) {
                if ("CANCELADA".equals(novoStatus)) {
                    locacao.setStatus(Status.CANCELADA);
                    System.out.println("Locação cancelada com sucesso.");
                    return true;
                } else if ("FINALIZADA".equals(novoStatus)) {
                    locacao.setStatus(Status.FINALIZADA);
                    System.out.println("Locação finalizada com sucesso.");
                    return true;
                }
            }


        } catch (NumberFormatException exp) {
            // Tratar exceção de número inválido, se necessário
            return false;
        } catch (IllegalArgumentException ex) {
            // Tratar exceção de situação inválida, se necessário
            return false;
        }
        return false;
    }


    // Carga de dados iniciais no sistema
    public void carregarDadosIniciais(String nomeArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo + ".txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                switch (dados[0]) {
                    case "robo":
                        carregarRobo(dados);
                        break;
                    case "cliente":
                        carregarCliente(dados);
                        break;
                    case "locacao":
                        carregarLocacao(dados);
                        break;
                    default:
                        System.out.println("Tipo de registro desconhecido: " + dados[0]);
                        break;
                }
            }
            mostrarDados();
        } catch (IOException e) {
            System.err.println("Erro ao carregar os dados: " + e.getMessage());
        }
    }

    private void carregarRobo(String[] dados) {
        int id = Integer.parseInt(dados[1]);
        String modelo = dados[2];
        String tipo = dados[3];
        //double valorDiario = Double.parseDouble(dados[4]);

        Robo robo;
        switch (tipo) {
            case "domestico":
                int nivel = Integer.parseInt(dados[5]);
                robo = new Domestico(id, modelo, nivel);
                break;
            case "industrial":
                String setor = dados[5];
                robo = new Industrial(id, modelo, setor);
                break;
            case "agricola":
                double area = Double.parseDouble(dados[5]);
                String uso = dados[6];
                robo = new Agricola(id, modelo, area, uso);
                break;
            default:
                System.out.println("Tipo de robô desconhecido: " + tipo);
                return;
        }
        adicionarRobo(robo);



    }

    private void carregarCliente(String[] dados) {
        int codigo = Integer.parseInt(dados[1]);
        String nome = dados[2];
        String tipo = dados[3];

        Cliente cliente;
        if (tipo.equals("individual")) {
            String cpf = dados[4];
            cliente = new Individual(codigo, nome, cpf);
        } else if (tipo.equals("empresarial")) {
            int ano = Integer.parseInt(dados[4]);
            cliente = new Empresarial(codigo, nome, ano);
        } else {
            System.out.println("Tipo de cliente desconhecido: " + tipo);
            return;
        }
        adicionarCliente(cliente);
    }

    private void carregarLocacao(String[] dados) {
        try {
            int numero = Integer.parseInt(dados[1]);
            Status status = Status.valueOf(dados[2].toUpperCase());
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String dataInicioStr = dados[3];
            String dataFimStr = dados[4];
            int codigoCliente = Integer.parseInt(dados[5]);
            Cliente cliente = consultaPorCodigo(codigoCliente);
            List<Robo> robos = new ArrayList<>();
            for (int i = 6; i < dados.length; i++) {
                int idRobo = Integer.parseInt(dados[i]);
                Robo robo = consultaPorId(idRobo);
                if (robo != null) {
                    robos.add(robo);
                }
            }

            Locacao locacao = new Locacao(numero, status, formato.parse(dataInicioStr), Integer.parseInt(dataFimStr), cliente);
            locacao.setRobo(robos);
            cadastrarLocacao(locacao);
        } catch (Exception e) {
            System.err.println("Erro ao carregar locação: " + e.getMessage());
        }
    }

    private void mostrarDados() {
        System.out.println("Robôs cadastrados:");
        for (Robo robo : roboList) {
            System.out.println(robo);
        }

        System.out.println("Clientes cadastrados:");
        for (Cliente cliente : clienteList) {
            System.out.println(cliente);
        }

        System.out.println("Locações cadastradas:");
        for (Locacao locacao : locacoes) {
            System.out.println(locacao);
        }

        System.out.println("Locações pendentes:");
        for (Locacao locacao : locacoespendentes) {
            System.out.println(locacao);
        }
    }

    // Salvar dados
    public void salvarDados(String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo + ".txt"))) {
            for (Robo robo : roboList) {
                writer.write("robo;" + robo.getId() + ";" + robo.getModelo() + ";" + robo.getClass().getSimpleName().toLowerCase() + ";" + robo.getValorDiario());
                if (robo instanceof Domestico) {
                    Domestico domestico = (Domestico) robo;
                    writer.write(";" + domestico.getNivel());
                } else if (robo instanceof Industrial) {
                    Industrial industrial = (Industrial) robo;
                    writer.write(";" + industrial.getSetor());
                } else if (robo instanceof Agricola) {
                    Agricola agricola = (Agricola) robo;
                    writer.write(";" + agricola.getArea() + ";" + agricola.getUso());
                }
                writer.newLine();
            }

            for (Cliente cliente : clienteList) {
                writer.write("cliente;" + cliente.getCodigo() + ";" + cliente.getNome() + ";" + cliente.getClass().getSimpleName().toLowerCase());
                if (cliente instanceof Individual) {
                    Individual individual = (Individual) cliente;
                    writer.write(";" + individual.getCpf());
                } else if (cliente instanceof Empresarial) {
                    Empresarial empresarial = (Empresarial) cliente;
                    writer.write(";" + empresarial.getAno());
                }
                writer.newLine();
            }

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            for (Locacao locacao : locacoes) {
                //writer.write("locacao;" + locacao.getNumero() + ";" + locacao.getStatus().toString().toLowerCase() + ";" + formato.format(locacao.getDataInicio()) + ";" + formato.format(locacao.getDataFim()) + ";" + locacao.getCliente().getCodigo());
                writer.write(locacao.toString());
                for (Robo robo : locacao.getRobos()) {
                    writer.write(";" + robo.getId());
                }
                writer.newLine();
            }

            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    // Método para finalizar o sistema
    public void finalizarSistema(String tipoSaida) {
        redirecionarSaida(tipoSaida);
        System.out.println("Encerrando o sistema...");
        // Aqui você pode realizar outras operações finais necessárias antes de encerrar
        System.exit(0); // Encerra o sistema com código de saída 0 (sem erros)
    }


    // Método para carregar dados de um arquivo
    public void carregarDados() {
        String nomeArquivo = JOptionPane.showInputDialog(null, "Digite o nome do arquivo (sem extensão):");

        if (nomeArquivo == null || nomeArquivo.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome do arquivo inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Adiciona a extensão .txt ao nome do arquivo
        String arquivoComExtensao = nomeArquivo + ".txt";

        // Carrega os dados do arquivo
        try {
            File file = new File(arquivoComExtensao);

            if (!file.exists()) {
                throw new FileNotFoundException("Arquivo não encontrado: " + arquivoComExtensao);
            }

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linha;

            while ((linha = reader.readLine()) != null) {
                // Processa cada linha do arquivo
                System.out.println(linha); // Exemplo de processamento
                // Aqui você pode adicionar a lógica para carregar os dados no seu sistema
            }

            reader.close();
            JOptionPane.showMessageDialog(null, "Dados carregados com sucesso do arquivo: " + arquivoComExtensao);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar os dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }



}





    





