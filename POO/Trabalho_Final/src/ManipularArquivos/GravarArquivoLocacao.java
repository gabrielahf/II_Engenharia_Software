package ManipularArquivos;

import dados.Locacao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GravarArquivoLocacao extends GravarArquivo {

    public GravarArquivoLocacao(String nomeArquivo) {
        super(nomeArquivo);
    }

    @Override
    public void gravarDados(Object objeto) {
        if (objeto instanceof Locacao) {
            Locacao locacao = (Locacao) objeto;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
                writer.write(locacao.toString());
                writer.newLine();
                System.out.println("Dados de locação gravados com sucesso em " + nomeArquivo);
            } catch (IOException e) {
                System.err.println("Erro ao gravar dados de locação em " + nomeArquivo + ": " + e.getMessage());
            }
        } else {
            System.out.println("Objeto não é uma locação. Não foi possível gravar os dados.");
        }
    }
}
