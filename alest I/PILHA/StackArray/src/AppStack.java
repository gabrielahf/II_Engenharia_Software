
public class AppStack {
    public static void main(String[] args) {
        StackArray pilha = new StackArray();
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.push(40);
        pilha.push(50);
        System.out.println("Quantos elementos tem na pilha? " + pilha.size());
        // Remove e imprime todos os elementos da pilha
//        int tam = pilha.size();
//        for(int i=0; i<tam; i++) {
//            System.out.println(pilha.pop());
//        }

        StackArray clone = getClone(pilha);
        System.out.println("Quantos elementos tem na pilha clone? " + clone.size());
        System.out.println("Quantos elementos tem na pilha clone? " + clone.size());

        while(!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }
    }

    /**
     * Recebe uma pilha por parametro e retorna um clone desta
     * pilha. No final, a pilha recebida por parametro nao pode
     * ficar vazia
     */
    public static StackArray getClone(StackArray p) {
        StackArray pClone = new StackArray();
        StackArray pAux = new StackArray(); //precisa de uma pilha auxiliar devido a remoçao invertida da ordem

        while (!p.isEmpty()) {
            pAux.push(p.pop()); // tira os elementos da pilha original e coloca na pilha auxiliar
        } while(!pAux.isEmpty()){
            Integer element = pAux.pop();
            pClone.push(element);
            p.push(element);

        }
        return pClone;


    }

    /**
     * Recebe um array por parametro e usa uma pilha para inverter
     * o conteudo do array.
     * @param vet
     */
    public static void inverte(Integer vet[]) {

    }



}

