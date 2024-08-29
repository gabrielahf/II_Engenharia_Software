import java.util.ArrayList;

public class Atleta {

    private int numero;
    private String nome;
    private String pais;

    private ArrayList<Medalha> medalhas;


    public Atleta(int numero, String nome, String pais){
        this.numero = numero;
        this.nome = nome;
        this.pais = pais;
        medalhas = new ArrayList<>();

    }

    public ArrayList<Medalha> getMedalhas(){
        return medalhas;
    }

    public int getNumero() {
        return numero;
    }

    public String getNome() {
        return nome;
    }

    public String getPais() {
        return pais;
    }

    //adiciona uma nova medalha ao atleta.
    public void adicionaMedalha(Medalha medalha){
       medalhas.add(medalha);
    }


    //retorna a quantidade de medalhas do atleta.
    public int consultaQuantidadeMedalhas() {
        return medalhas.size();
    }

}
