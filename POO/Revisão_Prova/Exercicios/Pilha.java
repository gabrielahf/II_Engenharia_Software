public class Pilha {

    private Integer stack[]; // array para guardar os elementos
    private int count; //tamanho

    //construtor
    public StackArray() {
        stack = new Integer[10];
        count = 0;
    }


    public void clear() { // O(1)
        data = new Integer[INITIAL_SIZE];
        count = 0;
    }

    public boolean isEmpty() { // O(1)
        return (count == 0);
    }

    public int size() { // O(1)
        return count;
    }

    //PILHA ARRANJO
    // insere o elemento e no topo da pilha
    public void push(Integer element) {
    if (count == stack.length){
        //erro
    }
    stack[count] = element; //adiciona o elemento
    count++; // incrementa o contador



    }

    // Remove e retorna o elemento do topo da pilha
    // (erro se a pilha estiver vazia)
    public Integer pop() {
        if (count == 0){
        //erro
        }
        Integer elemRemovido = stack[count - 1];
        stack[count - 1] = null; // tirar a referencia do elemento removido
        count--;

        return elemRemovido;
    }

    // Retorna, mas não remove, o elemento do topo da pilha
    // (erro se a pilha estiver vazia)
    public Integer top() {
        if (count == 0){
            //erro
        }

        return stack[count - 1];
    }

//----------------------------------------------------------------------------------------------

    //PILHA SIMPLESMENTE ENCADEADA

    private LinkedListOfInteger lista;

    public Pilha() {
        lista = new LinkedListOfInteger();
    }


    // insere o elemento e no topo da pilha
    public void push(Integer element) {
        lista.add(element);
    }

    // Remove e retorna o elemento do topo da pilha
    // (erro se a pilha estiver vazia)
    public Integer pop() {
        if (isEmpty()){
            //erro
        }
        Integer elemRemovido = lista.removeByIndex(lista.size() - 1);
        return elemRemovido;
    }

    // Retorna, mas não remove, o elemento do topo da pilha
    // (erro se a pilha estiver vazia)
    public Integer top() {
        if (isEmpty()){
            //erro
        }
        return lista.get(lista.size() - 1);

    }

// ---------------------------------------------------------------------------

    //PILHA DUPLAMENTE ENCADEADA

    private DoubleLinkedListOfInteger lista;

    public Pilha() {
        lista = new DoubleLinkedListOfInteger();
    }



    // insere o elemento e no topo da pilha
    public void push(Integer element) {
        lista.add(element);
    }

    // Remove e retorna o elemento do topo da pilha
    // (erro se a pilha estiver vazia)
    public Integer pop() {
        if(isEmpty()){
            //erro
        }
        int elementoDesempilhado = lista.removeByIndex(lista.size() - 1); // Remove o último elemento da lista [count - 1]
        return elementoDesempilhado;

    }

    // Retorna, mas não remove, o elemento do topo da pilha
    // (erro se a pilha estiver vazia)
    public Integer top() {
        if (isEmpty()) {
            //erro
        }
        return lista.get(lista.size() - 1); // Obtém o último elemento da lista [count - 1]

    }


    /*
    Apresente o algoritmo de um método public static void inverte(Integer vet[]) para a classe App. Este
    método recebe um arranjo de inteiros por parâmetro e utiliza uma instância da pilha implementada
    para inverter o seu conteúdo. Chame este método no método main da classe App para testar o seu
    funcionamento.
     */

    public static void inverte(Integer vet[]){
        //Criar uma instância da pilha.
        Pilha p = new Pilha();

        //Empilhar todos os elementos do array na pilha.
        for (Integer elemento : vet) {
            p.push(elemento);
        }
        // Desempilhar os elementos da pilha e armazená-los de volta no array, na ordem inversa.
       for (int i = 0; i < vet.length; i++){
           vet[i] = p.pop();
       }

    }


    /*
    Apresente o algoritmo de um método public static Pilha getClone(Pilha p) para a classe App. Este
    método recebe uma pilha por parâmetro e deve retornar uma cópia desta pilha sendo que no final a
    pilha passada por parâmetro deve estar com o seu conteúdo original, isto é, ela deve ter exatamente
    o mesmo conteúdo de quando o método foi chamado (com os mesmos elementos, na mesma
    ordem). Chame este método no método main da classe App para testar o seu funcionamento.
     */

    public static Pilha getClone(Pilha p){
        //cria duas pilhas auxiliares
        Pilha pAux = new Pilha();
        Pilha pClone = new Pilha();

        // Tira os elemento da pilha "p" e coloca na pilha "pAux"
        while(!p.isEmpty()) {
            pAux.push(p.pop());
        }
        while(!pAux.isEmpty()) {
            Integer elem = pAux.pop();
            pClone.push(elem);
            p.push(elem);
        }

        return pClone;
    }



    /*
     Apresente o algoritmo de um método public static void addAll(Pilha p, DoubleLinkedListOfInteger l)
    para a classe App. Este método recebe uma pilha e uma lista de inteiros por parâmetro (no caso, uma
    das listas implementadas em aula). Este método deve copiar o conteúdo da pilha no final da lista,
    mas no final a pilha deve estar com o seu conteúdo original, isto é, ela deve ter exatamente o mesmo
    conteúdo de quando o método foi chamado (com os mesmos elementos, na mesma ordem). Chame
    este método no método main da classe App para testar o seu funcionamento.
     */

    public static void addAll(Pilha p, DoubleLinkedListOfInteger l){
        Pilha pAux = new Pilha();

        while(!p.isEmpty()){
            Integer element = p.pop();
            pAux.push(element);
            l.add(element);
        }

        //devolve os elementos para pilha
        while (!pAux.isEmpty()){
            p.push(pAux.pop());
        }

        return l;


    }


    /*
    Apresentar o algoritmo de um método que recebe duas pilhas por parâmetro e retorna
    uma lista concatenando o conteúdo das duas pilhas, mas no final as pilhas devem estar
    com o seu conteúdo original, isto é, elas não devem estar alteradas.
     */

    public DoubleLinkedListOfInteger concatena(StackArray p1, StackArray p2) {
        DoubleLinkedListOfInteger lista = new DoubleLinkedListOfInteger();
        StackArray paux = new StackArray();

        // Copia o conteudo da p1 para paux e para a lista
        while(!p1.isEmpty()) {
            Integer element = p1.pop(); // remove o elemento do topo da pilha p1
            paux.push(element); // adiciona esse elemento na pilha auxiliar
            lista.add(element); // adiciona o elemento de p1 na lista
        }
        // "Devolve" os elementos para a p1
        while (!paux.isEmpty()) {
            p1.push(paux.pop());
        }

        // Copia o conteudo da p2 para paux e para a lista
        while(!p2.isEmpty()) {
            Integer element = p2.pop(); // remove o elemento do topo da pilha p2
            paux.push(element); // adiciona o elemento na pilha auxiliar
            lista.add(element); // adiciona o elemento de p2 na lista
        }
        // "Devolve" os elementos para a p2
        while (!paux.isEmpty()) {
            p2.push(paux.pop());
        }

        return lista;
    }
}
