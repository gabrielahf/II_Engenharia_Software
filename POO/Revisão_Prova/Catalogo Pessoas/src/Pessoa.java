import java.util.ArrayList;


public class Pessoa {
    private static final int MAX = 3;
    private String nome;
    private int qtdTelefones;	// Quantidade de telefones da pessoa
    private ArrayList<Telefone> telefones;

    public Pessoa(String nome) {
        this.nome = nome;
        telefones = new ArrayList<Telefone>();
        qtdTelefones = 0;
    }

    public Pessoa(String nome, Telefone telefone) {
        this(nome);
        adicionaTelefone(telefone);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean adicionaTelefone(Telefone telefone) {
        if(qtdTelefones < MAX) {
            telefones.add(telefone);
            qtdTelefones++;
            return true;
        }
        return false;
    }

    public boolean isTelefoneValido(int ddd, String numero) {
        for(Telefone fone : telefones) {
            if(ddd==fone.getDdd() && numero.equals(fone.getNumero()))
                return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n" +
                "Telefones: " + telefones;
    }
}