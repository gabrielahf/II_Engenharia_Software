package QueueLinked;

public class AppQueue {
        public static void main(String[] args) {
            QueueLinked fila = new QueueLinked();
            fila.enqueue(10);
            fila.enqueue(20);
            fila.enqueue(30);

            System.out.println("Removeu " + fila.dequeue());
            fila.enqueue(40);

            System.out.println("Removeu " + fila.dequeue());
            fila.enqueue(50);
            fila.enqueue(60);

            System.out.println("Removeu " + fila.head());

            for (int i=0; i < fila.size(); i++){
                Integer n = fila.dequeue();
                System.out.println(n);
                fila.enqueue(n);
            }
            System.out.println("---------------------");

            while(!fila.isEmpty()) {
                System.out.println(fila.dequeue());
            }
        }


    }


