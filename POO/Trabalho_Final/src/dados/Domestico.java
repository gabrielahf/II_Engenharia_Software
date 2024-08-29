package dados;


public class Domestico extends Robo{
    private double area;
    private String uso;
    private int nivel;


    public Domestico(int id, String modelo, int nivel) {
        super(id, modelo);
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public double defineValorDiario() {
        switch(nivel){
            case 1:
                return  10.0;
            case 2:
                return 20.0;
            case 3:
                return 50.0;
            default:
                throw new IllegalArgumentException("Nivel inválido");
        }
    }

    @Override
    public double calculaLocacao(int dias) {
       return defineValorDiario() * dias;
    }
}
