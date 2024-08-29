/**
 * Classe que implementa uma lista linear usando arranjo.
 * @author Isabel H. Manssour
 */

public class ListaLinearArranjo {

    // Atributos
    private static final int INITIAL_SIZE = 10;
    private Integer[] data;
    private int count;

    /**
     * Construtor da lista.
     */
    public ListaLinearArranjo() {
        this(INITIAL_SIZE);
    }

    /**
     * Construtor da lista.
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public ListaLinearArranjo(int tam) {
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
       //verifica se a lista esta cheia
        if (count == data.length)
            //aumentar a capacidade da lista
            setCapacity(data.length * 2);
        //adicionar o elemento
        data[count] = element;
        //atualizar o count
        count++;

    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer get(int index) { // O(1)
       //verifica o index é valido
        if (index < 0 || index >= size()){
            //erro
        }
        //retorna o elemento da posição especificada
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
        //percorrer a lista
        for (int i = 0; i < count; i++){
        //verificar se o elemento esta na lista
            if (element.equals(data[i])){
                //empurrar os elementos para esquerda
                for (int j = i; j < count - 1; j++){
                    data[i] = data[j + 1]; //passar para o proximo elemento
                    return true;
                }
                data[count - 1] = null; // apagar a referencia ao numero removido
                count--;

            }
            return false;

            }



    }

    /**
     * Substitui o elemento armazenado em uma determinada posicao da lista pelo
     * elemento passado por parametro, retornando o elemento que foi substituido.
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    //REVER
    public Integer set(int index, Integer element) { // O(1)
        //verifica o index é valido
        if (index < 0 || index >= size()){
            //erro
        }
        //cria uma variavel para armazenar o elemento q será removido
        Integer elemTrocado = data[index];
        // adicionar um elemento na posição indicada
        data[index] = element;
        // retorna o elemento armazenado anteriormente na posiçao da lista
        return elemTrocado;

    }


    /**
     * Procura pelo elemento passado por parametro na lista e retorna true se a 
     * lista contem este elemento.
     * @param element o elemento a ser procurado
     * @return true se a lista contem o elemento passado por parametro
     */
    public boolean contains(Integer element) { // O(n)
        for (int i = 0; i < count; i++){
            if (element.equals(data[i])){
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
        //verifica o index é valido
        if (index < 0 || index >= size()){
            //erro
        }

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
        //verifica o index é valido
        if (index < 0 || index >= size()){
            //erro
        }

        Integer elemRemovido = data[index];

         for (int i = index; i < count - 1; i++){
                data[i] = data[i + 1];
            }

            data[count - 1] = null;
            count--;

        return elemRemovido;
    }


    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento
     */
    public int indexOf(Integer element) {
        for (int i = 0; i < count; i++){
            if (data[i].equals(element)){
                return i;
            }
        }
        return -1;
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
    public Integer[] subList (int fromIndex , int toIndex) {
        if ((fromIndex < 0)  || (toIndex > size())){
            //erro
        }

        if (fromIndex > toIndex){
            //erro
        }

        Integer a[] = new Integer[toIndex - fromIndex];
        int j = 0;
        for (int i = fromIndex; i < toIndex; i++){
            a[j] = data[i];
            j++;
        }
        return a;
    }

    /**
     * Inverte o conteúdo da lista.
     */
    public void reverse() {
        //verifica se tem mais de um elemento para ser possível reverter a ordem
        if (count > 1) {
            int j = count -1; // ultimo elemento
        //divide o arranjo pela metade
            for (int i = 0; i < count / 2; i++) {
                Integer aux = data[i];
                data[i] = data[j];
                data[j] = aux;
                j--;
            }
        }
    }

    /**
     * Conta o numero de ocorrencias do elemento passado por 
     * parametro.
     * @param element
     * @return
     */
    public int countOccurrences(Integer element) {
        int repetido = 0;
        for (int i = 0; i < count; i++){
            if (element.equals(data[i])) {
                repetido++;
            }
        }
        return repetido;
    }

    /*
    Acrescente na classe ListArrayOfInteger um método que faça uma inserção ordenada dos elementos na
lista (do menor para o maior). A assinatura deste método deve ser: public void
addIncreasingOrder(Integer element). Teste a sua implementação para este método no método main
instanciando uma nova lista e acrescentando os elementos usando apenas este método. Analise a
caracterização O do seu tempo de execução. Observação: a lista só ficará ordenada se os elementos
forem inseridos somente através da chamada deste método.
     */
    public void  addIncreasingOrder(Integer element) { //O(n)
        //verificar a capacidade do vetor
        if (count == data.length) {
            setCapacity(data.length * 2);
        }

        int i = count - 1;
        //percorre a lista de trás para frente
        while (i >= 0 && data[i] > element) {
            data[i + 1] = data[i]; // movendo p/ direita, abrir espaço
            i--;
        }
        data[i + 1] = element; // inserçao do novo elemento
        count++;
    }


    /*
    Implemente um método que recebe por parâmetro duas ListArrayOfInteger e retorna uma terceira
ListArrayOfInteger que contém os elementos resultantes da intersecção das duas listas recebidas por
parâmetro. Ou seja, a lista retornada deve conter uma cópia dos elementos que aparecem
simultaneamente nas duas listas recebidas por parâmetro. Analise a caracterização O do seu tempo de
execução. Acrescente a notação O como comentário no código fonte junto da assinatura do método.
     */
public int InterseccaoLista(ListaLinearArranjo l1, ListaLinearArranjo l2){
    ListaLinearArranjo l3 = new ListaLinearArranjo();
    int tamMax = 0;

    //verifica o tamanho maximo do vetor q recebera os elementos
    if (l1.size() > l2.size()){
        tamMax = l1.size();
    } else{
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


}