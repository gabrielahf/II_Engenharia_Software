package ManipularArquivos;

import ManipularArquivos.GravarArquivo;
import dados.Robo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GravarArquivoRobo extends GravarArquivo {

    public GravarArquivoRobo(String nomeArquivo) {
        super(nomeArquivo);
    }

    @Override
    public void gravarDados(Object objeto) {
        if (objeto instanceof Robo) {
            Robo robo = (Robo) objeto;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
                writer.write(robo.toString());
                writer.newLine();
                System.out.println("Dados de robô gravados com sucesso em " + nomeArquivo);
            } catch (IOException e) {
                System.err.println("Erro ao gravar dados de robô em " + nomeArquivo + ": " + e.getMessage());
            }
        } else {
            System.out.println("Objeto não é um robô. Não foi possível gravar os dados.");
        }
    }
}