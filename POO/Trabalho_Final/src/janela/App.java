package janela;

import aplicacao.ACMERobots;
import javax.swing.*;

public class App extends JFrame {
    private ACMERobots acmeRobots = new ACMERobots();
    private telaInicial painel1;
    private selecionaRobo painel2;
    private cadastroAgricola painel3;
    private cadastroIndustrial painel4;
    private cadastroDomestico painel5;
    private selecionaCliente painel6;
    private cadastroIndividual painel7;
    private cadastroEmpresarial painel8;
    private selecionaLocacao painel9;
    private locacaoCliente painel10;
    private locacaoRobo painel11;
    private alterarLocacao painel12;


    public App(){
        super();
        setTitle("ACMERobots");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);

        // Inicializações dos painéis
        painel1 = new telaInicial(this, acmeRobots);

        //ROBO
        painel2 = new selecionaRobo(this, acmeRobots);
        painel3 = new cadastroAgricola(this, acmeRobots);
        painel4 = new cadastroIndustrial(this, acmeRobots);
        painel5 = new cadastroDomestico(this, acmeRobots);

        //CLIENTE
        painel6 = new selecionaCliente(this, acmeRobots); //painel1
        painel7 = new cadastroIndividual(this, acmeRobots); //painel2
        painel8 = new cadastroEmpresarial(this, acmeRobots); //painel3

        //LOCACAO
        painel9 = new selecionaLocacao(this, acmeRobots , this, acmeRobots);
        painel10 = new locacaoCliente(this,acmeRobots);
        painel11 = new locacaoRobo(this,acmeRobots);
        painel12 = new alterarLocacao(this, acmeRobots);


        // Adiciona o painel inicial ao JFrame
        setContentPane(painel1.getPainel());

        setVisible(true); // Mostra a janela
    }

    public void mudaPainel(int painel){
        switch (painel){
            case 1:
                this.setContentPane(painel1.getPainel());
                this.pack();
                break;
            case 2:
                this.setContentPane(painel2.getPainel());
                this.pack();
               break;
            case 3:
                this.setContentPane(painel3.getPainel());
                this.pack();
                break;
            case 4:
                this.setContentPane(painel4.getPainel());
                this.pack();
                break;
            case 5:
                this.setContentPane(painel5.getPainel());
                this.pack();
                break;
            case 6:
                this.setContentPane(painel6.getPainel());
                this.pack();
                break;
            case 7:
                this.setContentPane(painel7.getPainel());
                this.pack();
                break;
            case 8:
                this.setContentPane(painel8.getPainel());
                this.pack();
                break;
            case 9:
                this.setContentPane(painel9.getPainel());
                this.pack();
                break;
            case 10:
                this.setContentPane(painel10.getPainel());
                this.pack();
                break;
            case 11:
                this.setContentPane(painel11.getPainel());
                this.pack();
                break;
            case 12:
                this.setContentPane(painel12.getPainel());
                this.pack();
                break;
            default:
                throw new IllegalArgumentException("Número de painel inválido: " + painel);
        }
        pack();
        setSize(800, 500);
    }

}
