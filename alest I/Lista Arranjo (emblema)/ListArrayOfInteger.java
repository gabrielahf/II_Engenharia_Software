/**
 * Classe que implementa uma lista linear usando arranjo.
 * @author Isabel H. Manssour
 */

public class ListArrayOfInteger {

    // Atributos
    private static final int INITIAL_SIZE = 10;
    private Integer[] data;
    private int count;

    /**
     * Construtor da lista.
     */
    public ListArrayOfInteger() {
        this(INITIAL_SIZE);
    }

    /**
     * Construtor da lista.
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public ListArrayOfInteger(int tam) {
        if (tam <= 0) {
            tam = INITIAL_SIZE;
        }
        data = new Integer[tam];
        count = 0;
    }

    /**
     * Esvazia a lista.
     */
    public void clear() { // O(1)
        data = new Integer[INITIAL_SIZE];
        count = 0;
    }

    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() { // O(1)
        return (count == 0);
    }

    /**
     * Retorna o numero de elementos armazenados na lista.
     * @return o numero de elementos da lista
     */
    public int size() { // O(1)
        return count;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) { // O(n)
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) { // O(1)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index); // erro
        }
        return data[index];
    }

    @Override
    public String toString() { // O(n)
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(data[i]);
            if (i != (count - 1)) {
                s.append(",");
            }
        }
        s.append("\n");
        return s.toString();
    }

    private void setCapacity(int newCapacity) { // O(n)
        if (newCapacity != data.length) {
            int min = 0;
            Integer[] newData = new Integer[newCapacity];
            if (data.length < newCapacity) {
                min = data.length;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

    /**
     * Remove a primeira ocorrencia do elemento na lista, se estiver presente
     *
     * @param element o elemento a ser removido
     * @return true se a lista contem o elemento especificado
     */
    public boolean remove(Integer element) { // O(n)
        for(int i=0; i<count; i++) {
            if (element.equals(data[i])) {
                // Achou element no data[], faz a remocao
                for(int j=i; j<count-1; j++) {
                    data[j] = data[j+1];
                }
                data[count-1] = null; // opcional
                count--; // atualiza o count
                return true;
            }
        }
        // Nao achou element, retorna false
        return false;
    }

    /**
     * Substitui o elemento armazenado em uma determinada posicao da lista pelo
     * elemento passado por parametro, retornando o elemento que foi substituido.
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer set(int index, Integer element) { // O(1)
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException(); // Erro
        Integer aux = data[index]; // guarda o elemento
        data[index] = element; // substitui o elemento pelo novo valor
        return aux; // retorno o elemento antigo
    }


    ////////////////////////////////////////////
    // EXERCICIOS: Implemente os metodos
    // conforme a documentacao javadoc e
    // indique a notacao O().
    ////////////////////////////////////////////

    /**
     * Procura pelo elemento passado por parametro na lista e retorna true se a
     * lista contem este elemento.
     * @param element o elemento a ser procurado
     * @return true se a lista contem o elemento passado por parametro
     */
    public boolean contains(Integer element) { // O(n)
        for(int i=0; i<count; i++) {
            if (element.equals(data[i])) {
                return true;
            }
        }
        return false;
    }


    /**
     * Insere um elemento em uma determinada posicao da lista
     *
     * @param index a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) { // O(n)
        // Primeiro verifica se index eh valido
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException();

        // Depois, verifica se tem espaco
        if (count == data.length) {
            setCapacity(data.length * 2);
        }

        if(index == count) { // se insercao no final
            data[count] = element;
        }
        else { // se insercao no inicio ou no meio
            // "Empurra" os elementos para o lado para "abrir espaco"
            for (int i=count; i>index; i--) {
                data[i] = data[i-1];
            }
            // Coloca element na posicao index
            data[index] = element;
        }
        count++; // atualiza count
    }


    /**
     * Remove o elemento de uma determinada posicao da lista
     *
     * @param index a posição da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
        // Primeiro verifica se index eh valido
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException(); //erro
        }
        // Guarda o elemento da posicao index
        Integer aux = data[index];

        // Faz o "for" para "empurrar" os elementos para esquerda
        for (int i = index; i < count - 1; i++) {
            data[i] = data[i + 1];
        }
        data[count - 1] = null; //opcional

        // Atualiza o count
        count--;

        // Retorna o elemento removido
        return aux;
    }


    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     *
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     */
    public int indexOf(Integer element) {
        // Procura elemento no array, se achar retorna o índice
        for (int i = 0; i < count; i++) {
            if (data[i].equals(element)) {
                return i;
            }
        }
        // Neste ponto, não achou: retorna -1
        return -1;
    }

    /**
     * Procura pelo elemento passado por parametro na lista e retorna true se a
     * lista contem este elemento.
     * @param element o elemento a ser procurado
     * @return true se a lista contem o elemento passado por parametro
     */
    private boolean containsRecursivoAux(Integer element, int i) {
        if(i >= count){
            return false;
        }

        if(element.equals(data[i])){
        return true;
        }

       return containsRecursivoAux(element, i + 1);
    }

    
    /**
     * Retorna um arranjo que contem os elementos da lista original entre 
     * fromIndex (inclusivo) e toIndex (exclusivo).
     * @param fromIndex posicao a partir da qual os elementos serao inseridos no
     * arranjo a ser retornado
     * @param toIndex indica a posicao final dos elementos que devem ser inseridos
     * @return Um arranjo com um subconjunto dos elementos da lista.
     * @throws IndexOutOfBoundsException se (fromIndex < 0 || toIndex > size)
     * @throws IllegalArgumentException se (fromIndex > toIndex)
     */   
    public Integer[] subList(int fromIndex , int toIndex) { //JA CAIU NA PROVA
        if(fromIndex < 0 || toIndex >= count)
            throw new IndexOutOfBoundsException();
        if(fromIndex > toIndex)
            throw new IllegalArgumentException();

        //cria array
            Integer a[] = new Integer[toIndex - fromIndex];

        //copiar elementos para o array criado
            int j = 0;
            for(int i = fromIndex; i < toIndex ; i++)
                a[j] = data[i];
                j++;



        return null;
    }

    public void reverse(){
        int j = count - 1;

        for (int i = 0; i < count / 2; i++) {
            int aux = data[i];
            data[i] = data[j - i];
            data[j - i] = aux;

        }

    }






    public void addFirst(Integer element){
        //verifica se o array esta cheio
        if (count == data.length){
            setCapacity(data.length * 2); // aumentar o tamanho do vetor
        }


        //empurra os elementos para direita
        for (int i = count - 1; i >= 0; i--){
            data[i + 1] = data[i];
        }

        //adiciona no inicio
        data[0] = element;
        count++;
    }

    public void removeFirst(Integer element){
        //verifica se o array não esta vazio
        if (count != 0) {

            //empurra para esquerda
            for (int i = 0; i < count - 1; i++) {
                data[i] = data[i + 1];
            }

            data[count - 1] = null;
            count--;
        }
    }



    }


