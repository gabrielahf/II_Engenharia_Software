package multiplospaineis.ui;

import multiplospaineis.dados.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PainelDois extends JPanel {
    private Aplicacao app;
    private Usuario usuario;
    private JButton voltaButton;
    private JButton terminaButton;
    private JLabel labelUsername;
    private JLabel labelPassword;

    public PainelDois(Aplicacao app, Usuario usuario) {
        super();
        this.app = app;
        this.usuario = usuario;
        JLabel lName = new JLabel("Username: ");
        JLabel lPass = new JLabel("Password: ");
        labelUsername = new JLabel(usuario.getUser());
        labelPassword = new JLabel(usuario.getPassword());
        voltaButton = new JButton("Volta");
        terminaButton = new JButton("Termina");
        GridLayout layout = new GridLayout(3, 2);
        JPanel painel = new JPanel();
        painel.setLayout(layout);
        painel.add(lName);
        painel.add(labelUsername);
        painel.add(lPass);
        painel.add(labelPassword);
        painel.add(voltaButton);
        painel.add(terminaButton);
        this.add(painel);

        labelUsername.setText(usuario.getUser());
        labelPassword.setText(usuario.getPassword());

        voltaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.mudaPainel(1);
            }
        });

        terminaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    // Atualizacao de componentes do painel 2
    public void atualiza() {
        labelUsername.setText(usuario.getUser());
        labelPassword.setText(usuario.getPassword());
    }
}
