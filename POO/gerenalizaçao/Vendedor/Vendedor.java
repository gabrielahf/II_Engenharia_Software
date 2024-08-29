public class Vendedor  extends Gerente{

    private double comissao;

    public Vendedor(String nome, double salarioBase, double descontos, String setor, double adicionalSalario, double comissao) {
        super(nome, salarioBase, descontos, setor, adicionalSalario);
        this.comissao = comissao;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    @Override
    public double calculaSalario() {
        double salarioBase = super.calculaSalario();
        return salarioBase + comissao * salarioBase;
    }

    @Override
    public double calculaImposto() {
        double salario = calculaSalario();
        if(salario <= 500)
            return 0;
        else if(salario <= 2000)
            return salario * 0.10;
        else
            return salario * 0.20;
    }
}
