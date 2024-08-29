import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Scanner;

public class Skynet {
    private Enxame enxame;

    private Scanner entrada = new Scanner(System.in);  // Atributo para entrada de dados
    private PrintStream saidaPadrao = System.out;   // Guarda a saida padrao - tela (console)
    private final String nomeArquivoEntrada = "‘dadosin.txt";  // Nome do arquivo de entrada de dados
    private final String nomeArquivoSaida = "dadosout.txt";  // Nome do arquivo de saida de dados

    // Construtor da classe de aplicacao
    public Skynet() {
        redirecionaES();    // Redireciona E/S para arquivos

        enxame = new Enxame();// Implemente aqui o seu codigo adicional do construtor

    }


    private void cadastrarRobos(){
        //Cadastra robôs: lê todos os dados de cada robô e, se o modelo não for repetido,cadastra o novo robô no sistema
        String modelo;
        double valor;

        modelo = entrada.nextLine();
        while(!modelo.equals("-1")){ //condiçao de parada
            valor = entrada.nextDouble();
            entrada.nextLine(); // para evitar problemas de leitura entre string e numero
            Robo r = new Robo(modelo,valor);
            enxame.adicionaRobo(r);

            modelo = entrada.nextLine();
        }

    }

    private void mostrarSomatorio(){
        //Mostra o somatório de valores dos robôs cadastrados: mostra o somatório de valores dos robôs que foram cadastrados no sistema
        //calculaSomatorio();
    }

    private void mostrarUmRobo(){
        //Mostra os dados de um determinado robô: lê o modelo de um robô. Se existir um robô com o modelo indicado, mostra os dados de robô. Caso não exista um
        //robô com o modelo indicado, mostra a mensagem: “Robo inexistente”.
        //consultaRobo();

    }

    public void executar(){
        cadastrarRobos();
        mostrarSomatorio();
        mostrarUmRobo();
    }

    private void redirecionaES() {
        try {
            BufferedReader streamEntrada = new BufferedReader(new FileReader(nomeArquivoEntrada));
            entrada = new Scanner(streamEntrada);   // Usa como entrada um arquivo
            PrintStream streamSaida = new PrintStream(new File(nomeArquivoSaida), Charset.forName("UTF-8"));
            System.setOut(streamSaida);             // Usa como saida um arquivo
        } catch (Exception e) {
            System.out.println(e);
        }
        Locale.setDefault(Locale.ENGLISH);   // Ajusta para ponto decimal
        entrada.useLocale(Locale.ENGLISH);   // Ajusta para leitura para ponto decimal
    }

    // Restaura E/S padrao de tela(console)/teclado
    // Chame este metodo para retornar a leitura e escrita de dados para o padrao
    private void restauraES() {
        System.setOut(saidaPadrao);
        entrada = new Scanner(System.in);
    }
}
