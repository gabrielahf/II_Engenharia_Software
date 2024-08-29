package QueueArray;

public class QueueArray {

        private Integer queue[]; // array para guardar os elementos
        private int count; //tamanho
        private int primeiro;
        private int ultimo;

        //construtor
        public QueueArray() {
            queue = new Integer[5];
            count = 0;
        }


    public void enqueue(Integer element) {
        if (isFull()) {
            System.out.println("Nao e possivel inserir este elemento!");
            throw new RuntimeException("A fila está cheia!");
        } else {
            queue[count] = element;
            //passar o ultimo para a prox posição
            ultimo = (ultimo + 1) % queue.length;
            count++;
        }
    }

        public Integer dequeue(){
            if (isEmpty()){
                System.out.println("Nao tem elemento para ser removido!");
                throw  new RuntimeException("A fila esta vazia!");
            } else{
                Integer elemRemovido = queue[primeiro];
                queue[primeiro]= null; //revisar 
                primeiro = (primeiro + 1) % queue.length;
                count--;
                return elemRemovido;

            }
        }

        public Integer head(){
            if (isEmpty()){
                System.out.println("Nao tem elemento para ser removido!");
                throw  new RuntimeException("A fila esta vazia!");
            } else{
                return queue[primeiro];
            }
        }

        public int size(){return count;}

        public boolean isEmpty(){return count == 0;}

        public boolean isFull(){return count == queue.length;}

        public void clear(){
            queue = new Integer[5];
            count = 0;
            primeiro = 0;
            ultimo = 0;
        }
    }



