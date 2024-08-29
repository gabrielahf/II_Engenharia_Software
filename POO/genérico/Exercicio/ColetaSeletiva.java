package genericos.Exercicio;

public class ColetaSeletiva {

    // Gravacao de objetos Coleta
    public int gravaLogradouro() {
        Path arq1 = Paths.get("coleta_seletiva.csv");
        try (ObjectOutputStream oarq = new ObjectOutputStream(Files.newOutputStream(arq1))) {
            oarq.writeObject(lista);
        } catch (IOException e1) {
            return 1;
        } catch (Exception e2) {
            return 2;
        }
        return 0;
    }

    // Leitura de objetos Coleta
    public int leLogradouro() {
        Path arq2 = Paths.get("coleta_seletiva.csv");
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


}
