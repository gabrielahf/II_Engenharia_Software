public class Matematica {
    public static String realizarDivisao(int dividendo, int divisor, int precisao) {
        if (divisor == 0) {
            return null;
        }

        double resultado = (double) dividendo / divisor;
        String formato = "%." + precisao + "f"; // %f - floating point - decimal number
        String resultadoFormatado = String.format(formato, resultado); 

        return resultadoFormatado;
    }
}


