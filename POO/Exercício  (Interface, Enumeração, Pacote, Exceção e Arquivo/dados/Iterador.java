package dados;

public interface Iterador {
    /**
     * Reinicia a iteracao na colecao
     */
    public abstract void reset();

    /**
     * Indica se ha elementos para a iteracao
     * @return true se ainda ha elementos para a iteracao
     */
    public abstract boolean hasNext();

    /**
     * Retorna o proximo elemento da colecao
     * @return proximo elemento da colecao
     */
    public abstract Object next();
}
