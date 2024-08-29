package comclasseabstrata;

public abstract class Figura {
    protected int x, y;

    public Figura(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int novoX) {
        x = novoX;
    }

    public void setY(int novoY) {
        y = novoY;
    }

    public abstract void mostrar();
}
