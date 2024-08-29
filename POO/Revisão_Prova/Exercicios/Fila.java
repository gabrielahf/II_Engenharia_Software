 public class Queue {

        // Atributos
        private DoubleLinkedListOfInteger fila;

        public Queue() {
            fila = new DoubleLinkedListOfInteger();
        }

        // insere o elemento e no final da fila
        public void enqueue(Integer element) {
            fila.add(element);
        }

        // remove e retorna o elemento e do início da fila,
// e dá erro se a fila estiver vazia
        public Integer dequeue() {
            if (fila.isEmpty()) {
                throw new RuntimeException("A fila esta vazia!"); // erro
            }
            return fila.removeByIndex(0);
        }

        // retorna, mas não remove, o primeiro elemento da fila,
        // e dá erro se a fila estiver vazia
        public Integer head() {
            if (fila.isEmpty()) {
                throw new RuntimeException("A fila esta vazia!"); // erro
            }
            return fila.get(0);
        }

        // retorna o número de elementos da fila
        public int size() {
            return fila.size();
        }

        //retorna true se a fila estiver vazia, e false caso contrário
        public boolean isEmpty() {
            return fila.isEmpty();
        }

        //esvazia a fila
        public void clear() {
            fila.clear();
        }


    /*
    Apresentar o algoritmo de um método que recebe uma lista e uma fila de
    inteiros por parâmetro. Este método deve copiar o conteúdo da fila no
    final da lista, mas no final a fila deve estar com o seu conteúdo original,
    isto é, ela não deve ser alterada.
     */
    public static void copiaParaLista(DoubleLinkedListOfInteger lista, Queue fila) {
        for(int i=0; i<fila.size(); i++) {
            Integer elem = fila.dequeue(); // Tira da fila
            lista.add(elem); // coloca na lista
            fila.enqueue(elem); // coloca de volta na fila
        }
    }

    /*
    Apresentar o algoritmo de um método que recebe duas filas de inteiros
    por parâmetro. Este método deve retornar uma lista concatenando o
    conteúdo das duas filas, mas no final as filas devem estar com o seu
    conteúdo original, isto é, elas não devem ser alteradas.
     */
    public DoubleLinkedListOfInteger concatena(Queue q1, Queue q2) {
        DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger();

        for(int i=0; i<q1.size(); i++) {
            Integer elem = q1.dequeue(); // Tira da fila
            lista.add(elem); // coloca na lista
            q1.enqueue(elem); // coloca de volta na fila
        }

        for(int i=0; i<q2.size(); i++) {
            Integer elem = q2.dequeue(); // Tira da fila
            lista.add(elem); // coloca na lista
            q2.enqueue(elem); // coloca de volta na fila
        }

        return lista;
    }

    /*
    Na classe da fila acrescente um método chamado clone. Este método deve retornar uma
    cópia da fila, mas a fila “original” não deve ter seu conteúdo alterado.
     */

     public Queue clone() {
         Queue filaClone = new Queue();

         for(int i=0; i<size(); i++) {
             Integer elem = dequeue();
             filaClone.enqueue(elem);
             enqueue(elem);
         }

         return filaClone;
     }

    /*
    Apresente o algoritmo do método void copiaParaFila(Fila f, Pilha p), sabendo que ele deve
    copiar o conteúdo da pilha na fila, mas no final a pilha deve estar com os mesmos
    elementos, na mesma ordem.
     */

     public void copiaParaFila(Queue f, Pilha p){
         Pilha pAux = new Pilha();

         while(!f.isEmpty()){
             Integer element = p.pop();
             pAux.push(element);
             f.enqueue(element);
         }

         while(!p.isEmpty()){
             p.push(pAux.pop());
         }
     }

}

