package genericos.produtosG2;

/**
 * Classe generica com 3 (campos) atributos genericos
 * @param <T> moeda
 * @param <U> parte inteira do valor
 * @param <S> parte fracionaria do valor
 */
public class Valor<T,U,S> {
    private T moeda;
    private U parteInteira;
    private S parteFracionaria;

    public Valor(T moeda, U parteInteira, S parteFracionaria) {
        this.moeda = moeda;
        this.parteInteira = parteInteira;
        this.parteFracionaria = parteFracionaria;
    }

    @Override
    public String toString() {
        return moeda + " "+ parteInteira + "," + parteFracionaria;
    }
    
}
