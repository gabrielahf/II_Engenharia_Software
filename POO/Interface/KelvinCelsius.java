public class KelvinCelsius implements ConversorTemperatura{

        @Override
        public double converteTemperatura(double temperatura) {
            return temperatura - 273.15;
        }

        @Override
        public String nomeOrigem() {
            return "Kelvin";
        }

        @Override
        public String nomeDestino() {
            return "Celsius";
        }

        @Override
        public char simboloOrigem() {
            return 'K';
        }

        @Override
        public char simboloDestino() {
            return 'C';
        }
}


