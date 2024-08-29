import java.util.LinkedList;

public class BinarySearchTreeOfInteger {

    private static final class Node {

        public Node father;
        public Node left;
        public Node right;
        public Integer element;

        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    // Atributos        
    private int count; //contagem do número de nodos
    private Node root; //referência para o nodo raiz

    public BinarySearchTreeOfInteger() {
        count = 0;
        root = null;
    }

    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    public void add(Integer element) {
        // Primeiro cria o nodo
        Node n = new Node(element);
        // Atualiza o count
        count++;

        if (root == null) { // Se a arvore estiver vazia
            root = n;
        } else {
            Node aux = root;
            boolean inseriu = false;
            while (!inseriu) { //enquanto nao inserir percorrer a arvore
                if (aux.element.compareTo(element) > 0) {// se obj1 > obj2
                    if (aux.left == null) { // Se nao tem ninguem no lado esq, faz a insercao
                        n.father = aux;
                        aux.left = n;
                        inseriu = true;
                    }
                    aux = aux.left; //percorre os nodos do lado esquerdo
                } else { // Senao, vai para a direita
                    if (aux.right == null) { // Se nao tem ninguem no lado dir, faz a insercao
                        n.father = aux;
                        aux.right = n;
                        inseriu = true;
                    }
                    aux = aux.right; //percorre os nodos do lado direito
                }
            }
        }
    }

    // Como funciona o compareTo:
    // obj1.compareTo(obj2) 
    // se obj1 == obj2, retorna 0
    // se obj1 > obj2, retorna um numero maior que zero
    // se obj1 < obj2, retorna um numero menor que zero
    // No codigo acima, obj1 é aux.element, obj2 é element

    public Integer getLeft(Integer element) {
        return null;
    }

    public Integer getRight(Integer element) {
        return null;
    }

    public Integer getParent(Integer element) {
        return null;
    }

    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPreAux(root, res);
        return res;
    }

    private void positionsPreAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            res.add(n.element); //Visita o nodo
            positionsPreAux(n.left, res); //Visita a subárvore da esquerda
            positionsPreAux(n.right, res); //Visita a subárvore da direita
        }
    }

    public LinkedListOfInteger positionsPos() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPosAux(root, res);
        return res;
    }

    private void positionsPosAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsPosAux(n.left, res); //Visita a subárvore da esquerda
            positionsPosAux(n.right, res); //Visita a subárvore da direita
            res.add(n.element); //Visita o nodo
        }
    }

    public LinkedListOfInteger positionsCentral() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsCentralAux(root, res);
        return res;
    }

    private void positionsCentralAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsCentralAux(n.left, res); //Visita a subárvore da esquerda
            res.add(n.element); //Visita o nodo
            positionsCentralAux(n.right, res); //Visita a subárvore da direita
        }
    }

    public LinkedListOfInteger positionsWidth() {
        Queue<Node> fila = new Queue<>();
        Node atual = null;
        LinkedListOfInteger res = new LinkedListOfInteger();
        if (root != null) {
            fila.enqueue(root);
            while (!fila.isEmpty()) {
                atual = fila.dequeue();
                if (atual.left != null) {
                    fila.enqueue(atual.left);
                }
                if (atual.right != null) {
                    fila.enqueue(atual.right);
                }
                res.add(atual.element);
            }
        }
        return res;
    }

    public String strTraversalCentral() {
        return strTraversalCentral(root);
    }

    private String strTraversalCentral(Node n) {
        return null;
    }

    public boolean contains(Integer element) {
        Node aux = searchNodeRefNoRec(element, root); //searchNodeRef(element, root);
        return (aux != null);
    }

    // Como funciona o compareTo:
    // obj1.compareTo(obj2) 
    // se obj1 == obj2, retorna 0
    // se obj1 > obj2, retorna um numero maior que zero
    // se obj1 < obj2, retorna um numero menor que zero   
    private Node searchNodeRef(Integer element, Node target) {
        if (element == null || target == null)
            return null;

        // Visita a raiz
        int c = target.element.compareTo(element);
        // Se achou element, retorna a referencia para o nodo
        if (c == 0)
            return target;
        // Se nao achou, se element for menor, procura na subarvore da esquerda
        if (c > 0)
            return searchNodeRef(element, target.left);
            // Se element for maior, procura na subarvore da direita
        else
            return searchNodeRef(element, target.right);
    }

    private Node searchNodeRefNoRec(Integer element, Node target) {
        Node aux = target;
        while (aux != null) {
            int c = aux.element.compareTo(element);
            if (c == 0) {
                return aux;
            } else if (c > 0) {
                aux = aux.left;
            } else {
                aux = aux.right;
            }
        }
        return aux;
    }

    public boolean remove(Integer element) {
        if (root == null || element == null) {
            return false;
        }

        Node aux = searchNodeRef(element, root);

        if (aux == null) {
            return false;
        }
        remove(aux);
        count--;
        return true;

    }

    private void remove(Node n) {
        Node father = n.father; // guarda referencia p/ pai

        if (n.left == null && n.right == null) { //remocao nodo folha
            if (root == n) { //apenas um elemento na arvore
                return;
            }
            if (father.left == n) {
                father.left = null; //remocao esquerda
            } else
                father.right = null; //remocao direita


        } else if (n.left == null && n.right != null) { //remocao nodo c/ filho a
            if (root == n) {
                root = root.right;
                root.father = null;
                return;
            }
            if (father.left == n) {
                father.left = n.right;
            } else {
                father.right = n.right;
            }
            n.right.father = father;

        } else if (n.left != null && n.right == null) { //remocao nodo c/ filho a
            if (root == n) {
                root = root.left;
                root.father = null;
                return;
            }
            if (father.right == n) {
                father.right = n.left;
            } else {
                father.left = n.left;
            }
            n.left.father = father;

        } else { //remocao nodo com 2 filhos
            Node small = smallest(n.right);
            n.element = small.element;
            remove(small);
        }
    }
    

    private Node smallest(Node n) {
        if (n == null) {
            return null;
        }
        while (n.left != null) {
            n = n.left;
            //return n;
        }
        return n;
    }

    public Integer set(Integer old, Integer element) {
        return null;
    }

    public boolean isExternal(int element) {
        return false;
    }

    public boolean isInternal(int element) {
        return false;
    }

    public BinarySearchTreeOfInteger clone (){
        BinarySearchTreeOfInteger c = new BinarySearchTreeOfInteger(); // instancia a arvore
        clone(root,c); // chama o metodo recursivo
        return c; // retorna a arvore
    }

    private void clone(Node n, BinarySearchTreeOfInteger c) {
        if (n!=null) {
            c.add(n.element); // visita a raiz
            clone(n.left, c); // percorre subarvore da esq
            clone(n.right, c); // percorre subarvore da dir
        }        
    }


    public int countLeaves() {
        return countLeaves(root);
    }

    public int countLeaves(Node n) {
        if (n == null) {
            return 0;
        }

        if (n.left == null && n.right == null) {
            return 1;
        }

        return countLeaves(n.left) + countLeaves(n.right);

    }

       // function to get count of leaf nodes
       private static int countLeavesNoRec(Node root){
            // initializing count variable
            int count = 0;
            while(root != null){
                Queue<Node> fila = new Queue<>();
                fila.enqueue(root);
                while(!fila.isEmpty()){
                    Node aux = fila.dequeue();

                    if(aux.left == null && aux.right == null) { // verifica se é FOLHA
                        count++;
                    } else{
                        if(aux.left != null) {
                            fila.enqueue(aux.left);
                        }

                        if(aux.right != null) {
                            fila.enqueue(aux.right);
                        }
                    }

                }
                
                //return count;
                
            }
       

       
        
    
    



    private void GeraConexoesDOT(Node nodo) {
        if (nodo == null) {
            return;
        }

        GeraConexoesDOT(nodo.left);
        //   "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            System.out.println("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" " + "\n");
        }

        GeraConexoesDOT(nodo.right);
        //   "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            System.out.println("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" " + "\n");
        }
        //"[label = " << nodo->hDir << "]" <<endl;
    }

    private void GeraNodosDOT(Node nodo) {
        if (nodo == null) {
            return;
        }
        GeraNodosDOT(nodo.left);
        //node10[label = "<esq> | 10 | <dir> "];
        System.out.println("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]" + "\n");
        GeraNodosDOT(nodo.right);
    }

    public void GeraConexoesDOT() {
        GeraConexoesDOT(root);
    }

    public void GeraNodosDOT() {
        GeraNodosDOT(root);
    }

    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline 
    public void GeraDOT() {
        System.out.println("digraph g { \nnode [shape = record,height=.1];\n" + "\n");

        GeraNodosDOT();
        System.out.println("");
        GeraConexoesDOT(root);
        System.out.println("}" + "\n");
    }


    
}
