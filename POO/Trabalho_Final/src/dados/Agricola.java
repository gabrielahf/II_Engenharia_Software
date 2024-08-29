package dados;

public class Agricola extends Robo{
    private double area;
    private String uso;


    public Agricola(int id, String modelo, double area, String uso) {
        super(id, modelo);
        this.area = area;
        this.uso = uso;

    }

    public double getArea() {
        return area;
    }

    public String getUso() {
        return uso;
    }


    @Override
    public double defineValorDiario() {
        return 10.0 * area;
    }

    @Override
    public double calculaLocacao(int dias) {
        return defineValorDiario() * dias;
    }
}
