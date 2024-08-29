package comheranca;

public class Quadrado extends Figura {
    private double lado;

    public Quadrado(int x, int y, double lado) {
        super(x, y);
        this.lado = lado;
    }

    public void mostrar() {
        System.out.println("Quadrado-lado: " + lado);
    }

    public void setLado(float novoLado) {
        lado = novoLado;
    }
}
