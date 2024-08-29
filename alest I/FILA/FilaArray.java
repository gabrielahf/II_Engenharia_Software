
public class FilaArray {
    private Integer fila[]; 
    private int count;
    private int primeiro;
    private int ultimo;
    
    public FilaArray() {
        fila = new Integer[5];
    }
    
   // Insere o elemento no final da fila
    public void enqueue(Integer element) {
        // Primeiro verifica se tem espaco no array
        if (count == fila.length)
            throw new FullQueueException();
        
        fila[ultimo] = element;
        count++;
        ultimo = (ultimo+1) % fila.length;
       // pega o índice "ultimo" e divide pelo total de elementos
       // Por exemplo num vetor de 10 posicoes (indices 0 a 9):
       // - Se ultimo estava na posicao 4: 5/10, resto eh 5
       // - Se ultimo estava na posicao 9: 10/10, resto eh 0        
    }
     
    // remove e retorna o elemento e do início da fila, 
    // e dá erro se a fila estiver vazia
    public Integer dequeue() {
        // Primeiro verifica se a fila esta vazia
        if (count == 0)
            throw new EmptyQueueException("A fila esta vazia!");
        Integer elem = fila[primeiro];
        count--;
        primeiro = (primeiro+1) % fila.length;
        return elem;
    }
  
    // retorna, mas não remove, o primeiro elemento da fila, 
    // e dá erro se a fila estiver vazia
    public Integer head() {
        if (count == 0)
            throw new EmptyQueueException("A fila esta vazia!");
        return fila[primeiro]; 
    }

    // retorna o número de elementos da fila
    public int size() {
        return count;
    } 
    
    // retorna true se a fila estiver vazia, e false caso contrário
    public boolean isEmpty() {
        return (count == 0);
    }
    
    // esvazia a fila
    public void clear(){
        fila = new Integer[5];
        count = 0;
    } 
      
}
