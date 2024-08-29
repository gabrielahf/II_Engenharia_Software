public class Potencia {

    public static int potencia(int base, int expoente) {
        if (expoente == 0){
            return 1;
    }
        int resultado = base;
        for (int i =1; i < expoente; i++) {
            resultado = resultado * base;
        }
        return resultado;


    }

    public static int potenciaRecursiva (int base, int expoente){
        if(expoente == 0) {
            return 1;
        }
        return base * potenciaRecursiva(base, expoente - 1);
    }

    public static void main(String[]args){
       System.out.println("(2, 3): " + Potencia.potencia(2,3));
        System.out.println("(2, 3): " + Potencia.potenciaRecursiva(2,3));
    }
}
