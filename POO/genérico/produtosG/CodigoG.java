package genericos.produtosG;

/**
 * Codigo generico com campos (atributos) de tipos genericos
 * @param <T> setor
 * @param <U> codigo
 */
public class CodigoG<T,U> {
    private T setor;
    private U codigoSetor;

    public CodigoG(T setor, U codigoSetor) {
        this.setor = setor;
        this.codigoSetor = codigoSetor;
    }
    
    public T getSetor() {
        return setor;
    }

    public void setSetor(T setor) {
        this.setor = setor;
    }

    public U getCodigoSetor() {
        return codigoSetor;
    }

    public void setCodigoSetor(U codigoSetor) {
        this.codigoSetor = codigoSetor;
    }
    
    public String getCodigo() {
        return ""+setor+codigoSetor;
    }

    @Override
    public String toString() {
        return "CodigoG{" + "setor=" + setor + ", codigoSetor=" + codigoSetor + '}';
    }    
}
