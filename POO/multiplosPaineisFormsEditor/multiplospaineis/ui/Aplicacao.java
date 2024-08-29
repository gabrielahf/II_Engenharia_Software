package multiplospaineis.ui;

import multiplospaineis.dados.Usuario;
import javax.swing.*;

/**
 * Aplicacao grafica
 */

public class Aplicacao extends JFrame {
    private FormUm formUm;
    private FormDois formDois;
    private Usuario usuario;

    public Aplicacao(Usuario usuario) {
        super();
        this.usuario = usuario;
        formUm = new FormUm(this, usuario);
        formDois = new FormDois(this, usuario);
        this.setContentPane(formUm.getPainel());
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
                this.setContentPane(formUm.getPainel());
                this.pack();
                this.setSize(800,200);
                break;
            case 2:
                formDois.atualiza();
                this.setContentPane(formDois.getPainel());
                this.pack();
                this.setSize(800,200);
                break;
        }
    }

}
