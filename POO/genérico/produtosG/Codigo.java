package genericos.produtosG;

/**
 * Codigo especifico com campos (atributos) de tipos definidos
 */

public class Codigo {
    private String setor;
    private int codigoSetor;

    public Codigo(String setor, int codigoSetor) {
        this.setor = setor;
        setCodigoSetor(codigoSetor);
    }
    
    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getCodigoSetor() {
        return codigoSetor;
    }

    public void setCodigoSetor(int codigoSetor) {
        if (codigoSetor <= 0)
            codigoSetor = 1;
        this.codigoSetor = codigoSetor;
    }
    
    public String getCodigo() {
        return setor+codigoSetor;
    }

    @Override
    public String toString() {
        return "Codigo{" + "setor=" + setor + ", codigoSetor=" + codigoSetor + '}';
    }
    
    
    
}
