package semgeneralizacao;

public class Circulo {
    private int x, y;
    private double raio;

    public Circulo(int x, int y, double raio) {
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public void setX(int novoX) {
        x = novoX;
    }

    public void setY(int novoY) {
        y = novoY;
    }

    public void mostrar() {
        System.out.println("Circulo-raio: " + raio);
    }

    public void setRaio(float novoRaio) {
        raio = novoRaio;
    }
}
