package dados;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Locacao implements Serializable {
    private int numero;
    private Date dataInicio;
    private int dataFim;

    private Status status;
    private Cliente cliente;
    private List<Robo> robos;

    public Locacao(int numero, Status status, Date dataInicio, int dataFim) {
        this.numero = numero;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    //construtor para CLIENTE
    public Locacao(int numero, Status status, Date dataInicio, int dataFim, Cliente cliente) {
        this.numero = numero;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.cliente = cliente;
    }

    //construtor para ROBO
    public Locacao(int numero, Status status, Date dataInicio, int dataFim , List<Robo> robos) {
        this.numero = numero;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.robos = new ArrayList<>();
    }


    public int getNumero() {
        return numero;
    }

    public Status getStatus() {
        return status;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public int getDataFim() {
        return dataFim;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getClientes() {
        return cliente;
    }

    public void setRobo(List<Robo> robos) {
       this.robos = robos;
    }

    public List<Robo> getRobos() {
        return robos;
    }

    // valor final da locacao = valor de locacao de robos - desconto do cliente
    public double calculaValorFinal(){
      long diferencaDias = dataFim - dataInicio.getTime();
      int diasLocacao = (int) (diferencaDias / (1000 * 60 * 60 * 24));

        double valorLocacaoRobos = 0.0;
        if (robos != null){
            for (Robo robo : robos){
                valorLocacaoRobos += robo.calculaLocacao(diasLocacao);
            }
        }

        return valorLocacaoRobos * (1 - cliente.calculaDesconto());


    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getSituacao() {
        return status;
    }

    @Override
    public String toString() {
        if (cliente != null){
            return "Locação Cliente{" +
                    "Número=" + numero +
                    ", Status=" + status +
                    ", Data de Início=" + dataInicio +
                    ", Data de Fim=" + dataFim +
                    '}';
        } else if(robos != null){
            return "Locação Robo{" +
                    "Número=" + numero +
                    ", Status=" + status +
                    ", Data de Início=" + dataInicio +
                    ", Data de Fim=" + dataFim +
                    '}';
        } else{
            return "Locação{" +
                    "Número=" + numero +
                    ", Status=" + status +
                    ", Data de Início=" + dataInicio +
                    ", Data de Fim=" + dataFim +
                    '}';
        }
    }

}
