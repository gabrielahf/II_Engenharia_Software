package janela;

import aplicacao.ACMERobots;
import dados.Agricola;
import dados.Robo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.util.List;

public class cadastroAgricola {
    private ACMERobots acmeRobots = new ACMERobots();
    private List<Robo> roboList;

    private JPanel painel3;
    private JTextField textFieldUso;
    private JTextField textFieldArea;
    private JTextField textFieldValorDiario;
    private JTextField textFieldModelo;
    private JTextField textFieldID;
    private JButton confirmarButton;
    private JButton LimparButton;
    private JButton retornarButton;
    private JTextArea textArea1;

    public cadastroAgricola(App app, ACMERobots robots) {
        acmeRobots = robots;
        roboList = acmeRobots.getListRobo();



        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(textFieldID.getText());
                    String modelo = textFieldModelo.getText();
                    double area = Integer.parseInt(textFieldArea.getText());
                    String uso = textFieldUso.getText();


                    if (textFieldID.getText().isEmpty() || textFieldModelo.getText().isEmpty() ||  textFieldArea.getText().isEmpty() || textFieldUso.getText().isEmpty()) {
                        getTextAreaMensagem().setText("");
                        getTextAreaMensagem().append("Preencher campo");
                        return;

                    }else {
                        Robo idExiste = acmeRobots.consultaPorId(id);
                        if (idExiste != null) {
                            getTextAreaMensagem().setText("");
                            getTextAreaMensagem().append("ID existente");
                            getTextAreaMensagem().setText("");
                            return;
                        }
                    }

                    Agricola novoRobo = new Agricola(id, modelo, area, uso);

                    if (acmeRobots.adicionarRobo(novoRobo)) {
                        getTextAreaMensagem().setText("");
                        getTextAreaMensagem().append("Cadastro concluído");
                    }


                    textFieldID.setText("");
                    textFieldModelo.setText("");
                    textFieldArea.setText("");
                    textFieldUso.setText("");

                } catch (NumberFormatException exc) {
                    getTextAreaMensagem().setText("");
                    getTextAreaMensagem().append("Erro ao inserir ID");
                    textFieldID.setText("");
                }
            }
        });
        LimparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldID.setText("");
                textFieldModelo.setText("");
                textFieldValorDiario.setText("");
                textFieldArea.setText("");
                textFieldUso.setText("");
                textArea1.setText("");
            }
        });
        retornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(2);
            } // volta para selecionar robo
        });
    }

    public JTextArea getTextAreaMensagem() {
        return textArea1;
    }

    public JPanel getPainel() {
        return painel3;
    }


}
