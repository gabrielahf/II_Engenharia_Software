package dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente implements Serializable {
    private int codigo;
    private String nome;

    private List<Locacao> locacaoList;

    public Cliente(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
        this.locacaoList = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract double calculaDesconto();

    public List<Locacao> getLocacao(){
        return locacaoList;
    }

    @Override
    public String toString() {
        String padrao =  "Código: " + codigo + ", Nome: " + nome;

        if (this instanceof Individual){
            Individual individual = (Individual) this;
            return padrao + ", CPF: " + individual.getCpf();
        } else if (this instanceof  Empresarial){
            Empresarial empresarial = (Empresarial) this;
            return padrao + ", Ano: " + empresarial.getAno();
        }
        return padrao;
    }
}
