package serializacao.dados;

import java.io.Serializable;

public class Endereco implements Serializable {
    private String logradouro;
    private int numero;
    private String complemento;
    private String cidade;
    private String estado;

    public Endereco(String logradouro, int numero, String complemento, String cidade, String estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Logradouro: " + logradouro + "\n" +
                "Numero: " + numero + "\n" +
                "Complemento: " + complemento + "\n" +
                "Cidade: " + cidade + "\n" +
                "Estado: " + estado;
    }
}
