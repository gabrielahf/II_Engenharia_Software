package janela;

import aplicacao.ACMERobots;
import dados.Locacao;
import dados.Status;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class alterarLocacao {
    private List<Locacao> locacaoList;
    private ACMERobots acmeRobots = new ACMERobots();

    private JPanel painel12;
    private JTextArea textArea1;
    private JTextField textFieldNumero;
    private JTextField textFieldStatus;
    private JButton retornarButton;
    private JButton confirmarButton;

    /*
    o (solicita o número de um locação; mostra os dados
    da locação; solicita a nova situação [se não há locação com o código indicado, mostra
    uma mensagem de erro; se o locação estiver na situação FINALIZADA ou
    CANCELADA, não pode ser alterado e mostra uma mensagem de erro]).
     */
    public alterarLocacao(App app, ACMERobots acmeRobots) {
        this.acmeRobots = acmeRobots;
        locacaoList = acmeRobots.getListLocacao();
        getTextAreaMensagem().append(locacaoList.toString()); // exibir a lista de locações disponíveis para conferir o numero


        retornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(1);
            }
        });

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numero = Integer.parseInt(textFieldNumero.getText());
                    String situacao = textFieldStatus.getText();
                    Status novoStatus = Status.valueOf(situacao.toUpperCase());

                    // Chamar o método alterarLocacao da ACMERobots
                    String mensagem = String.valueOf(acmeRobots.alterarLocacao(numero, String.valueOf(novoStatus)));


                    // Exibir mensagem na textArea1
                    getTextAreaMensagem().setText(mensagem);

                } catch (NumberFormatException exp) {
                    getTextAreaMensagem().setText("Número inválido");
                } catch (IllegalArgumentException ex) {
                    getTextAreaMensagem().setText("Situação inválida");
                }
            }
        });

    }

    public JTextArea getTextAreaMensagem() {
        return textArea1;
    }

    public JPanel getPainel() {
        return painel12;
    }
}
