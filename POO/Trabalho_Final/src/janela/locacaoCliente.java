package janela;


import aplicacao.ACMERobots;
import dados.Cliente;
import dados.Locacao;
import dados.Status;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class locacaoCliente {
    private ACMERobots acmeRobots;
    private List<Cliente> clienteList;
    private List<Locacao> locacaoList = new ArrayList<>();
    private String nomeArquivo;

    private JPanel painel10;
    private JTextField textFieldNumero;
    private JTextField textFieldDataInicio;
    private JTextField textFieldSituacao;
    private JTextField textFieldDataFinal;
    private JButton confirmarButton;
    private JButton limparButton;
    private JButton retornarButton;
    private JTextArea textArea1;

    public locacaoCliente(App app, ACMERobots clientes) {
        acmeRobots = clientes;
        clienteList = acmeRobots.getListCliente();

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obter valores dos campos
                    int numero = Integer.parseInt(textFieldNumero.getText());
                    String statusStr = textFieldSituacao.getText();
                    String dataInicioStr = textFieldDataInicio.getText();
                    int dataFim = Integer.parseInt(textFieldDataFinal.getText());

                    // Validar se todos os campos estão preenchidos
                    if (textFieldNumero.getText().isEmpty() || textFieldSituacao.getText().isEmpty() ||
                            textFieldDataInicio.getText().isEmpty() || textFieldDataFinal.getText().isEmpty()) {
                        getTextAreaMensagem().setText("Preencher todos os campos");
                        return;
                    }

                    // Converter status para enum Status
                    Status status = Status.valueOf(statusStr.toUpperCase());

                    // Formatar data de início
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataInicio = formatter.parse(dataInicioStr);

                    // Criar novo objeto Locacao
                    Locacao novoCliente = new Locacao(numero, status, dataInicio, dataFim);
                    locacaoList.add(novoCliente);

                    // Tentar cadastrar a locação
                    if (acmeRobots.cadastrarLocacao(novoCliente)) {
                        getTextAreaMensagem().setText("Cadastro concluído");
                    } else {
                        getTextAreaMensagem().setText("Erro ao cadastrar locação");
                    }

                } catch (NumberFormatException ex) {
                    getTextAreaMensagem().setText("Erro ao inserir número ou data final");
                    textFieldNumero.setText("");
                    textFieldDataFinal.setText("");
                } catch (ParseException ex) {
                    getTextAreaMensagem().setText("Erro ao inserir data inicio");
                    textFieldDataInicio.setText("");
                }
            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldNumero.setText("");
                textFieldDataInicio.setText("");
                textFieldDataFinal.setText("");
                textFieldSituacao.setText("");
                textArea1.setText("");
            }
        });

        retornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(9); // Voltar para o painel de seleção de Locação
            }
        });
    }

    public JTextArea getTextAreaMensagem() {
        return textArea1;
    }

    public JPanel getPainel() {
        return painel10;
    }
}
