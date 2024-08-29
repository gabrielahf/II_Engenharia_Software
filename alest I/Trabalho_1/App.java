public class App {
    public static void main(String[] args) {
        Funcao f  = new Funcao();

        for(long n=10; n<1000; n+=50) {
            long r = f.fe(n); // Chame uma a uma as funcoes para
                             // analisar os seus comportamentos.
            System.out.println(n+";"+r);
        }

    }
}