package Form1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form1 {
    private JPanel painel1;
    private JButton OK;
    private JButton FECHAR;
    private JTextField campo;
    private JTextArea area;


    public JPanel getPainel(){
        return painel1;
    }

    public Form1() {
        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String texto = campo.getText();
                area.append(texto);
            }
        });
        FECHAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }
}
