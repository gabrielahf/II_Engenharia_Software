public class Sedan extends Veiculo{

    private int numPortas;

    public Sedan(int ano, String placa, double custoPorKmComum, int kmsAlugados, int numPortas){
        super(ano,placa,custoPorKmComum,kmsAlugados);
        this.numPortas = numPortas;

        if(numPortas==2)
            this.numPortas = 2;
        else
            this.numPortas = 4;
    }

    @Override
    public double calculaLocacao(int kmsRodados) {
        double valorLocacao = 0;
        int diferencaKm = 0;
        if(kmsRodados <= getKmsAlugados())
            valorLocacao = kmsRodados * getCustoPorKmComum();
        else {
            valorLocacao = getKmsAlugados() * getCustoPorKmComum();
            diferencaKm = kmsRodados - getKmsAlugados();
            valorLocacao += diferencaKm * 1.1 * getCustoPorKmComum();
        }
        if(numPortas == 4)
            valorLocacao += 200;
        return valorLocacao;
    }
}

