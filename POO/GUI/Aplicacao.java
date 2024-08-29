import javax.swing.*;

public class Aplicacao extends JFrame {
    private Form1 form1;

    public Aplicacao() {
        super();
        form1 = new Form1();
        add(form1.getPainel());
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
