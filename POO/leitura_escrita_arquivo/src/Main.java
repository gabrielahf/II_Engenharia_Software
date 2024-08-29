import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;


public class Main {

    private Scanner entrada = null;
    private PrintStream saidaPadrao = System.out;

    public Main(){
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader("dados.txt"));
            entrada = new Scanner(streamEntrada);   // Usa como entrada um arquivo
            PrintStream streamSaida = new PrintStream(new File("saida.txt"), Charset.forName("UTF-8")); //tipo de arquivo texto usado "Charset.forName"
            System.setOut(streamSaida);// Usa como saida um arquivo

        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
        entrada.useLocale(Locale.ENGLISH);

        //Scanner entrada;
        //entrada = new Scanner(System.in);

        String nome;
        int idade;

        System.out.println("Digite a idade: ");
        idade = entrada.nextInt();
        entrada.nextLine();
        System.out.println("Digite o nome: ");
        nome = entrada.nextLine();

        System.out.println("idade: " + idade);
        System.out.println("nome: " + nome);

    }

    public static void main(String[] args) {
        Main main = new Main(); // criar objeto da classe

    }
}