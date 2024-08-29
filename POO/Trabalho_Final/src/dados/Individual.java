package dados;

import java.util.List;

public class Individual extends Cliente{
    private String cpf;
    private Robo robos;

    public Individual(int codigo, String nome, String cpf, Robo robos) {
        super(codigo, nome);
        this.cpf = cpf;
        this.robos = robos;
    }

    public Individual(int codigo, String nome, String cpf) {
        super(codigo, nome);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public double calculaDesconto() {
        while (robos != null){
            List<Robo> roboList = robos.getListaRobos();
            int qtdRobos = roboList.size();
            if (qtdRobos > 1){
                return  0.05;
            }
        }
        return 0;
    }
}