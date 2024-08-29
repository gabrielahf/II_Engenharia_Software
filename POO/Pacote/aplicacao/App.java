package aplicacao;

import dados.*; // deseja o acesso de todas as classe do pacote dados

public class App {

    public void executar() {
        System.out.println("Executando!");
        Conta c;
        c = new Conta(111.11);
        System.out.println("Saldo: " + c.getSaldo());

        c = new ContaEspecial(222.22, 333.33);  // Polimorfismo de classe
        System.out.println("Saldo: " + c.getSaldo());

        if(c instanceof ContaEspecial)
            System.out.println("Limite: " + ((ContaEspecial)c).getLimite());

        Tributavel t;
        ContaEspecial ce;
        ce = new ContaEspecial(444.44,666.66);
        t = ce;     // Polimorfismo de interface

        System.out.println("Imposto: " + t.calculaImposto());
    }

}
