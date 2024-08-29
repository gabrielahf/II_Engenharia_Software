package genericos.produtosG2;

/**
 * Produto com campos genericos
 *
 * @param <T> codigo do produto
 * @param <U> preco do produto
 */
public class ProdutoG2P<T, U> {

    private T codigo;
    private String descricao;
    private U preco;

    public ProdutoG2P(T cod, String descr, U pr) {
        codigo = cod;
        descricao = descr;
        preco = pr;
    }

    public T getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public U getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "ProdutoG2P{" + "codigo=" + codigo + ", descricao="
                + descricao + ", preco=" + preco + '}';
    }
}
