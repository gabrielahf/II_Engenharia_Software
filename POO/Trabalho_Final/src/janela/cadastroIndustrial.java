package janela;

import aplicacao.ACMERobots;
import dados.Industrial;
import dados.Robo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class cadastroIndustrial {
    private ACMERobots acmeRobots = new ACMERobots();
    private List<Robo> roboList;
    private String nomeArquivo;

    private JPanel painel4;
    private JTextField textFieldID;
    private JTextField textFieldModelo;
    private JTextField textFieldSetor;
    private JTextArea textArea1;
    private JButton confirmarButton;
    private JButton limparButton;
    private JButton retornarButton;

    public cadastroIndustrial(App app, ACMERobots robots) {
        acmeRobots = robots;
        roboList = acmeRobots.getListRobo();


        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(textFieldID.getText());
                    String modelo = textFieldModelo.getText();
                   // double valorDiario = Integer.parseInt(textFieldValorDiario.getText());
                    String setor = textFieldSetor.getText();


                    if (textFieldID.getText().isEmpty() || textFieldModelo.getText().isEmpty() || textFieldSetor.getText().isEmpty()) {
                        getTextAreaMensagem().setText("");
                        getTextAreaMensagem().append("Preencher campo");
                        return;

                    } else {
                        Robo idExiste = acmeRobots.consultaPorId(id);
                        if (idExiste != null) {
                            getTextAreaMensagem().setText("");
                            getTextAreaMensagem().append("ID existente");
                            getTextAreaMensagem().setText("");
                            return;
                        }
                    }

                        Industrial novoRobo = new Industrial(id, modelo, setor);

                        if (acmeRobots.adicionarRobo(novoRobo)) {
                            getTextAreaMensagem().setText("");
                            getTextAreaMensagem().append("Cadastro concluído");
                        }


                        textFieldID.setText("");
                        textFieldModelo.setText("");
                        textFieldSetor.setText("");

                    } catch(NumberFormatException ex){
                        getTextAreaMensagem().setText("");
                        getTextAreaMensagem().append("Erro ao inserir ID");
                        textFieldID.setText("");
                    }

            }
        });

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldID.setText("");
                textFieldModelo.setText("");
                textFieldSetor.setText("");
                textArea1.setText("");

            }
        });
        retornarButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed (ActionEvent e){
                    app.mudaPainel(2);
                } //volta para selecionar robo

        });
    }
    public JTextArea getTextAreaMensagem() {
        return textArea1;
    }

    public JPanel getPainel() {
        return painel4;
    }

}


