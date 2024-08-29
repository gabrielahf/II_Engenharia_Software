package multiplospaineis;

import multiplospaineis.dados.Usuario;
import multiplospaineis.ui.*;

/**
 * Varias telas com uso de multiplos paineis
 */

public class Main {
    public static void main(String[] args) {
        // Instancia os dados necessarios
        Usuario usuario = new Usuario();
        // Instancia a aplicacao com os dados
        Aplicacao aplicacao = new Aplicacao(usuario);
    }
}
