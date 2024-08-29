package comheranca;

public class EditorGrafico {

    public void executar() {
        ListaDeFiguras lista;
        Quadrado quadr;
        Circulo circ;

        // Cria uma lista para 50 figuras
        lista = new ListaDeFiguras(50);

        // Cria figuras e insere-os na lista
        quadr = new Quadrado(10, 10, 10);
        lista.insere(quadr);
        circ = new Circulo(20, 20, 20);
        lista.insere(circ);
        quadr = new Quadrado(30, 30, 30);
        lista.insere(quadr);

        // Mostra as figuras da lista
        lista.mostraFiguras();
    }
}