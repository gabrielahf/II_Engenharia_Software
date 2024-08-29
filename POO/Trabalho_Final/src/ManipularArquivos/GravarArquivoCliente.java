package ManipularArquivos;

import dados.Cliente;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GravarArquivoCliente extends GravarArquivo {

    public GravarArquivoCliente(String nomeArquivo) {
        super(nomeArquivo);
    }

    @Override
    public void gravarDados(Object objeto) {
        if (objeto instanceof Cliente) {
            Cliente cliente = (Cliente) objeto;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
                writer.write(cliente.toString());
                writer.newLine();
                System.out.println("Dados de cliente gravados com sucesso em " + nomeArquivo);
            } catch (IOException e) {
                System.err.println("Erro ao gravar dados de cliente em " + nomeArquivo + ": " + e.getMessage());
            }
        } else {
            System.out.println("Objeto não é um cliente. Não foi possível gravar os dados.");
        }
    }
}
