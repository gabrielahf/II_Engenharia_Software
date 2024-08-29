package semgeneralizacao;

public class ListaDeFiguras {
    private Quadrado vetQuadr[];  // Array de quadrados
    private Circulo vetCirc[];  // Array de circulos
    private int qtdQuadr, qtdCirc, qtdMax;  // Contadores

    public ListaDeFiguras(int maximo) {
        qtdMax = maximo;
        vetQuadr = new Quadrado[qtdMax];
        vetCirc = new Circulo[qtdMax];
        qtdQuadr = 0;
        qtdCirc = 0;
    }

    public void insere(Quadrado novoQuadr) {
        if (qtdQuadr < qtdMax) {
            vetQuadr[qtdQuadr] = novoQuadr;
            qtdQuadr++;
        }
    }

    public void insere(Circulo novoCirc) {
        if (qtdCirc < qtdMax) {
            vetCirc[qtdCirc] = novoCirc;
            qtdCirc++;
        }
    }

    public void mostraFiguras() {
        int cont;
        for (cont = 0; cont < qtdQuadr; cont++) vetQuadr[cont].mostrar();
        for (cont = 0; cont < qtdCirc; cont++) vetCirc[cont].mostrar();
    }
}