package multiplospaineis.ui;

import multiplospaineis.dados.Usuario;

import javax.swing.*;
import java.awt.event.*;

public class FormUm {
    private JTextField campoUsername;
    private JButton botaoTerminar;
    private JPanel painel;
    private JButton botaoConfirma;
    private JPasswordField campoPassword;
    private Aplicacao aplicacao;
    private Usuario user;

    public FormUm(Aplicacao aplicacao, Usuario usuario) {
        this.aplicacao = aplicacao;
        this.user = usuario;
        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.setUser(campoUsername.getText());
                user.setPassword(String.valueOf(campoPassword.getPassword()));
                aplicacao.mudaPainel(2);
            }
        });
        botaoTerminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    public JPanel getPainel() {
        return painel;
    }
}
