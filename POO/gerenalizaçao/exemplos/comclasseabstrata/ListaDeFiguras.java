package comclasseabstrata;

public class ListaDeFiguras {
    private Figura vetFigura[];  // Array de figuras
    private int qtdMax, total;  // Contadores

    public ListaDeFiguras(int maximo) {
        qtdMax = maximo;
        vetFigura = new Figura[qtdMax];
        total = 0;
    }

    public void insere(Figura novaFigura) {
        if (total < qtdMax) {
            vetFigura[total] = novaFigura;
            total++;
        }
    }

    public void mostraFiguras() {
        int cont;
        for (cont = 0; cont < total; cont++)
            vetFigura[cont].mostrar();
    }
}