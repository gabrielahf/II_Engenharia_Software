package aplicacao;

import dados.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ACMERobots extends JFrame {
    private List<Cliente> listaClientes;
    private JTextArea areaMensagens;
    private JTextField campoCodigo;
    private JTextField campoNome;

    public ACMERobots() {
        listaClientes = new ArrayList<>();

        setTitle("ACME Robots - Cadastro de Clientes");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Layout da janela
        JPanel painelPrincipal = new JPanel(new BorderLayout());
        setContentPane(painelPrincipal);

        // Componentes da interface
        JPanel painelFormulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Campo de código
        JLabel labelCodigo = new JLabel("Código:");
        campoCodigo = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        painelFormulario.add(labelCodigo, gbc);
        gbc.gridx = 1;
        painelFormulario.add(campoCodigo, gbc);

        // Campo de nome
        JLabel labelNome = new JLabel("Nome:");
        campoNome = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        painelFormulario.add(labelNome, gbc);
        gbc.gridx = 1;
        painelFormulario.add(campoNome, gbc);

        // Área de mensagens
        JLabel labelMensagens = new JLabel("Mensagens:");
        areaMensagens = new JTextArea(10, 40);
        areaMensagens.setEditable(false); // Para o usuário não poder editar
        areaMensagens.setLineWrap(true);
        areaMensagens.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(areaMensagens);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        painelFormulario.add(labelMensagens, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        painelFormulario.add(scrollPane, gbc);
        gbc.gridwidth = 1;

        // Botões
        JPanel painelBotoes = new JPanel();
        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoLimpar = new JButton("Limpar");
        JButton botaoListar = new JButton("Listar Clientes");
        JButton botaoFechar = new JButton("Fechar");

        // Ação do botão Cadastrar
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });

        // Ação do botão Limpar
        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        // Ação do botão Listar Clientes
        botaoListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarClientes();
            }
        });

        // Ação do botão Fechar
        botaoFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fecharAplicacao();
            }
        });

        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoListar);
        painelBotoes.add(botaoFechar);

        // Adicionar componentes ao painel principal
        painelPrincipal.add(painelFormulario, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void cadastrarCliente() {
        try {
            int codigo = Integer.parseInt(campoCodigo.getText());
            String nome = campoNome.getText();

            // Verificar se o código já existe na lista
            for (Cliente cliente : listaClientes) {
                if (cliente.getCodigo() == codigo) {
                    exibirMensagemErro("Erro: Código de cliente já existe.");
                    return;
                }
            }

            // Adicionar cliente à lista
            Cliente novoCliente = new Cliente(codigo, nome) {
                @Override
                public double calculaDesconto() {
                    return 0;
                }
            };
            listaClientes.add(novoCliente);
            exibirMensagem("Cliente cadastrado com sucesso: " + novoCliente);

            // Limpar campos após cadastrar
            limparCampos();

        } catch (NumberFormatException ex) {
            exibirMensagemErro("Erro: Código deve ser um número inteiro.");
        }
    }

    private void limparCampos() {
        campoCodigo.setText("");
        campoNome.setText("");
        areaMensagens.setText("");
    }

    private void listarClientes() {
        if (listaClientes.isEmpty()) {
            exibirMensagem("Nenhum cliente cadastrado.");
        } else {
            exibirMensagem("Lista de Clientes:");
            for (Cliente cliente : listaClientes) {
                exibirMensagem(cliente.toString());
            }
        }
    }

    private void fecharAplicacao() {
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente fechar a aplicação?", "Fechar Aplicação",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose(); // Fecha a janela
        }
    }

    private void exibirMensagem(String mensagem) {
        areaMensagens.append(mensagem + "\n");
    }

    private void exibirMensagemErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
        areaMensagens.append("Erro: " + mensagem + "\n");
    }
}
