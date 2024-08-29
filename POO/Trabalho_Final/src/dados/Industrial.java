package dados;

public class Industrial extends Robo{
    private String setor;

    public Industrial(int id, String modelo,String setor) {
        super(id, modelo);
        this.setor = setor;
    }

    public String getSetor() {
        return setor;
    }

    @Override
    public double defineValorDiario() {
        return 90.0;
    }

    //O cálculo de uma locação depende do número de dias da locação, dos robôs locados e do cliente.
    @Override
    public double calculaLocacao(int dias) {
        return defineValorDiario() * dias;
    }
}
