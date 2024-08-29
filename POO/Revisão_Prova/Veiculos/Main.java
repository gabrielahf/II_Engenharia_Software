import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        ArrayList<Veiculo> vei = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Sedan ou Caminhonete (s/c)?");
        char vc = sc.next().charAt(0);
        System.out.println("Insira o ano:");
        int ano = sc.nextInt();
        sc.nextLine();
        System.out.println("Insira a placa:");
        String placa = sc.nextLine();
        System.out.println("Insira o custoPorKmComum:");
        double custoPorKmComum = sc.nextDouble();
        System.out.println("Insira o KmAlugado:");
        int KmAlugado = sc.nextInt();



        if (vc=='s') {
            System.out.println("Insira o NumPortas:");
            int numPortas = sc.nextInt();
            vei.add( new Sedan(ano, placa, custoPorKmComum, KmAlugado, numPortas));
        }else{
            System.out.println("è 4x4?:");
            boolean x = sc.nextBoolean();
            vei.add(new Caminhonete(ano, placa, custoPorKmComum, KmAlugado, x));

        }

        double TotalDaLocacao=0;

        for (Veiculo veiculo : vei) {
            double total= veiculo.calculaLocacao(KmAlugado);
            System.out.println("KmAlugados: "+ veiculo.getKmsAlugados() +  "  Custo Por km: "+  veiculo.getCustoPorKmComum());
            TotalDaLocacao+=total;
        }
        System.out.println("TOTAL da Locação: $ " + TotalDaLocacao);


        for (Veiculo veiculo : vei) {
            if (veiculo instanceof Caminhonete) {
                Caminhonete ca  = (Caminhonete) veiculo;
                double imposto = ca.calculaImposto();
                System.out.println("Imposto para o veículo " + veiculo.getPlaca() + " Imposto R$" + imposto);

            }
        }

        sc.close();

    }
}
