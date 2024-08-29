public abstract class Veiculo{

    private int ano;
    private String placa;
    protected double custoPorKmComum;
    protected int kmsAlugados;

    public Veiculo(int ano, String placa, double custoPorKmComum, int kmsAlugados){
        this.ano = ano;
        this.placa = placa;
        this.custoPorKmComum = custoPorKmComum;
        this.kmsAlugados = kmsAlugados;
    }

    public double getCustoPorKmComum() {
        return custoPorKmComum;
    }

    public int getKmsAlugados() {
        return kmsAlugados;
    }

    //não precisa
    public String getPlaca(){
        return placa;
    }

    public void setCustoPorKmComum(double custoPorKmComum) {
        this.custoPorKmComum = custoPorKmComum;
    }

    public void setKmsAlugados(int kmsAlugados) {
        this.kmsAlugados = kmsAlugados;
    }

    public abstract double calculaLocacao(int kmsRodados);
}