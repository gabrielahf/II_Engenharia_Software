
public class LinkedListOfInteger {

    // Classe interna Node
    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }

        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }
    }


    // Referência para o primeiro elemento da lista encadeada.
    private Node head;
    // Referência para o último elemento da lista encadeada.
    private Node tail;
    // Contador para a quantidade de elementos que a lista contem.
    private int count;


    /**
     * Construtor da lista.
     */
    public LinkedListOfInteger() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Retorna o numero de elementos da lista.
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        head = null;
        tail = null;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element)  { // O(1)
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;
        count++;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posição da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {
        if (index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
    }

        // verificar se eh para retornar o ultimo elemento da lista
        if(index == (count - 1)){
            return tail.element;
        }

        Node aux = head;

        // faz aux percorrer ate a posiçao index
        for(int i=0; i < index; i++){
            aux = aux.next; // caminhar na lista
        }
        return aux.element;
    }

    /**
     * Retorna true se a lista contem o elemento especificado.
     * @param element o elemento a ser testado
     * @return true se a lista contem o elemento especificado
     */
    public boolean contains(Integer element) {
        Node aux = head;

        for(int i=0; i < count; i++){
            if(element.equals(aux.element)){
                return true;
            }
            aux = aux.next; //passa para prox. posiçao
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node aux = head;

        while (aux != null) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }

        return s.toString();
    }


    ////////////////////////////////////////////////////////////////

    /**
     * Substitui o elemento armanzenado em uma determinada posicao da lista pelo
     * elemento indicado.
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer set(int index, Integer element) {
       // Implemente o algoritmo
        return -1;
    }



    /**
     * Insere um elemento em uma determinada posicao da lista.
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) {
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
            Node n = new Node(element); // cria elemento

            if(index == 0){ //se inserçao no inicio
                if(count == 0){
                    tail = n; // inserçao lista vazia
                }else{
                    n.next = head; // nodo aponta para head
                }
                head = n; // atribuiçao de valor

            } else if (index == count) { // se inserçao no final
                tail.next = n; //posiçao final aponta para o nodo criado (conexão com o novo nodo)
                tail = n; // atribuiçao de valor (atualizar valor)

            } else{ //se inserçao no meio
                 Node prev = head;

                 for (int i = 0; i < index - 1; i++){
                     prev = prev.next;
                 }
                 n.next = prev.next;
                 prev.next = n;
            }

            //atualiza count
            count++;

    }



    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente.
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {
        if(count == 0)
            return false;

        if (element.equals(head.element)) { //se remocao do primeiro
            if(count == 1)
                tail = null;
            head = head.next;
            count--;
            return true;
        }
        Node prev = head; //referencia para o anterior
        Node aux = head.next; // referencia para o elemento que esta sendo verificado

        for(int i=1; i < count; i++){
            if(element.equals(aux.element)){ //se achou o elemento para remover
                if(aux == tail){
                    tail = prev;
                    tail.next = null;
                } else{
                    prev.next = aux.next;
                }
                count--;
                return true;
            }
            aux = aux.next;
            prev = prev.next;
        }
        return false;
    }



    /**
     * Remove o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
        if(index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){ //se remoçao no inicio
          Integer elemRemovido = head.element;
           head = head.next;
           if(count == 1) // se tem apenas um elemento na lista
               tail = null;
               count --;
               return elemRemovido;


        }
          Node prev = head; //se remoçao no meio ou final, caminha até posiçao anterior
        for (int i = 0; i < index - 1; i++){
            prev = prev.next;
        }
        Integer elemRemovido = prev.next.element;

        if(index == count -1){ // se remoçao no fim
            tail = prev;
            tail.next = null; //afirmar que esta vazio
        } else{ // se remoçao do meio
            Node aux = prev.next;
            prev.next = prev.next;
            //prev.next = prev.next.next; (outra forma de fazer)
        }
        count--;
        return elemRemovido;
    }


    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento.
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     */
    public int indexOf(Integer element) { // similar ao contains
        Node aux = head;

        for(int i=0; i < count; i++){
            if(element.equals(aux.element)){
                return i;
            }
            aux = aux.next; //passa para prox. posiçao
        }
        return -1;
    }


    /*
    Apresente um algoritmo para o método “boolean equals (LinkedListOfInteger outra)” a ser
incluído na classe LinkedListOfInteger, sabendo que ele deve retornar verdadeiro se a lista
recebida por parâmetro possuir os mesmos elementos da lista e na mesma ordem. Caso contrário
o método retorna falso.
     */
    public boolean equals(LinkedListOfInteger outra){
        //verificar o tamanho das listas
        if (count != outra.count){
            return false;
        }

        //mesmo tamanho, criar nodos para iniciar
        Node aux = head;
        Node auxOutra = outra.head;

        for (int i=0; i < count; i++){
            if (aux.element.equals(auxOutra.element) == false){
                return false;
            } else{
                aux = aux.next;
                auxOutra = auxOutra.next;
            }
            return true;
        }
    }

    //EXERCICIO 1 DA GINCANA
    public Integer[] getBackToFront(){
        //SEM RECURSÃO
        Node a[] = new Integer[count];
        Node aux = head;

        for (int i = count - 1; i>= 0; i--){
            a[i] = aux.element;
            aux = aux.next;
        }
        return a;
    }



    //EXERCICIO 1 DA GINCANA
    public Integer[] getBackToFront(){
        //COM RECURSÃO
        Node a[] = new Integer[count];
        getBackToFront(a, head, count - 1);
        return a;
    }

    private void getBackToFront(Integer []a, Node aux, int i){
        if(i >= 0){
            a[i] = aux.element;
            getBackToFront(a, aux.next, i - 1);
        }
    }



}
