import java.util.ArrayList;

public class Equipe {
    private ArrayList<Funcionario> cadastro;
    private ArrayList<Vendedor> registro;

    public Equipe() {
        cadastro = new ArrayList<Funcionario>();
        registro = new ArrayList<Vendedor>();
    }


    public boolean addFuncionario(Funcionario f) {
        return cadastro.add(f);
    }

    public boolean addVendedor(Vendedor v) {
        return registro.add(v);
    }
    public Funcionario pesquisaNome(String nome) {
        for(Funcionario f : cadastro) {
            if(f.getNome().equals(nome))
                return f;
        }
        return null;
    }

    public double pesquisaSalario(String nome) {
        for(Funcionario f : cadastro) {
            if(f.getNome().equals(nome))
                return f.calculaSalario();
        }
        return -1;
    }
}
