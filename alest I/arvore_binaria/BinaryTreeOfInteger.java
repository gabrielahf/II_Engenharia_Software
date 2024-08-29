
/**
 * Classe de arvore binaria de numeros inteiros.
 *
 * @author Isabel H. Manssour
 */
public class BinaryTreeOfInteger {

    private static final class Node {

        public Node father;
        public Node left;
        public Node right;
        private Integer element;

        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    // Atributos da classe BinaryTreeOfInteger
    private int count; //contagem do número de nodos
    private Node root; //referência para o nodo raiz

    // Metodos
    public BinaryTreeOfInteger() {
        count = 0;
        root = null;
    }

    /**
     * Remove todos os elementos da arvore.
     */
    public void clear() {
        count = 0;
        root = null;
    }

    /**
     * Verifica se a arvore esta vazia ou nao.
     *
     * @return true se arvore vazia e false caso contrario.
     */
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * Retorna o total de elementos da arvore.
     *
     * @return total de elementos
     */
    public int size() {
        return count;
    }

    /**
     * Retorna o elemento armazenado na raiz da arvore.
     *
     * @throws EmptyTreeException se arvore vazia.
     * @return elemento da raiz.
     */
    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    /**
     * Retorna quem e o elemento pai do elemento passado por parametro.
     *
     * @param element
     * @return pai de element
     */
    public Integer getParent(Integer element) {
        // Implementar
        return null;
    }

    /**
     * Altera o elemento da raiz da arvore.
     *
     * @param element a ser colocado na raiz da arvore.
     */
    public void setRoot(Integer element) {
        // Implementar
    }

    /**
     * Insere o elemento como raiz da arvore, se a arvore estiver vazia.
     *
     * @param element a ser inserido.
     * @return true se for feita a insercao, e false caso a arvore nao estiver
     * vazia e a insercao não for feita.
     */
    public boolean addRoot(Integer element) {
        if (root != null) // se a arvore nao estiver vazia
        {
            return false;
        }
        root = new Node(element);
        count++;
        return true;
    }

    /**
     * Insere element a esquerda de elemFather. Se nao encontrar father, ou se
     * father ja tiver um filho a esquerda, element nao e´ inserido.
     *
     * @param element a ser inserido
     * @param elemFather pai do elemento a ser inserido
     * @return true se foi feita a inserção, e false caso contrario.
     */
    public boolean addLeft(Integer element, Integer elemFather) {
        // Primeiro procura por elemFather
        Node aux = searchNodeRef(elemFather, root);

        if (aux == null) { // Se nao encontrou elemFather
            return false;  // Retorna false 
        }

        if (aux.left != null) { // Se o pai ja tem filho a esquerda
            return false;       // Retorna false
        }

        // Senao, inserir element na arvore
        Node n = new Node(element); // Primeiro cria o nodo
        n.father = aux; // Faz o nodo criado apontar para o pai
        aux.left = n; // Faz o pai apontar para o nodo criado
        count++;
        return true;
    }

    /**
     * Insere element a direita de elemFather. Se nao encontrar father, ou se
     * father ja tiver um filho a direita, element nao e´ inserido.
     *
     * @param element a ser inserido
     * @param elemFather pai do elemento a ser inserido
     * @return true se foi feita a inserção, e false caso contrario.
     */
    public boolean addRight(Integer element, Integer elemFather) {
        // Primeiro procura por elemFather
        Node aux = searchNodeRef(elemFather, root);

        if (aux == null) { // Se nao encontrou elemFather
            return false;  // Retorna false 
        }

        if (aux.right != null) { // Se o pai ja tem filho a direita
            return false;       // Retorna false
        }

        // Senao, inserir element na arvore
        Node n = new Node(element); // Primeiro cria o nodo
        n.father = aux; // Faz o nodo criado apontar para o pai
        aux.right = n; // Faz o pai apontar para o nodo criado
        count++;
        return true;
    }

    /**
     * Verifica se element esta ou nao armazenado na arvore.
     *
     * @param element
     * @return true se element estiver na arvore, false caso contrario.
     */
    public boolean contains(Integer element) {
        Node nAux = searchNodeRef(element, root);
        return (nAux != null);
    }

    // Metodo privado que procura por element a partir de target
    // e retorna a referencia para o nodo no qual element esta
    // armazenado. Retorna null se nao encontrar element.
    private Node searchNodeRef(Integer element, Node target) {
        if (target == null) {
            return null;
        }

        // Visita a raiz
        if (element.equals(target.element)) { // Se achou element
            return target;                    // Retorna a ref para o nodo
        }

        // Visita subarvore da esquerda
        Node aux = searchNodeRef(element, target.left);

        // Se nao achou, visita subarvore da direita
        if (aux == null) {
            aux = searchNodeRef(element, target.right);
        }

        return aux;
    }

    /**
     * Remove um galho da arvore a partir do elemento recebido por parametro.
     *
     * @param element raiz da subarvore a ser removida.
     * @return true se for feita a remocao.
     */
    public boolean removeBranch(Integer element) {
        // Se a arvore esta vazia
        if (root == null) {
            return false;
        }

        // Se element esta na raiz
        if (root.element.equals(element)) {
            root = null;
            count = 0;
            return true;
        }
        
        // Senao, procura por element
        Node aux = searchNodeRef(element, root);
        
        // Se não achou element
        if (aux == null)
            return false;
        
        // Se achou element, precisa verificar se eh um filho a esq ou a dir
        Node pai = aux.father;
        if (pai.left==aux) { // se eh filho a esq
            pai.left = null;
        }
        else { // senao, se eh filho a dir
            pai.right = null;
        }
        aux.father = null; // opcional
        // Atualiza count
        count = count - countNodes(aux);
        return true;
    }

    // Conta o numero de nodos a partir de "n"
    private int countNodes(Node n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + countNodes(n.left) + countNodes(n.right);
        }
    }
    
    /**
     * Conta e retorna o total de nodos folha da arvore
     */
    public int countLeaves() {
        return countLeaves(root);
    }
    private int countLeaves(Node n) {
        if (n == null)
            return 0;
        if(n.left==null && n.right==null) { // Se for folha
            return 1; // retorna 1
        }
        return countLeaves(n.left) + countLeaves(n.right);
    }

    /**
     * Conta e retorna o total de nodos folha da arvore
     */
    public int countLeavesNaoRecursivo() {
        int c = 0;
        if (root != null) {
            Queue<Node> fila = new Queue<>();
            fila.enqueue(root);
            while (!fila.isEmpty()) {
                Node aux = fila.dequeue();
                if (aux.left == null && aux.right == null) { // se for folha
                    c++; // incrementa o contador
                }
                else {
                    if (aux.left != null)
                        fila.enqueue(aux.left);
                    if (aux.right != null)
                        fila.enqueue(aux.right);
                }
            }
        }
        return c;
    }
    
    /**
     * Troca um elemento da arvore pelo elemento passado por parametro.
     *
     * @param old elemento a ser encontrado para ser substituido.
     * @param element elemento a ser colocado no lugar de old.
     * @return true se fez a troca, false caso contrario.
     */
    public boolean set(Integer old, Integer element) {
        // Implementar
        return false;
    }

    /**
     * Retorna true se element esta armazenado em um nodo externo.
     *
     * @param element
     * @return true se element esta em um nodo externo.
     */
    public boolean isExternal(Integer element) {
        Node aux = searchNodeRef(element, root);
        if (aux == null) // se nao encontrou element
            return false;
        
        if(aux.left==null && aux.right==null) {
            return true;
        }
        return false;
    }

    /**
     * Retorna true se element esta armazenado em um nodo interno.
     *
     * @param element
     * @return true se element esta em um nodo interno.
     */
    public boolean isInternal(Integer element) {
        // Implementar
        return false;
    }

    /**
     * Retorna true se element tem um filho a esquerda.
     *
     * @param element
     * @return true se element tem um filho a esquerda, false caso contrario.
     */
    public boolean hasLeft(Integer element) {
        Node aux = searchNodeRef(element, root);
        if (aux == null)
            return false;
        if(aux.left == null)
            return false;
        else
            return true;
    }

    /**
     * Retorna true se element tem um filho a direita.
     *
     * @param element
     * @return true se element tem um filho a direita, false caso contrario.
     */
    public boolean hasRight(Integer element) {
        // Implementar
        return false;
    }

    /**
     * Retorna o filho a esquerda de element.
     *
     * @param element
     * @return o filho a esquerda, ou null se nao tiver filho a esquerda.
     */
    public Integer getLeft(Integer element) {
        // Implementar
        return null;
    }

    /**
     * Retorna o filho a direita de element.
     *
     * @param element
     * @return o filho a direita, ou null se nao tiver filho a direita.
     */
    public Integer getRight(Integer element) {
        // Implementar
        return null;
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do
     * caminhamento pre-fixado.
     *
     * @return lista com todos os elementos da arvore.
     */
    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        positionsPreAux(root, lista);
        return lista;
    }

    private void positionsPreAux(Node n, LinkedListOfInteger lista) {
        if (n != null) {
            // Visita a raiz
            lista.add(n.element);
            // Visita a subarvore da esquerda
            positionsPreAux(n.left, lista);
            // Visita a subarvores da direita
            positionsPreAux(n.right, lista);
        }
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do
     * caminhamento pos-fixado.
     *
     * @return lista com todos os elementos da arvore.
     */
    public LinkedListOfInteger positionsPos() {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        positionsPosAux(root, lista);
        return lista;
    }

    private void positionsPosAux(Node n, LinkedListOfInteger lista) {
        if (n != null) {
            // Visita a subarvore da esquerda
            positionsPosAux(n.left, lista);
            // Visita a subarvores da direita
            positionsPosAux(n.right, lista);
            // Visita a raiz
            lista.add(n.element);
        }
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do
     * caminhamento central.
     *
     * @return lista com todos os elementos da arvore.
     */
    public LinkedListOfInteger positionsCentral() {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        positionsCentralAux(root, lista);
        return lista;
    }

    private void positionsCentralAux(Node n, LinkedListOfInteger lista) {
        if (n != null) {
            // Visita a subarvore da esquerda
            positionsCentralAux(n.left, lista);
            // Visita a raiz
            lista.add(n.element);
            // Visita a subarvores da direita
            positionsCentralAux(n.right, lista);
        }
    }

    /**
     * Retorna uma lista com todos os elementos da arvore na ordem do
     * caminhamento em largura (por niveis).
     *
     * @return lista com todos os elementos da arvore.
     */
    public LinkedListOfInteger positionsWidth() {
        // Primeiro cria a fila
        Queue<Node> fila = new Queue<>();
        LinkedListOfInteger lista = new LinkedListOfInteger();

        if (root != null) {
            // Primeiro coloca a raiz na fila
            fila.enqueue(root);
            while (!fila.isEmpty()) {
                // Tira da fila
                Node aux = fila.dequeue();
                // Coloca o elemento na lista
                lista.add(aux.element);
                // Coloca os filhos na fila
                if (aux.left != null) {
                    fila.enqueue(aux.left);
                }
                if (aux.right != null) {
                    fila.enqueue(aux.right);
                }
            }
        }

        // Implementar
        return lista;
    }

    /**
     * Retorna uma String com todos os elementos da arvore na ordem do
     * caminhamento central.
     *
     * @return String com todos os elementos da arvore.
     */
    public String strPositionsCentral() {
        return strPositionsCentral(root);
    }

    private String strPositionsCentral(Node n) {
        String s = "";

        return s;
    }

    public int height() {
        // Implementar
        return -1;
    }

    public int level(Integer element) {
        // Primeiro procura por element a partir da raiz
        Node aux = searchNodeRef(element, root);
        
        if (aux == null) // se nao encontrou element
            return -1;
        
        int nivel = 0;
        while(aux!=root) {
            aux = aux.father;
            nivel++;
        }
        return nivel;
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
