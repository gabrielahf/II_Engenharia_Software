import java.util.ArrayList;

// CADASTRA OS VEICULOS
public class Frota {
    private ArrayList<Veiculo> cadastro;

    public Frota() {
        cadastro = new ArrayList<Veiculo>();
    }

    public boolean addVeiculo(Veiculo f) {
        return cadastro.add(f);
    }

    public Veiculo pesquisaPlaca(String placa) {
        for(Veiculo v : cadastro) {
            if(v.getPlaca().equals(placa))
                return v;
        }
        return null;
    }

}
