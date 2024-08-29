public class VeiculoEletrico extends Veiculo{
    private double bateria;


    public VeiculoEletrico(String placa, double valor, double bateria) {
        super(placa, valor);
        this.bateria = bateria;
    }

    public double getBateria() {
        return bateria;
    }

    public void setBateria(double bateria) {
        this.bateria = bateria;
    }

    @Override
    public double calculaIPVA() { //sobrescrita do metodo da superclasse na subclasse
        return super.calculaIPVA(); // SUPER pois o metodo faz parte da subclasse
    }

    @Override
    public String geraDescricao() {
        String descricao = new super.geraDescricao();
        //TERMINAR
        return super.geraDescricao();
    }
}
