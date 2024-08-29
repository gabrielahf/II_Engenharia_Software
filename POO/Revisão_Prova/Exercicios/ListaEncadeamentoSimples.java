public class ListaEncadeamentoSimples {

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
        public ListaEncadeamentoSimples() {
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
        if (head == null){
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
            //erro
        }

        //verifica se é para retornar o ultimo elemento
        if (index == (count - 1)){
            return tail.element;
        }

        //percorre o nodo
        if (int i = 0; i < index; i++){
           head = head.next; // avança nos elementos
        }
        return head.element; // retorna o primeiro elemento

    }

    /**
     * Retorna true se a lista contem o elemento especificado.
     * @param element o elemento a ser testado
     * @return true se a lista contem o elemento especificado
     */
    public boolean contains(Integer element) {
        Node aux = head;
        for(int i=0; i<count; i++) {
            if (element.equals(aux.element)) {
                return true;
            }
            aux = aux.next;
        }
        return false;
    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente.
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */

    //REVER
    public boolean remove(Integer element) {
        if(count == 0) // não ha elementos na lista
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
                    aux.next = null; //opicional para eliminar a referencia
                }
                count--;
                return true;
            }
            //avança p/ os prox. elementos
            //prev para de apontar para head
            aux = aux.next;
            prev = prev.next;
        }
        return false;
    }



/*
Acrescentar na classe LinkedListOfInteger um método “int[] subList(int fromIndex, int toIndex)”,
que retorna um arranjo com os elementos da lista original entre fromIndex (inclusivo)
e toIndex (exclusivo).
 */
    public int[] subList(int fromIndex, toIndex){
        if (fromIndex < 0 || toIndex > count){
            //erro
        }

        if (fromIndex > toIndex){
            //erro
        }

        int[] sublist = new int[toIndex - fromIndex];
        Node aux = head;

        for (int i = 0; i < fromIndex; i++) {
            aux = aux.next; // avança p/ prox. nodo
        }
        // Preenche o array com os elementos da sublist
        for (int i = 0; i < toIndex - fromIndex; i++) {
            sublist[i] = aux.data;
            aux = aux.next;
        }
        return sublist;
    }


/*
Acrescentar na classe LinkedListOfInteger um método “int contaOcorrencias(int element)”, que
retorna o total de ocorrências na lista do elemento passado por parâmetro.
 */
public int countOccurrences(Integer element) {
    int repetido = 0;
    Node aux = head;
    for (int i = 0; i < count; i++){
        if (element.equals(aux.element)){
            repetido++;
        }
        aux = aux.next;
    }
    return repetido;
}


/*
Acrescentar na classe LinkedListOfInteger um método “void reverse()”, que inverte o conteúdo da
lista.
 */
public void reverse() {
    //verifica se tem mais de um elemento para ser possível reverter a ordem
    if (count > 1) {



        }
    }
}


    /*
    Apresente um algoritmo para o método “int removeByIndex(int index)” que faz parte da classe
LinkedListOfInteger, sabendo que ele remove o elemento posição "index" da lista, que é recebida
por parâmetro. Primeiro é preciso verificar se “index” é válido, depois é preciso remover o
elemento desta posição e atualizar o atributo “count”. O elemento removido deve ser retornado.
Lembre de verificar se é o caso de remoção do primeiro (neste caso, o atributo “head” deve ser
atualizado), do último (neste caso, o atributo “tail” deve ser atualizado) ou do meio da lista.
• Exemplo:
LinkedListOfInteger l = {10,20,30,40,50,60,70,80}
int elemRemovido = l.removeByIndex(3)
elemRemovido terá o número 40 após a chamada do método
     */

public Integer removeByIndex(int index) {
    // Primeiro verifica se index eh valido
    if (index < 0 || index >= size())
        throw new IndexOutOfBoundsException();

    if (index == 0) { // se remocao do primeiro
        Integer elemRemovido = head.element; // elemRemovido recebe o valor do primeiro elemento da lista
        head = head.next; //atualiza o primeiro elemento depois da remoçãp
        if (count == 1) // se tem apenas um elemento na lista
            tail = null; // não há mais elementos
        count--;
        return elemRemovido;
    }


    Node ant = head; // nodo auxiliar para percorrer a lista que inicia pela cabeça da lista
    // Inicia um loop para percorrer a lista até a posição anterior àquela onde o elemento será removido
    for (int i=0; i<index-1; i++) {
        ant = ant.next; // Move o nó auxiliar para o próximo nó na lista
    }
    // Armazena o elemento a ser removido que está na posição seguinte ao nó "ant"
    Integer elemRemovido = ant.next.element;
    if (index == count-1) { // se remocao do ultimo
        tail = ant; //define novo nodo como o ultimo
        tail.next = null; // não há mais elementos
    }
    else { // se remocao do meio
        ant.next = ant.next.next; //  // Atualiza a referência do nó "ant" para pular o nó a ser removido
    }
    count--;
    return elemRemovido;
}

/*
Apresente um algoritmo para o método “void add (int index, Integer element)” da classe
LinkedListOfInteger, sabendo que ele deve inserir “element” na lista na posição indicada por
“index”. Lembre que o index deve ser válido e os atributos head, tail e count devem ser atualizados
sempre que necessário e nenhum outro método da classe pode ser chamado. Teste a sua
implementaçao
 */
public void add(int index, Integer element) {
    // Primeiro verifica se index eh valido
    if (index < 0 || index > size()) {
        throw new IndexOutOfBoundsException();
    }
    // Cria o nodo
    Node n = new Node(element);

    if (index == 0) { // se insercao no inicio
        if (count == 0) { // insercao em lista vazia (o elemento é head e tail ao mesmo tempo)
            tail = n;
        }
        else { // insercao em lista não vazia
            n.next = head; // referencia indicando q/ o nó é o primeiro elemento
        }
        head = n; // atribuiçao do valor
    }
    else if (index == count) { // se insercao no final
        tail.next = n; // "conexao" com o novo nodo
        tail = n; // atualiza o tail
    }
    else { // se insercao no meio
        Node ant = head; // nodo auxiliar apontando para a cabeça
        for(int i=0; i<index-1; i++) {
            ant = ant.next;
        }
        n.next = ant.next;
        ant.next = n;
    }
    // Atualiza o count
    count++;
}


/*
Apresente um algoritmo para o método “int indexOf(Integer element)” da classe
LinkedListOfInteger, sabendo que ele deve procurar por “element” na lista e retornar o índice da
posição na qual o elemento está armazenado. Caso “element” não seja encontrado, o método
retorna -1. Os atributos head, tail e count não devem ser alterados.
 */
    int indexOf(Integer element){
        Node aux = head;
        for(int i=0; i<count; i++) {
            if (element.equals(aux.element)) {
                return i;
            }
            aux = aux.next;
        }
        return -1;
    }




/*
Apresente um algoritmo para o método “boolean equals (LinkedListOfInteger outra)” a ser
incluído na classe LinkedListOfInteger, sabendo que ele deve retornar verdadeiro se a lista
recebida por parâmetro possuir os mesmos elementos da lista e na mesma ordem. Caso contrário
o método retorna falso
 */

public boolean equals (LinkedListOfInteger outra) {
    if (count != outra.count) { // se as listas possuem tamanhos diferentes
        return false; // retorna false
    }
    Node aux = head; // referencia auxiliar para "caminhar" na lista
    Node auxOutra = outra.head; // referencia auxiliar para "caminhar" na outra lista
    for (int i=0; i<count; i++) {
        if (! aux.element.equals(auxOutra.element))  { // se os elementos forem diferentes
            return false; // retorna false
        }
        aux = aux.next;
        auxOutra = auxOutra.next;
    }
    // Se chegou aqui, todos elementos sao iguais e retorna true
    return true;
}

/*
Apresente um algoritmo para o método “LinkedListOfInteger merge (LinkedListOfInteger l1,
LinkedListOfInteger l2)”, sabendo que este método retorna uma lista que contém os elementos
das duas listas recebidas por parâmetros organizados de forma intercalada. Observe que agora a
classe LinkedListOfInteger está sendo “usada”, isto é, só é possível acessar os métodos públicos.
 */

ListaEncadeamentoSimples merge(ListaEncadeamentoSimples l1, ListaEncadeamentoSimples l2){
    ListaEncadeamentoSimples l3 = new ListaEncadeamentoSimples(); // lista auxiliar que recebe o merge
    int tamMax;

   // Compara os tamanhos das listas para determinar o tamanho máximo
    if (l1.size() > l2.size()) {
        tamMax = l1.size();
    } else {
        tamMax = l2.size();
    }

    // Percorre as listas até o tamanho máximo
    for (int i = 0; i < tamMax; i++){
        if (i < l1.size()){
            l3.add(l1.get(i));
        }
        if (i < l2.size()){
            l3.add(l2.get(i));
        }

    //retorna lista q/ contem os elementos das duas listas
    return l3;
}

