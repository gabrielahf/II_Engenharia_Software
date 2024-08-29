
public class DoubleLinkedListOfInteger {
    // Referencia para o sentinela de inicio da lista encadeada.
    private Node header;
    // Referencia para o sentinela de fim da lista encadeada.
    private Node trailer;
    // Referencia para a posicao corrente.
    private Node current;
    // Contador do numero de elementos da lista.
    private int count;

    private class Node {
        public Integer element;
        public Node next;
        public Node prev;
        public Node(Integer e) {
            element = e;
            next = null;
            prev = null;
        }
    }

    public DoubleLinkedListOfInteger() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        // Cria o nodo
        Node n = new Node(element);
        // Primeiro conecta o novo nodo na lista
        n.next = trailer;
        n.prev = trailer.prev;
        // Depois atualiza os encadeamentos
        trailer.prev.next = n;
        trailer.prev = n;
        // Atualiza o count
        count++;
    }

    /**
     * Insere um elemento em uma determinada posicao da lista
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) throws IndexOutOfBoundsException {
        if (index < 0 || index > count ) // indice invalido
            throw new IndexOutOfBoundsException();
        if(index == count){ // inserção no final
            this.add(element); // chama metodo que insere no final
        } else{
            // criar nodo
            Node n = new Node(element);
            //referencia para o nodo da posiçao index
            Node aux = this.getNodeIndex(index);
            //primeiro conecta o novo nodo na lista, antes da posição index
            n.next = aux;
            n.prev = aux.prev;
            //atualizar referencias para apontar o novo nodo
            aux.prev.next = n;
            aux.prev = n;
            //atualiza count
            count++;
        }
        // Implementar este método
    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if(aux.element.equals(element)) { // se achou
                // Remove
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;
                return true;
            }
            aux = aux.next; // faz apontar para o proximo nodo da lista
        }
        return false;
    }

    /**
     * Remove o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
        // Primeiro verifica se index eh valido
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        // "Caminha" ate a posicao index
        Node aux = getNodeIndex(index);
        // Atualizar as referencias para fazer a remocao
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        // Atualiza count
        count--;
        // Retorna o elemento removido
        return aux.element;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {
        // Primeiro verifica se index eh valido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeIndex(index);
        return aux.element;
    }

    /**
     * Retorna a referencia para o nodo da posicao index
     */
    private Node getNodeIndex(int index) {
        Node aux = null;

        if(index < count/2) { // se esta na primeira metade da lista
            // Percorre do inicio para o meio
            aux = header.next; // aponta para o primeiro da lista
            for(int i=0; i<index; i++) {
                aux = aux.next;
            }
        }
        else { // senao, se esta na segunda metade da lista
            // Percorre do final para o meio
            aux = trailer.prev; // aponta para o ultimo da lista
            for(int i=count-1; i>index; i--) {
                aux = aux.prev;
            }
        }

        return aux; // referencia para o nodo da posicao index
    }


    /**
     * Substitui o elemento armanzenado em uma determinada posicao da lista pelo elemento indicado
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer set(int index, Integer element) {
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = this.getNodeIndex(index); // utiliza o metodo para verificar o index que ocorrera a troca de valor
        Integer num = aux.element;
        aux.element = element; // substitui o elemento
        return num;
    }

    /**
     * Retorna um arranjo com uma copia de um subconjunto dos elementos da
     * lista.
     *
     * @param fromIndex a posição inicial ("inclusive") dos elementos a serem
     * incluídos
     * @param toIndex a posição final ("exclusive") dos elementos a serem
     * incluídos
     * @return um arranjo com um subconjunto da lista
     * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size())
     * @throws IllegalArgumentException se (fromIndex > toIndex)
     */
    public Integer[] subList(int fromIndex, int toIndex) {
        if(fromIndex < 0 || toIndex >= count)
            throw new IndexOutOfBoundsException();
        if(fromIndex > toIndex)
            throw new IllegalArgumentException();

        //cria o array
        Integer a[] = new Integer[toIndex - fromIndex];

        //caminha té primeira opçao
        Node aux = this.getNodeIndex(fromIndex);
        for(int i = 0; i < a.length; i++){
            a[i] = aux.element;
            aux = aux.next;
        }

        return a;
    }





    /**
     * Retorna true se a lista contem o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     */
    public int indexOf(Integer element) {
        Node aux = header.next;
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }

    /**
     * Esvazia a lista
     */
    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    /**
     * Retorna o numero de elementos da lista
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Retorna true se a lista não contem elementos
     * @return true se a lista não contem elementos
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        Node aux = header.next;
        for (int i = 0; i < count; i++) {
            s.append(aux.element.toString());
            s.append("\n");
            aux = aux.next;
        }
        return s.toString();
    }

    /**
     * Inicializa o current na primeira posicao (para percorrer do inicio para o fim).
     */
    public void reset() {
        current = header.next;
    }

    /**
     * Retorna o elemento da posicao corrente e faz current apontar para o proximo
     * elemento da lista.
     * @return elemento da posicao corrente
     */
    public Integer next() {
        if (current != trailer) {
            Integer num = current.element;
            current = current.next;
            return num;
        }
        return null;
    }


    /*
    Acrescentar na classe DoubleLinkedListOfInteger o seguinte método: public void reverse(). Este
método inverte o conteúdo da lista. Teste a sua implementação para este método na classe App e
analise a caracterização O do seu tempo de execução.
     */

    public void reverse(){
        Node aux1 = header.next;
        Node aux2 = trailer.prev;
        Integer num = 0;
        for (int i = 0; i < count / 2; i++){
            num = aux1.element;
            aux1.element = aux2.element;
            aux2.element = num;
            aux1 = aux1.next;
            aux2 = aux2.prev;
        }
    }


    /*
    Implemente um método que percorre a lista e retira elementos repetidos, deixando apenas uma
ocorrência de cada elemento. A assinatura deste método deve ser: public void unique().Teste a
sua implementação para este método na classe App e analise a caracterização O do seu tempo de
execução.
     */

    public void unique() {
        Node aux = header.next;

        while (aux != trailer){
            Node aux2 = aux.next;

            while (aux != trailer) {
                if (aux.element == aux2.element) { // se achou
                    // Remove
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                    count--;
                }
            }

        }
    }


}