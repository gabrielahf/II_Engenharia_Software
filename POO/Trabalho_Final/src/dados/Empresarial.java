package dados;

import java.util.List;

public class Empresarial extends Cliente {
    private int ano;
    private Robo robos;


    public Empresarial(int codigo, String nome, int ano, Robo robos) {
        super(codigo, nome);
        this.ano = ano;
        this.robos = robos;
    }

    public Empresarial(int codigo, String nome, int ano) {
        super(codigo,nome);
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }


    @Override
    public double calculaDesconto() {
        while (robos != null){
            List<Robo> roboList = robos.getListaRobos();
            int qtdRobos = roboList.size();
            if (qtdRobos >= 2 && qtdRobos <= 9){
                return  0.03;
            } else if (qtdRobos > 10){
                return 0.07;
            }
        }
        return 0;
    }


}