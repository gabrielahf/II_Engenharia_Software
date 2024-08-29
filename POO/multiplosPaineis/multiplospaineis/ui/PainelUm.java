package multiplospaineis.ui;

import multiplospaineis.dados.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PainelUm extends JPanel {
    private Usuario usuario;
    private JTextField campoUsername;
    private JButton botaoTerminar;
    private JButton botaoConfirma;
    private JPasswordField campoPassword;

    public PainelUm(Aplicacao aplicacao, Usuario usuario) {
        super();
        this.usuario = usuario;
        GridLayout layout = new GridLayout(2,1);
        this.setLayout(layout);
        JLabel rotulo = new JLabel("Digite os dados");
        JLabel lUsuario = new JLabel("Usuario");
        campoUsername = new JTextField(20);
        JLabel lSenha = new JLabel("Senha");
        campoPassword = new JPasswordField(10);
        botaoConfirma = new JButton("Confirma e muda de tela");
        botaoTerminar = new JButton("Terminar");
        JPanel pRotulo = new JPanel();
        pRotulo.add(rotulo);
        this.add(pRotulo);
        JPanel pUsuario = new JPanel(new GridLayout(3,2));
        pUsuario.add(lUsuario);
        pUsuario.add(campoUsername);
        pUsuario.add(lSenha);
        pUsuario.add(campoPassword);
        pUsuario.add(botaoConfirma);
        pUsuario.add(botaoTerminar);
        this.add(pUsuario);

        botaoConfirma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setUser(campoUsername.getText());
                usuario.setPassword(String.valueOf(campoPassword.getPassword()));
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
}
