package dados;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Agenda implements Iterador {
    private ArrayList<Pessoa> colecao;
    private int posicaoAtual;

    public Agenda() {
        colecao = new ArrayList<Pessoa>();
    }

    public boolean addPessoa(Pessoa p) {
        return colecao.add(p);
    }

    public void clear() {
        colecao.clear();
    }

    @Override
    public void reset() {
        posicaoAtual = 0;
    }

    @Override
    public boolean hasNext() {
        if (posicaoAtual >= colecao.size())
            return false;
        return true;
    }

    @Override
    public Object next() {
        if (posicaoAtual < colecao.size()) {
            Object retorno = colecao.get(posicaoAtual);
            posicaoAtual++;
            return retorno;
        }
        return null;
    }

    public boolean salvaEmArquivo() throws IOException {
        Path arq = Paths.get("agenda.dat");
        ObjectOutputStream oarq = new ObjectOutputStream
                (Files.newOutputStream(arq));
        reset();
        while (hasNext()) {
            Pessoa p = (Pessoa) next();
            oarq.writeObject(p);
        }
        oarq.close();
        return true;
    }

    public boolean carregaDeArquivo() throws IOException, ClassNotFoundException {
        Path arq = Paths.get("agenda.dat");
        ObjectInputStream iarq = new
                ObjectInputStream(Files.newInputStream(arq));
        Pessoa p = null;
        p = (Pessoa) iarq.readObject();
        while (p != null) {
            addPessoa(p);
            p = (Pessoa) iarq.readObject();
        }
        return true;
    }
}