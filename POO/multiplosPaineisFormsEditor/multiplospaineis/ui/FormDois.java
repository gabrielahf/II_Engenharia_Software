package multiplospaineis.ui;

import multiplospaineis.dados.Usuario;

import javax.swing.*;
import java.awt.event.*;

public class FormDois {
    private JPanel painel;
    private JButton voltaButton;
    private JButton terminaButton;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private Aplicacao aplicacao;
    private Usuario user;

    public FormDois(Aplicacao app, Usuario usuario) {
        this.aplicacao = app;
        this.user = usuario;
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
        labelUsername.setText(user.getUser());
        labelPassword.setText(user.getPassword());
    }

    public JPanel getPainel() {
        return painel;
    }
}
