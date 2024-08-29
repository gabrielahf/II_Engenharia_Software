package dados;

public enum Status {
    CADASTRADA ("Cadastrada"),
    EXECUTANDO ("Executando"),
    FINALIZADA ("Finalizada"),
    CANCELADA ("Cancelada");

    private String situacao;

    Status(String situacao) {
        this.situacao = situacao;
    }

    public String getSituacao(){
        return situacao;
    }
}
