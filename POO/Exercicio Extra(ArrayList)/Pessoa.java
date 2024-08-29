public class Pessoa {
    private String nome;
    private int anoNascimento;
    public Pessoa(String n, int a) {
        nome = n;
        anoNascimento = a;
    }
    public String getNome() {
        return nome;
    }
    public int getAnoNascimento() {
        return anoNascimento;
    }
}
