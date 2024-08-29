import java.util.ArrayList;

public class Frota{

    private ArrayList<Veiculo> lista;
    public static int  MAXIMO = 2000;

    public Frota() {
        lista = new ArrayList<>();
    }

    public void addVeiculo(Veiculo veiculo){
        lista.add(veiculo);
    }


    public int getQuantidade4X4(){
        int totalCaminhoneteTracao = 0;

       for(Veiculo veiculo : lista){
           if (veiculo instanceof Caminhonete){
               Caminhonete caminhonete = (Caminhonete) veiculo;
               if (caminhonete.isTracao4X4()){
                   totalCaminhoneteTracao++;
               }
           }
       }
       return totalCaminhoneteTracao;
    }
}