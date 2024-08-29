import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LeituraArqJava {

    public static void main(String[] args) {
        List<String> expressoes = new ArrayList<>();
        BufferedReader reader;
        Path path1 = Paths.get("expressoes3.txt");
        try {
            reader = Files.newBufferedReader(path1, Charset.defaultCharset());
            String line = null;
            while ((line = reader.readLine()) != null) {
                expressoes.add(line); // Adiciona a expressão lida à lista
                System.out.println("--- Inicio expressao");
                String v[] = line.split(" ");
                for (String s : v) {
                    System.out.println(s);
                }
                System.out.println("--- Fim expressao");
            }
            reader.close();
        } catch (IOException e) {
            System.err.format("Erro na leitura do arquivo: ", e);
        }

        Calculadora calculadora = new Calculadora();
        calculadora.processExpressoes(expressoes);
    }
}
