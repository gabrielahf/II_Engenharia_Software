import java.util.ArrayList;

public class Matilha {
    private ArrayList<Lobo> colecao;

    public Matilha() {
        colecao = new ArrayList<Lobo>(20);
    }

    // CRUD

    // Create - Cadastramento de novo lobo
    public void cadastraLobo(Lobo lobo) {
        colecao.add(lobo);
    }

    // Retrieve - Consulta um lobo por nome
    // Retorna o lobo com o nome indicado
    // senao retorna null
    public Lobo consultaPorNome(String nome) {
        if(!colecao.isEmpty()) {
            for(int i=0; i<colecao.size() ; i++) {
                Lobo l = colecao.get(i);
                if(l.getNome().equals(nome)) {
                    return l;
                }
            }
        }
        return null;
    }


}

