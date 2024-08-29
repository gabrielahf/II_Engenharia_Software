package ManipularArquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public abstract class GravarArquivo {
    protected String nomeArquivo;

    public GravarArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public abstract void gravarDados(Object objeto);
}
