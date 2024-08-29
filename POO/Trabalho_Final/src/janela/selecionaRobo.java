package janela;

import aplicacao.ACMERobots;
import dados.Robo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.List;

public class selecionaRobo {
    private ACMERobots acmeRobots = new ACMERobots();
    private List<Robo> roboList;

    private JPanel painel2;
    private JButton AGRÍCOLAButton;
    private JButton DOMÉSTICOButton;
    private JButton INDUSTRIALButton;
    private JButton robosCadastradosButton;
    private JButton limparButton;
    private JButton fecharButton;
    private JTextArea textAreaMensagem;
    private JButton retornarButton;

    public selecionaRobo(App app, ACMERobots robots) {
        acmeRobots = robots;
        roboList = acmeRobots.getListRobo();

        AGRÍCOLAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(3);
            }
        });
        INDUSTRIALButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(4);
            }
        });
        DOMÉSTICOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(5);
            }
        });

        //mostrar o registro dos robos
        robosCadastradosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaMensagem.setText("");
                roboList.sort(Comparator.comparingInt(Robo::getId));

                for (Robo robo : roboList){
                    textAreaMensagem.append(robo.toString() +  "\n");
                }
            }
        });
        fecharButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaMensagem.setText("");
            }
        });

        retornarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(1);
            } //volta para tela inicial
        });
    }

    public JTextArea getTextAreaMensagem() {
        return textAreaMensagem;
    }

    public JPanel getPainel() {
        return painel2;
    }
}
