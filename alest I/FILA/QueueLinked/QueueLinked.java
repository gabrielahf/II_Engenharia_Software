package QueueLinked;

public class QueueLinked {

    public class Node{
        public Integer element;
        public Node next;

        public Node(Integer e) {
            element = e;
        }
    }

    private int count;
    private Node head;
    private Node tail;

    public void enqueue(Integer element) {
        Node n = new Node(element);
        if (isEmpty()) {
            head = n;
        } else {
           tail.next = n; //revisar
        }
        count++;
    }

    public Integer dequeue(){
        if (isEmpty()){
            System.out.println("Nao tem elemento para ser removido!");
            throw  new RuntimeException("A fila esta vazia!");
        } else{
            Integer elemRemovido = head.element;
            head = head.next;
            if (count == 1){
                tail = null;
            }
            count--;
            return elemRemovido;

        }
    }

    public Integer head(){
        if (isEmpty()){
            System.out.println("Nao tem elemento para ser removido!");
            throw  new RuntimeException("A fila esta vazia!");
        } else{
            return head.element; // retorna o primeiro elemento da fila
        }
    }

    public int size(){return count;}

    public boolean isEmpty(){return count == 0;}


    public void clear(){
        count = 0;
        head = null;
        tail = null;
    }

    public QueueLinked clone(){
        QueueLinked filaClone = new QueueLinked();

        for (int i = 0; i < this.size(); i++){ //'this' se refere ao próprio obj. pois vai utiizar os metodos da fila (enqueue,dequeue, size..)
            Integer element = this.dequeue();
            filaClone.enqueue(element);
            this.enqueue(element);
        }
        return filaClone;
    }
}
