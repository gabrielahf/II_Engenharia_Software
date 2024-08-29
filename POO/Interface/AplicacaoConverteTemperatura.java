import java.util.Locale;
import java.util.Scanner;

public class AplicacaoConverteTemperatura {
    private Scanner entrada;
    private ConversorTemperatura conversor = null;

    public void executa() {
        entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH);
        System.out.println("Conversor de temperaturas");
        System.out.println("Escalas: C-Celsius, K-Kelvin, F-Fahreiheit, R-Rankine");
        System.out.print("Indique a escala de origem: ");
        String origem = entrada.nextLine().toUpperCase();
        System.out.print("Indique a escala de destino: ");
        String destino = entrada.nextLine().toUpperCase();

        // Realiza a ligacao da classe que implementa a interface
        switch(origem) {
            case "C":
                switch(destino) {
                    case "C":
                        break;
                    case "K":
                        conversor = new CelsiusKelvin();
                        break;
                    case "F":
                        //conversor = new CelsiusFahrenheit();
                        break;
                    case "":
                        //conversor = new CelsiusRankine();
                        break;
                    default:
                        System.out.println("Escala de destino invalida.");
                }
                break;
            case "K":
                switch(destino) {
                    case "C":
                        conversor = new KelvinCelsius();
                        break;
                    case "K":
                        break;
                    case "F":
                        // conversor = new KelvinFahrenheit();
                        break;
                    case "R":
                        // conversor = new KelvinRankine();
                        break;
                    default:
                        System.out.println("Escala de destino invalida.");
                }
                break;
            case "F":
                switch(destino) {
                    case "C":
                        // conversor = new FahrenheitCelsius();
                        break;
                    case "K":
                        // conversor = new FahrenheitKelvin();
                        break;
                    case "F":
                        break;
                    case "R":
                        // conversor = new FahrenheitRankine();
                        break;
                    default:
                        System.out.println("Escala de destino invalida.");
                }
                break;
            case "R":
                switch(destino) {
                    case "C":
                        // conversor = new RankineCelsius();
                        break;
                    case "K":
                        // conversor = new RankineKelvin();
                        break;
                    case "F":
                        // conversor = new RankineFahrenheit();
                        break;
                    case "R":
                        break;
                    default:
                        System.out.println("Escala de destino invalida.");
                }
                break;
            default:
                System.out.println("Escala de origem invalida.");
        }

        // Executa a aplicacao com polimorfismo por interface
        System.out.print("Indique a temperatura a converter (graus "+conversor.nomeOrigem()+"): ");
        double temperaturaOrigem = entrada.nextDouble();
        entrada.nextLine();
        double temperaturaDestino;
        if(origem.equals(destino))
            temperaturaDestino = temperaturaOrigem;
        else
            temperaturaDestino = conversor.converteTemperatura(temperaturaOrigem);
        System.out.println("A temperatura: "+ temperaturaOrigem + "\260 " + conversor.simboloOrigem() +
                " equivale a " + temperaturaDestino + "\260 "+ conversor.simboloDestino() +
                " (graus " + conversor.nomeDestino() + ")");
    }

}

