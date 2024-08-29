import java.util.ArrayList;

public class Enxame {
    private ArrayList<Robo> robos;

    public Enxame() {
        robos = new ArrayList<>();
    }

    public boolean adicionaRobo(Robo robo) {
        for (int i = 0; i < robos.size(); i++) {
            Robo novoRobo = robos.get(i);
            if (novoRobo.getModelo().equals(robo.getModelo())) {
                return false;
            }
        }

        robos.add(robo);
        return true;
    }

    /*
    if(consultaRobo(robo.getModelo()) != null) //REUTILIZAR METODO PARA NAO REPETIR
            return false;

       return robos.add(robo);
     */

    public int calculaSomatorio() {
        return robos.size();
    }

    public Robo consultaRobo(String modelo) {
        for (int i = 0; i < robos.size(); i++) {
            Robo novoRobo = robos.get(i);
            if (novoRobo.getModelo().equals(modelo)) {
                return novoRobo;
            }
        }
        return null;
    }

    /*
        for(Robo r : robos){  // for iterado, for each MELHOR PARA COLEÇOES
            if (novoRobo.getModelo().equals(modelo)) {
                return novoRobo;
            }
        }
            return null;
     */
}
