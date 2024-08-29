package janela;

import aplicacao.ACMERobots;
import dados.Cliente;
import dados.Locacao;
import dados.Robo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class selecionaLocacao {
    private ACMERobots acmeRobots = new ACMERobots();
    private List<Cliente> clienteList;
    private List<Robo> roboList;
    private List<Locacao> locacaoList;

    private JPanel painel9;
    private JCheckBox checkBoxCliente;
    private JCheckBox checkBoxRobo;
    private JButton LimparButton;
    private JButton retornarButton;
    private JTextArea textArea1;
    private JTextField textFieldCliente;
    private JTextField textFieldRobo;
    private JButton confirmarButton;
    private JButton exibirLocaçõesButton;


    public selecionaLocacao(App app, ACMERobots clientes, App app1, ACMERobots robots) {
        this.acmeRobots = acmeRobots;

        // Inicializar as listas a partir do ACMERobots
        clienteList = acmeRobots.getListCliente();
        roboList = acmeRobots.getListRobo();
        locacaoList = acmeRobots.getListLocacao();

        checkBoxCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acmeRobots = clientes;
                clienteList = acmeRobots.getListCliente();

                textFieldCliente.setVisible(false);

                if (checkBoxCliente.isSelected()){
                    getTextAreaMensagem().setText("");
                    for (Cliente cliente : clienteList){
                        textArea1.append(cliente.toString() +  "\n");
                    }
                        textFieldCliente.setVisible(true);
                } else{
                        textFieldCliente.setVisible(false);
                }
            }
        });
        checkBoxRobo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acmeRobots = robots;
                roboList = acmeRobots.getListRobo();

                textFieldRobo.setVisible(false);

                if (checkBoxRobo.isSelected()) {
                    for (Robo robo : roboList) {
                        textArea1.append(robo.toString() + "\n");
                    }
                        textFieldRobo.setVisible(true);
                } else {
                        textFieldRobo.setVisible(false);

                }
            }
        });


        retornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(1);
            } //volta para tela inicial
        });

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkBoxCliente.isSelected()){
                    //verificar se codigo existe
                    textFieldCliente.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int codigo = Integer.parseInt(textFieldCliente.getText());

                            try{
                                Cliente cliente = acmeRobots.consultaPorCodigo(codigo);

                                if (cliente != null){
                                    app.mudaPainel(10);

                                } else{
                                    JOptionPane.showMessageDialog(null, "Cliente inexistente");
                                }
                            }catch (NumberFormatException exce){
                                JOptionPane.showMessageDialog(null, "Código inválido");
                            }
                        }
                    });

                    app.mudaPainel(10);
                } else if(checkBoxRobo.isSelected()){
                    //verificar se id existe
                    textFieldRobo.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int id = Integer.parseInt(textFieldRobo.getText());


                            try {
                                Robo robo = acmeRobots.consultaPorId(id);

                                if (robo != null) {
                                    app.mudaPainel(11);

                                } else {
                                    JOptionPane.showMessageDialog(null, "Robo inexistente");
                                }
                            } catch (NumberFormatException exce) {
                                JOptionPane.showMessageDialog(null, "ID inválido");
                            }
                        }
                    });

                    app.mudaPainel(11); //verificar se é necessario esta linha
                } else{
                    return;
                }

            }
        });

        exibirLocaçõesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Limpar a área de mensagem antes de exibir novos dados
                getTextAreaMensagem().setText("");

                // Usar StringBuilder para construir o texto formatado
                StringBuilder textoFormatado = new StringBuilder();

                textoFormatado.append("#### LOCACAO DOS CLIENTES ####\n");
                for (Cliente cliente : clienteList){
                    // Verificar se o cliente tem locações associadas
                    List<Locacao> locacaoCliente = cliente.getLocacao();
                    if (!locacaoCliente.isEmpty()) {
                        //textoFormatado.append("Cliente: ").append(cliente.toString()).append("\n");
                        for (Locacao locacao : locacaoList){
                            textoFormatado.append(locacaoCliente.toString()).append("\n");
                        }
                    }
                }

                textoFormatado.append("\n#### LOCACAO DOS ROBOS ####\n");
                for (Robo robo : roboList){
                    // Verificar se o robo tem locações associadas
                    List<Locacao> locacaoRobo = robo.getLocacao();
                    if (!locacaoRobo.isEmpty()) {
                        //textoFormatado.append("Robo: ").append(robo.toString()).append("\n");
                        for (Locacao locacao : locacaoRobo){
                            textoFormatado.append(locacao.toString()).append("\n");
                        }
                    }
                }

                // Adicionar o texto ao conteúdo existente da JTextArea
                getTextAreaMensagem().append(textoFormatado.toString());
            }
        });



        LimparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getTextAreaMensagem().setText("");
                textFieldCliente.setText("");
                textFieldRobo.setText("");
            }
        });
    }

    public JTextArea getTextAreaMensagem() {
        return textArea1;
    }

    public JPanel getPainel() {
        return painel9;
    }

}
