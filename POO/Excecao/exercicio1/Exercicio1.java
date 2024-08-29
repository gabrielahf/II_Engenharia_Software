package exercicio1;

public class Exercicio1 {

	public static void main(String args[]){
		try{
		   int i = getAlgo();
		   System.out.println("Tudo bem"); // imprime caso não ocorra exceções
		} catch (IndexOutOfBoundsException e1) {
		   System.out.println("Excecao 1");
		} catch (Exception e2){           // Captura qualquer outra exceção que não seja do tipo 'IndexOutOfBoundsException'
			// como i é sempre verdadeiro recebe a exceção IllegalArgumentException
		   System.out.println("Excecao 2");
		} finally {
		   System.out.println("Mais nada"); // executado independente de ter exceção ou não
		}
		System.out.println("Adeus");
		}

	public static int getAlgo() {
		if(true)
			throw new IllegalArgumentException();
		else
			return 0;
	}
	
	
}

/* Resposta:
Excecao 2
Mais nada
Adeus
 */