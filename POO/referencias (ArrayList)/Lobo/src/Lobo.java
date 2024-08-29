public class Lobo {
    private String nome;
    private int idade;
    private double velocidade;

    public Lobo(String nome, int idade, double velocidade) {
        this.nome = nome;
        this.idade = idade;
        this.velocidade = velocidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    @Override
    public String toString() {
        return "Lobo{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", velocidade=" + velocidade +
                '}';
    }

}

