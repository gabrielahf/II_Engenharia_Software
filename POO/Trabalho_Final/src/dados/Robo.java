package dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Robo implements Serializable {
    private int id;
    private String modelo;
    private double valorDiario;

    private Status status;
    private List<Robo> robos;
    private List<Locacao> locacaoList;

    public Robo(int id, String modelo) {
        this.id = id;
        this.modelo = modelo;
        this.locacaoList = new ArrayList<>();
    }

    public abstract double defineValorDiario();

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public double getValorDiario() {
        return valorDiario;
    }

    public List<Robo> getListaRobos() {
        return robos;
    }

    public abstract double calculaLocacao(int dias);

    public List<Locacao> getLocacao(){
        return locacaoList;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }



    @Override
    public String toString() {
        String padrao =  "Id: " + id + ", Modelo: " + modelo + ", Valor Diario: " + valorDiario;

        if (this instanceof Domestico){
            Domestico domestico = (Domestico) this;
            return padrao + ", nivel: " + domestico.getNivel();
        } else if (this instanceof  Industrial){
            Industrial industrial = (Industrial) this;
            return padrao + ", Ano: " + industrial.getSetor();
        } else if (this instanceof  Agricola){
            Agricola agricola = (Agricola) this;
            return padrao + ", Ano: " + agricola.getArea() + ", Uso:" + agricola.getUso();
        }
        return padrao;
    }
}
