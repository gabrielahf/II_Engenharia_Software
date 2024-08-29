public class CelsiusKelvin implements ConversorTemperatura {

    @Override
    public double converteTemperatura(double temperatura) {
        return temperatura + 273.15;
    }

    @Override
    public String nomeOrigem() {
        return "Celsius";
    }

    @Override
    public String nomeDestino() {
        return "Kelvin";
    }

    @Override
    public char simboloOrigem() {
        return 'C';
    }

    @Override
    public char simboloDestino() {
        return 'K';
    }
}
