package dados;

import java.io.Serializable;

public class Pessoa implements Serializable {
    private String nome;
    private EstadoCivil estadoCivil;     // Solteiro, Casado, Divorciado, Viuvo

    public Pessoa(String nome, EstadoCivil estadoCivil) {
        this.nome = nome;
        this.estadoCivil = estadoCivil;
    }

    public String getNome() {
        return nome;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

}