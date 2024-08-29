package janela;

import ManipularArquivos.GravarArquivoRobo;
import aplicacao.ACMERobots;
import dados.Cliente;
import dados.Locacao;
import dados.Robo;

import ManipularArquivos.GravarArquivo;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class telaInicial {
    private ACMERobots acmeRobots = new ACMERobots();
    private List<Cliente> clienteList;
    private List<Robo> roboList;
    private List<Locacao> locacaoList;
    private String nomeArquivo;


    private GravarArquivoRobo gravarArquivoRobo;
    private JButton cadastrarLocaçãoButton;
    private JButton cadastrarClienteButton;
    private JButton cadastrarRoboButton;
    private JButton fecharButton;
    private JPanel painel1;
    private JButton registroGeralButton;
    private JButton alterarLocaçãoButton;
    private JTextArea textArea1;
    private JTextField textFieldRobo;
    private JTextField textFieldCliente;
    private JTextField textFieldLocacao;
    private JButton limparButton;


    public telaInicial(App app, ACMERobots acmeRobots) {
        this.acmeRobots = acmeRobots;


        // Inicializar as listas a partir do ACMERobots
        clienteList = acmeRobots.getListCliente();
        roboList = acmeRobots.getListRobo();
        locacaoList = acmeRobots.getListLocacao();

        cadastrarRoboButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeArq = textFieldRobo.getText();

                gravarArquivoRobo = new GravarArquivoRobo(nomeArq);
                app.mudaPainel(2); //muda para o painel selecionaRobo

            }
        });



        cadastrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeArq = textFieldCliente.getText();

                    app.mudaPainel(6); //muda para o painel selecionaCliente


            }
        });

        cadastrarLocaçãoButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //receber textFieldLocacao
                String nomeArq = textFieldLocacao.getText();

                    app.mudaPainel(9); //muda para o painel selecionaLocacao


            }

        });

        fecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);;
            }
        });

        registroGeralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String registro = acmeRobots.registroGeral();
                getTextAreaMensagem().setText(registro);
            }
        });

        alterarLocaçãoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(12);
            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    getTextAreaMensagem().setText("");
                    textFieldRobo.setText("");
                    textFieldCliente.setText("");
                    textFieldLocacao.setText("");
            }
        });
    }

    public JTextArea getTextAreaMensagem() {
        return textArea1;
    }

    public JPanel getPainel() {
        return painel1;
    }

}
