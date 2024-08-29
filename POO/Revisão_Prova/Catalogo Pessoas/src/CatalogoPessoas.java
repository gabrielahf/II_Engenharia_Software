import java.util.ArrayList;

public class CatalogoPessoas {
    private int qtdPessoas = 0;
    private ArrayList<Pessoa> pessoas;

    public CatalogoPessoas() {
        pessoas = new ArrayList<Pessoa>();
    }

    public boolean adicionaPessoa(Pessoa pessoa) {
        return pessoas.add(pessoa);
    }

    public Pessoa consultaPessoa(String nome) {
        for(int i=0; i < pessoas.size(); i++) {	// for contado
            Pessoa p = pessoas.get(i);
            String nomePessoa = p.getNome();
            if(nome.equals(nomePessoa)) {
                return p;
            }
        }
        return null;
    }

    public Pessoa consultaPessoa(int ddd, String numero) {
        for(Pessoa p : pessoas) {	// foreach
            if(p.isTelefoneValido(ddd,numero)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "CatalogoPessoas{" +
                "pessoas=" + pessoas +
                '}';
    }
}