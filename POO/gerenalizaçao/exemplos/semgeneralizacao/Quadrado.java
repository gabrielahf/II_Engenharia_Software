package semgeneralizacao;

public class Quadrado {
    private int x, y;
    private double lado;

    public Quadrado(int x, int y, double lado) {
        this.x = x;
        this.y = y;
        this.lado = lado;
    }

    public void setX(int novoX) {
        x = novoX;
    }

    public void setY(int novoY) {
        y = novoY;
    }

    public void mostrar() {
        System.out.println("Quadrado-lado: " + lado);
    }

    public void setLado(float novoLado) {
        lado = novoLado;
    }
}
