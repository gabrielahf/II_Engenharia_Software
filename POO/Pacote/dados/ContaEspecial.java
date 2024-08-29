package dados;

public class ContaEspecial extends Conta implements Tributavel { // herança da classe Conta + implementação de interface (Tributavel)
    private double limite;

    public ContaEspecial(double saldo, double limite) {
        super(saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    @Override
    //subescrita do método da classe Conta
    public double getSaldo() {
        return super.getSaldo() + limite;
    }

    @Override
    //subescrita do método abstrato da classe Tributavel
    public double calculaImposto() {
        return limite * 0.5;
    }
}
