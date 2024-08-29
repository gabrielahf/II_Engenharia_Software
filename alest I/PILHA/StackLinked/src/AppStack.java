
public class AppStack {
    public static void main(String[] args) {
        StackLinked pilha = new StackLinked();
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

        while(!pilha.isEmpty()) {
            System.out.println(pilha.pop());
        }
    }

    /**
     * Recebe uma pilha por parametro e retorna um clone desta
     * pilha. No final, a pilha recebida por parametro nao pode
     * ficar vazia
     */
    public static StackLinked getClone(StackLinked p) {

        return null;
    }

    /**
     * Recebe um array por parametro e usa uma pilha para inverter
     * o conteudo do array.
     * @param vet
     */
    public static void inverte(Integer vet[]) {

    }


      /*
    Apresentar o algoritmo de um método que recebe duas pilhas por parâmetro e retorna
uma lista concatenando o conteúdo das duas pilhas, mas no final as pilhas devem estar
com o seu conteúdo original, isto é, elas não devem estar alteradas.
     */
    public StackLinked copiaParaPilha(DoubleLinkedListOfInteger lista){
        StackLinked pilhaAux1 = new StackLinked();
        StackLinked pilhaAux2 = new StackLinked();

        

        while(!pilhaAux1.isEmpty()){
            lista.remove(pilhaAux1.pop());

        } while(!pilhaAux2.isEmpty()){

        }

        for (int i = 0; i < this.size(); i++){
            Integer  element1 = pilhaAux1.pop();
            Integer element2 = pilhaAux2.pop();
            lista.add(element1);
            lista.add(element2);
            pilhaAux1.push(element1);
            pilhaAux2.push(element2);
        }
        return lista;
    }


}