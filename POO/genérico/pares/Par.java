package genericos.pares;

/**
 * Classe generica com dois atributos de tipos genericos
 */
public class Par<T, S> {

    private T first;
    private S second;

    public Par(T firstElement, S secondElement) {
        first = firstElement;
        second = secondElement;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(S second) {
        this.second = second;
    }
    
    public T getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Par{" + "first=" + first + ", second=" + second + '}';
    }

}