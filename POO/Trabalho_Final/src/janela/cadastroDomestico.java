package janela;


import aplicacao.ACMERobots;
import dados.Domestico;
import dados.Robo;
import ManipularArquivos.GravarArquivoRobo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class cadastroDomestico {
    private ACMERobots acmeRobots;
    private List<Robo> roboList;
    private GravarArquivoRobo gravarArquivoRobo;
    private String nomeArquivo;


    private JPanel painel5;
    private JTextField textFieldNivel;
    private JTextField textFieldModelo;
    private JTextField textFieldID;
    private JButton confirmarButton;
    private JButton limparButton;
    private JButton retornarButton;
    private JTextArea textArea1;

    public cadastroDomestico(App app, ACMERobots robots) {
        this.acmeRobots = robots;
        this.roboList = acmeRobots.getListRobo();


        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(textFieldID.getText());
                    String modelo = textFieldModelo.getText();
                    int nivel = Integer.parseInt(textFieldNivel.getText());

                    if (textFieldID.getText().isEmpty() || textFieldModelo.getText().isEmpty() || textFieldNivel.getText().isEmpty()) {
                        getTextAreaMensagem().setText("Preencher todos os campos.");
                        return;
                    }

                    if (nivel < 1 || nivel > 4) {
                        getTextAreaMensagem().setText("Nível inválido.");
                        return;
                    }

                    Robo idExiste = acmeRobots.consultaPorId(id);
                    if (idExiste != null) {
                        getTextAreaMensagem().setText("ID já existente.");
                        return;
                    }

                    Domestico novoRobo = new Domestico(id, modelo, nivel);

                    if (acmeRobots.adicionarRobo(novoRobo)) {
                        getTextAreaMensagem().setText("");
                        gravarArquivoRobo.gravarDados(novoRobo);
                        getTextAreaMensagem().setText("Cadastro concluído.");

                    }

                    textFieldID.setText("");
                    textFieldModelo.setText("");
                    textFieldNivel.setText("");

                } catch (NumberFormatException exc) {
                    getTextAreaMensagem().setText("Erro ao inserir ID.");
                    textFieldID.setText("");
                }
            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldID.setText("");
                textFieldModelo.setText("");
                textFieldNivel.setText("");
                textArea1.setText("");
            }
        });

        retornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(2);
            }
        });
    }

    public JTextArea getTextAreaMensagem() {
        return textArea1;
    }

    public JPanel getPainel() {
        return painel5;
    }
}
