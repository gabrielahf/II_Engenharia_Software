import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame implements ActionListener {

    JTextField textField;
    JLabel title;
    JCheckBox jCheckBox;

    public Screen(){

        //criar janela
        setVisible(true); //mostrar janela
        setSize(800,500); //tamanho da pagina
        setTitle("Cadastrar cliente"); //nome da aba
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fechar o programa
        setLocationRelativeTo(null); //aba abre no meio da tela

        //criar botao
        setLayout(null); // criar layout do botao
        JButton jButton = new JButton();
        jButton.setText("Clique aqui");
        jButton.setBounds(100,200,250,70);
        jButton.setFont(new Font("Arial", Font.BOLD, 20)); //fonte e tamanho do texto
        jButton.setForeground(new Color(250, 241, 241)); // cor de fundo da letra
        jButton.setBackground(new Color(10,10,10)); // cor de fundo do botao
        add(jButton); //adiciona o botao

        //ação botao
        jButton.addActionListener(this); //chamar o metodo de açao do botao
        jButton.addActionListener(this::teste); // '::teste' chamar metodo


        //criar caixa de texto
        textField.setBounds(100,100,100,100);
        textField.setFont(new Font("Arial", Font.BOLD, 20));
        textField.setText("Campo para preencher");
        add(textField);

        //cria titulo para caixa de texto
        JLabel jLabel = new JLabel();
        textField.setBounds(30,190,90,50);
        textField.setFont(new Font("Arial", Font.ITALIC, 20));
        textField.setText("Nome: ");
        add(jLabel);

        title = new JLabel("Cadastro");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setBounds(this.getX() / 2, 50, 480, 100);
        add(title);


        //criar checkBOX
        jCheckBox = new JCheckBox("Masculino");
        jCheckBox.setBounds(10, 10, 100, 100);

        jCheckBox.addActionListener(this::action);

        add(jCheckBox);



        setVisible(true);

    }

    private void action(ActionEvent actionEvent) {
        System.out.println(jCheckBox.isSelected());
    }

    // metodo caso haja mais de um botao para ter ação
    private void teste(ActionEvent actionEvent) {

        JOptionPane.showMessageDialog(null, "Dados incorretos", "Titulo", JOptionPane.WARNING_MESSAGE);
    }

    //ação para o botao
    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        Integer text = Integer.parseInt(textField.getText());
        title.setText(String.valueOf(text));

    }
}
