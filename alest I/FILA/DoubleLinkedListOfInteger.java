
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

    // Inicializa current na primeira posicao
    public void reset() { // O(1)
        current = header.next;
    }
    
    // Retorna o elemento da posicao corrente e faz current apontar para o proximo
    public Integer next() { // O(1)
        if (current != trailer) {
            Integer num = current.element;
            current = current.next;
            return num;
        }
        return null;
    }
    
    /**
     * Adiciona um elemento ao final da lista
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        // Primeiro cria o nodo
        Node n = new Node(element);
        // Conecta o nodo criado na lista
        n.next = trailer;
        n.prev = trailer.prev;
        // Faz o correto encadeamento
        trailer.prev.next = n;
        trailer.prev = n;
        // Atualiza count
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
        
         if (index == count) { // se inserção no fim da lista
             this.add(element);
         }
         else {
             Node n = new Node(element); // Primeiro cria o nodo
             Node aux = getNodeIndex(index); // "Caminha" ate a posicao index
             // Primeiro "conecta" o nodo criado na lista
             n.prev = aux.prev;
             n.next = aux;
             // Atualiza as referências
             aux.prev.next = n;
             aux.prev = n;
             count++;
         }
    }
    
    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {
        Node aux = header.next;
        
        for(int i=0; i<count; i++) {
            if (aux.element.equals(element)) { // se encontrou element...
                // ...faz a remocao
                aux.prev.next = aux.next;
                aux.next.prev = aux.prev;
                count--;
                return true;
            }
            aux = aux.next;
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
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }        
        Node aux = getNodeIndex(index);
        aux.prev.next = aux.next;
        aux.next.prev = aux.prev;
        count--;
        return aux.element;
    }
    
    /**
     * Retorna true se a lista contem o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Integer element) {
        Node aux = header.next;
        for (int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }
    
    /**
     * Retorna o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) { // O(n)
        // Primeiro verifica se index eh valido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeIndex(index);
        return aux.element;
    }
    
    // Retorna a referencia para o nodo da posicao index
    private Node getNodeIndex(int index) {
        Node aux;
        if (index <= count/2) { //se esta na primeira metade da lista
            // percorre a lista do inicio para o meio
            aux = header.next;
            for (int i=0; i<index; i++)
                aux = aux.next;
        }
        else { // se esta na segunda metade da lista
            // percorre a lista do fim para o meio
            aux = trailer.prev;
            for (int i=count-1; i>index; i--)
                aux = aux.prev;
        }
        return aux;
    }
            
    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     */
    public int indexOf(Integer element) {
        Node aux = header.next; // aux aponta para o primeiro elemento da lista
        for (int i=0; i<count; i++) {
            if (aux.element.equals(element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1; 
    }
    
   /**
    * Substitui o elemento armanzenado em uma determinada posicao da lista pelo elemento indicado
    * @param index a posicao da lista
    * @param element o elemento a ser armazenado na lista
    * @return o elemento armazenado anteriormente na posicao da lista
    * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
    */
    public Integer set(int index, Integer element) {
        // Primeiro verifica se index eh valido
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException();
        }
        // Recebe a referencia para o nodo da posicao index
        Node aux = getNodeIndex(index);
        
        // Guarda o elemento da posicao index
        Integer num = aux.element;
        // Coloca o novo elemento na posicao index
        aux.element = element;
        // Retorna o elemento guardado
        return num;
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
        Integer a[] = new Integer[toIndex-fromIndex];
        
        Node aux = getNodeIndex(fromIndex);
        
        for(int i=0; i<a.length; i++) {
            a[i] = aux.element;
            aux = aux.next;
        }
        
        return a;
    }    
    
}
