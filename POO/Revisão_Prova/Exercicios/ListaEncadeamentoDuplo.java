public class ListaEncadeamentoDuplo {
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
        // Primeiro verifica se index eh valido
        if (index < 0 || index > count )
            throw new IndexOutOfBoundsException();

        // Primeiro cria o nodo
        Node n = new Node(element);

        if (index == count) { // se insercao no final
            // OU CHAMAR O METODO ADD "this.add(element)"
            
            // Primeiro conecta o novo nodo na lista
            n.next = trailer;
            n.prev = trailer.prev;

            // Depois atualiza os encadeamentos
            trailer.prev.next = n;
            trailer.prev = n;
        }
        else {

            // Pega referencia para o nodo da posicao index
            Node aux = this.getNodeIndex(index);
            // Primeiro conecta o novo nodo na lista, antes da posicao index
            n.next = aux;
            n.prev = aux.prev;
            // Atualizar as referencias para apontarem para o novo nodo
            aux.prev.next = n;
            aux.prev = n;
            // Atualiza count
            count++;
        }

    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) {


    }

    /**
     * Remove o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {

    }

    /**
     * Retorna o elemento de uma determinada posicao da lista
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) {

    }

    /**
     * Retorna a referencia para o nodo da posicao index
     */
    private Node getNodeIndex(int index) {

    }


    /**
     * Substitui o elemento armazenado em uma determinada posicao
     * da lista pelo elemento recebido por parametro.
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer set(int index, Integer element) {

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
    }


    /**
     * Retorna true se a lista contem o elemento especificado
     * @param element o elemento a ser testado
     * @return true se a lista contém o elemento especificado
     */
    public boolean contains(Integer element) {

    }

    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a lista não contém o elemento
     */
    public int indexOf(Integer element) {

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


    /**
     * Inicializa o current na primeira posicao (para percorrer do inicio para o fim).
     */
    public void reset() {
        current= header.next;
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

    /**
     * Este método inverte o conteúdo da lista.
     * Analise a caracterização O do seu tempo de execução.
     */
    public void reverse() {
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

    /**
     * Percorre a lista e retira elementos repetidos, deixando
     * apenas uma ocorrência de cada elemento. Não pode chamar
     * outros métodos. Use os atributos da classe.
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
