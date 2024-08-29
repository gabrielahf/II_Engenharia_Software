package dados;

public enum EstadoCivil {
    SOLTEIRO("Solteiro"), CASADO("Casado"), DIVORCIADO("Divorciado"), VIUVO("Viuvo");

    private EstadoCivil(String s){
        extenso = s;
    }

    private final String extenso;

    public String getExtenso() {
        return extenso;
    }

}