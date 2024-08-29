package multiplospaineis.ui;

import multiplospaineis.dados.Usuario;
import javax.swing.*;

/**
 * Aplicacao grafica
 */

public class Aplicacao extends JFrame {
    private Usuario usuario;
    private PainelUm painelUm;
    private PainelDois painelDois;

    public Aplicacao(Usuario usuario) {
        super();
        this.usuario = usuario;
        painelUm = new PainelUm(this,usuario);
        painelDois = new PainelDois(this,usuario);
        this.setContentPane(painelUm);
        this.setTitle("Varios paineis");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setSize(800,200);
        this.setVisible(true);
    }

    /**
     * Alterna os paineis da janela
     * @param painel numero do painel para a troca
     */
    public void mudaPainel(int painel) {
        switch(painel) {
            case 1:
                this.setContentPane(painelUm);
                this.pack();
                this.setSize(800,200);
                break;
            case 2:
                painelDois.atualiza();
                this.setContentPane(painelDois);
                this.pack();
                this.setSize(800,200);
                break;
        }
    }

}
