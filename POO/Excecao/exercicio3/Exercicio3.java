package exercicio3;

/*
Ajuste também a classe Main para o tratamento das exceções
que mostre a mensagem correspondente de cada exceção.
 */

public class Exercicio3 {

	public static void main(String args[]) {
		ContaCorrente cc = null;
		try {
			cc = new ContaCorrente(1000);
			System.out.println("Saldo inicial: " + cc.getSaldo());
			cc.deposito(1000);
			cc.retirada(3000);
			System.out.println("Saldo final: " + cc.getSaldo());
		} catch (Exception e) {
			System.out.println("Mensagem da excecao: " + e.getMessage());
			System.out.print("Rastreabilidade de erro: ");
			e.printStackTrace();
		}
	}

}
