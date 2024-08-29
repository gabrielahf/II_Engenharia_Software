public class Caminhonete extends Veiculo implements Imposto{

    private boolean tracao4X4;

    public Caminhonete(int ano, String placa, double custoPorKmComum, int kmsAlugados, boolean tracao4X4){
        super(ano, placa, custoPorKmComum,kmsAlugados);
        this.tracao4X4 = tracao4X4;
    }
    public boolean isTracao4X4(){
        return tracao4X4;
    }

    public void setTracao4X4(boolean tracao4X4) {
        this.tracao4X4 = tracao4X4;
    }

    @Override
    public double calculaLocacao(int kmsRodados){
        double Locacao= super.getCustoPorKmComum()*kmsRodados;

        if (tracao4X4) {
            Locacao += 400.0;
        }
        return Locacao;
    }

    @Override
    public double calculaImposto(){
        double imposto = 0;
        imposto = calculaLocacao(kmsAlugados) * 0.20;
        return imposto;
    }

}
