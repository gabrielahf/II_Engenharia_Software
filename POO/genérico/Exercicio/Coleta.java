package genericos.Exercicio;

public class Coleta implements Comparable {
    private double cod_logradouro;


    public Coleta(double cod_logradouro) {
        this.cod_logradouro = cod_logradouro;

    }

    public double getCodLogradouro() {
        return cod_logradouro;
    }



    @Override
    public int compareTo(Object o) {
        Coleta outro;
        outro = (Coleta) o;
        if (this.cod_logradouro < outro.getCodLogradouro())
            return -1;
        else if(this.cod_logradouro > outro.getCodLogradouro())
            return +1;
        return 0;
    }

    @Override
    public String toString() {
        String result = "";
        result += "Codigo logradouro: " + cod_logradouro;
        return result;
    }

}
