package serializacao.controle;

import serializacao.dados.Endereco;
import serializacao.dados.Pessoa;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.*;

public class CadastroPessoas {
    private Pessoa[] lista = null;

    public CadastroPessoas() {
        lista = new Pessoa[5];
    }

    // Pre-cadastrar algumas pessoas
    public int inicializa() {
        try {
            lista[0] = new Pessoa("Mario", new Endereco("Avenida Um", 111, "Apto. 111", "Porto Alegre", "RS"));
            lista[1] = new Pessoa("Maria", new Endereco("Rua Dois", 222, "Casa", "Canoas", "RS"));
            lista[2] = new Pessoa("Joao", new Endereco("Praca Tres", 333, "Casa 333", "Alvorada", "RS"));
        }
        catch(Exception e) {
            if(lista != null)
                for(int i=0; i<lista.length; i++) {
                    lista[i] = null;
                }
            return 1;
        }
        return 0;
    }

    // Gravacao de objetos Pessoa
    public int gravaPessoas() {
        Path arq1 = Paths.get("agenda.dat");
        try (ObjectOutputStream oarq = new ObjectOutputStream(Files.newOutputStream(arq1))) {
            oarq.writeObject(lista);
        } catch (IOException e1) {
            return 1;
        } catch (Exception e2) {
            return 2;
        }
        return 0;
    }

    // Leitura de objetos Pessoa
    public int lePessoas() {
        Path arq2 = Paths.get("agenda.dat");
        try (ObjectInputStream iarq = new ObjectInputStream(Files.newInputStream(arq2))) {
            lista = (Pessoa[]) iarq.readObject();
        } catch (ClassNotFoundException e1) {
            return 1;
        } catch (IOException e2) {
            return 2;
        } catch (Exception e3) {
            return 3;
        }
        return 0;
    }

    // Gera String a partir dos dados do cadastro
    public String consultaCadastro() {
        String aux = "";
        if(lista != null)
            for (Pessoa p : lista)
                if (p != null)
                    aux += p + "\n";
        return aux;
    }

}
