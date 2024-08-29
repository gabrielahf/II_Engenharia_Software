package janela;

import aplicacao.ACMERobots;
import dados.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class locacaoRobo {
    private ACMERobots acmeRobots = new ACMERobots();
    private List<Robo> roboList;
    private List<Locacao> locacaoList = new ArrayList<>();
    private String nomeArquivo;

    private JPanel painel11;
    private JTextField textFieldDataInicio;
    private JTextField textFieldDataFinal;
    private JTextField textFieldSituacao;
    private JTextField textFieldNumero;
    private JButton confirmarButton;
    private JButton retornarButton;
    private JButton limparButton;
    private JTextArea textArea1;
    private JButton adicionarButton;

    public locacaoRobo(App app, ACMERobots robots) {
        acmeRobots = robots;
        roboList = acmeRobots.getListRobo();


        //CADASTRA LOCACAO DO ROBO
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    int numero = Integer.parseInt(textFieldNumero.getText());
                    String status1 = textFieldSituacao.getText();
                    String dataInicio1 =textFieldDataInicio.getText();
                    int dataFim = Integer.parseInt(textFieldDataFinal.getText());


                    if (textFieldNumero.getText().isEmpty() || textFieldSituacao.getText().isEmpty() || textFieldDataInicio.getText().isEmpty() || textFieldDataFinal.getText().isEmpty()) {
                        getTextAreaMensagem().setText("");
                        getTextAreaMensagem().append("Preencher campo");
                        return;

                    }

                    Status status = Status.valueOf(status1.toUpperCase());

                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataInicio = formatter.parse(dataInicio1);

                    Locacao novoRobo = new Locacao(numero, status, dataInicio, dataFim);
                    locacaoList.add(novoRobo);

                    if (acmeRobots.cadastrarLocacao(novoRobo)) {
                        getTextAreaMensagem().setText("");

                        getTextAreaMensagem().append("Cadastro concluído");
                    }

                }catch (NumberFormatException excep){
                    getTextAreaMensagem().setText("");
                    getTextAreaMensagem().append("Erro ao inserir numero");
                    textFieldNumero.setText("");
                } catch (ParseException e1){
                    getTextAreaMensagem().setText("");
                    getTextAreaMensagem().append("Erro ao inserir data inicio");
                    textFieldDataInicio.setText("");
                }


            }
        });


        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    textFieldDataFinal.setText("");
                    textFieldNumero.setText("");
                    textFieldSituacao.setText("");
                    textFieldDataInicio.setText("");
                    textArea1.setText("");
            }
        });

        retornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(9);
            } //volta para selecionar Locacao
        });

        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldDataFinal.setText("");
                textFieldNumero.setText("");
                textFieldSituacao.setText("");
                textFieldDataInicio.setText("");
                textArea1.setText("");

                //CADASTRAR OUTRO ROBO
                try {

                    for (Robo robo : roboList) {
                        getTextAreaMensagem().append("Robo: " + robo.toString());
                        getTextAreaMensagem().append("\n");
                    }

                    int numero = Integer.parseInt(textFieldNumero.getText());
                    String status1 = textFieldSituacao.getText();
                    String dataInicio1 =textFieldDataInicio.getText();
                    int dataFim = Integer.parseInt(textFieldDataFinal.getText());


                    if (textFieldNumero.getText().isEmpty() || textFieldSituacao.getText().isEmpty() || textFieldDataInicio.getText().isEmpty() || textFieldDataFinal.getText().isEmpty()) {
                        getTextAreaMensagem().setText("");
                        getTextAreaMensagem().append("Preencher campo");
                        return;

                    }

                    Status status = Status.valueOf(status1.toUpperCase());

                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                    Date dataInicio = formatter.parse(dataInicio1);

                    Locacao novoRobo = new Locacao(numero, status, dataInicio, dataFim);
                    locacaoList.add(novoRobo);

                    if (acmeRobots.cadastrarLocacao(novoRobo)) {
                        getTextAreaMensagem().setText("");
                        getTextAreaMensagem().append("Cadastro concluído");
                    }

                }catch (NumberFormatException excep){
                    getTextAreaMensagem().setText("");
                    getTextAreaMensagem().append("Erro ao inserir numero");
                    textFieldNumero.setText("");
                } catch (ParseException e1){
                    getTextAreaMensagem().setText("");
                    getTextAreaMensagem().append("Erro ao inserir data inicio");
                    textFieldDataInicio.setText("");
                }

            }
        });
    }

    public JTextArea getTextAreaMensagem() {
        return textArea1;
    }

    public JPanel getPainel() {
        return painel11;
    }
}
