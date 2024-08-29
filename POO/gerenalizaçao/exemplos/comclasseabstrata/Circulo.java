package comclasseabstrata;

public class Circulo extends Figura {
    private double raio;

    public Circulo(int x, int y, double raio) {
        super(x, y);
        this.raio = raio;
    }

    public void mostrar() {
        System.out.println("Circulo-raio: " + raio);
    }

    public void setRaio(float novoRaio) {
        raio = novoRaio;
    }
}