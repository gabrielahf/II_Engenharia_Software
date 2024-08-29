import javax.swing.SwingUtilities;

import aplicacao.ACMERobots;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ACMERobots();
            }
        });
    }
}
