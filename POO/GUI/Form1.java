import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form1 {
    private JPanel painel1;
    private JTextField campo;
    private JButton botaoOk;
    private JButton botaoSair;
    private JTextArea area;

    public Form1() {
        botaoOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = campo.getText();
                area.append(texto+"\n");
            }
        });
        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JPanel getPainel() {
        return painel1;
    }

}
