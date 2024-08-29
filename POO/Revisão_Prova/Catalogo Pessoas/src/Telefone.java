public class Telefone {
    private int ddd;
    private String numero;

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Telefone(int ddd, String numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "DDD: (" + ddd + ") "+
                "Numero: " + numero;
    }
}