
import java.util.LinkedList;

public class GeneralTreeOfInteger {

    // Classe interna Node
    private class Node {
        // Atributos da classe Node
        public Node father;
        public Integer element;
        public LinkedList<Node> subtrees;
        // Métodos da classe Node
        public Node(Integer element) {
            father = null;
            this.element = element;
            subtrees = new LinkedList<>();
        }
        private void addSubtree(Node n) {
            n.father = this;
            subtrees.add(n);
        }
        private boolean removeSubtree(Node n) {
            n.father = null;
            return subtrees.remove(n);
        }
        public Node getSubtree(int i) {
            if ((i < 0) || (i >= subtrees.size())) {
                throw new IndexOutOfBoundsException();
            }
            return subtrees.get(i);
        }
        public int getSubtreesSize() {
            return subtrees.size();
        }
    }

    
    
    // Atributos da classe GeneralTreeOfInteger
    private Node root;
    private int count;

    
    
    // Metodos da classe GeneralTreeOfInteger
    
    /**
     * Metodo construtor.
     */
    public GeneralTreeOfInteger() {
        root = null;
        count = 0;
    }
    
    /**
     * Retorna o numero total de elementos da arvore.
     * @return count
     */
    public int size() {
        return count;
    }
    
    // Procura por "elem" a partir de "n" seguindo um
    // caminhamento pre-fixado. Retorna a referencia
    // para o nodo no qual "elem" esta armazenado.
    // Se não encontrar "elem", ele retorna NULL.
    private Node searchNodeRef(Integer elem, Node n) {
        if(n == null)
            return null;
        
        // Visita a raiz
        if(n.element.equals(elem)) { // se "elem" esta no nodo "n"
            return n; // entao, retorna a ref para o nodo onde elem esta armazenado
        }
        
        // Visita os filhos
        Node aux = null;
        for (int i=0; i<n.getSubtreesSize(); i++) {
            aux = searchNodeRef(elem, n.getSubtree(i));
            if (aux != null) { // se achou elem
                return aux; // retorna a ref para o nodo onde elem esta armazenado
            }       
        }
        return aux;
    }
    
    
    /**
     * Adiciona elem como filho de father
     * @param elem elemento a ser adicionado na arvore.
     * @param father pai do elemento a ser adicionado.
     * @return true se encontrou father e adicionou elem na arvore, 
     * false caso contrario.
     */
    public boolean add(Integer elem, Integer elemFather) {
        // Primeiro cria o nodo
        Node n = new Node(elem);
        
        // Verifica se eh para inserir como raiz da arvore (eleFather == null)
        if (elemFather == null) {
            if (root != null) { // se a arvore nao esta vazia
                n.addSubtree(root); // adiciona atual raiz como filho
                root.father = n;
            }
            root = n;
            count++;
            return true;
        }
        
        // Procura por elemFather a partir da raiz
        Node aux = searchNodeRef(elemFather, root);
        
        if (aux == null) { // Se nao encontrou elemFather
            return false;  // retorna false, porque nao inseriu
        }
        
        // Se achou elemFather, adiciona o filho
        aux.addSubtree(n);
        n.father = aux;
        count++;
        return true;
    }
    

    /**
     * Verifica se elem esta ou não na arvore.
     * @param elem a ser procurado.
     * @return true se achar elem, e false caso contrario.
     */
    public boolean contains (Integer elem) {
        // IMPLEMENTE ESTE METODO !!
        return false;
    }
    
    /**
     * Retorna uma lista com todos os elementos da árvore numa ordem de 
     * caminhamento em largura.
     * @return lista com os elementos da arvore na ordem do caminhamento em largura
     */
    public LinkedList<Integer> positionsWidth() {
        LinkedList<Integer> lista = new LinkedList<>();
        
        // IMPLEMENTE ESTE METODO !!
        
        return lista;
    }    
    

    /**
     * Retorna uma lista com todos os elementos da árvore numa ordem de 
     * caminhamento pre-fixado.
     * @return lista com os elementos da arvore na ordem do caminhamento pre-fixado
     */    
    public LinkedList<Integer> positionsPre() {  
        LinkedList<Integer> lista = new LinkedList<>();
        
        // IMPLEMENTE ESTE METODO !!
        
        return lista;
    }  
    
    private void positionsPreAux(Node n, LinkedList<Integer> lista) {
        // IMPLEMENTE ESTE METODO !! 
    }


    /**
     * Retorna uma lista com todos os elementos da árvore numa ordem de 
     * caminhamento pos-fixado.
     * @return lista com os elementos da arvore na ordem do caminhamento pos-fixado
     */     
    public LinkedList<Integer> positionsPos() {  
        LinkedList<Integer> lista = new LinkedList<>();
        
        // IMPLEMENTE ESTE METODO !!
        
        return lista;
    }  
    
    private void positionsPosAux(Node n, LinkedList<Integer> lista) {
        // IMPLEMENTE ESTE METODO !!
    }    
    

    /**
     * Retorna em que nivel em que elem esta armazenado. 
     * @param element a ser buscado
     * @return nivel no qual element esta, ou -1 se 
     * nao encontrou element.
     */
    public int level(Integer element) {
        // IMPLEMENTE ESTE METODO !!
        return 0;
       
    }     
    
    
    /**
     * Remove o galho da arvore que tem element na raiz. A 
     * remocao inclui o nodo que contem "element".
     * @param element elemento que sera removido junto com sua 
     * subarvore.
     * @return true se achou element e removeu o galho, false 
     * caso contrario.
     */
    public boolean removeBranch(Integer element) { 
        
        // IMPLEMENTE ESTE METODO !!
        return false;
        
    }

    // Conta o numero de nodos da subarvore suja raiz eh passada por parametro
    private int countNodes(Node n) {
        
        // IMPLEMENTE ESTE METODO !!
        return 0;
        
    }    
    
    
    ///////////////////////////////////////////
    // Codigos abaixo geram saida para GraphViz
    
    public void geraNodosDOT(Node n)
    {
        System.out.println("node [shape = circle];\n");
        
        LinkedList<Integer> L = new LinkedList<>();
        L = positionsWidth();

        for (int i = 0; i< L.size(); i++ )
        {
            // node1 [label = "1"]
            System.out.println("node" + L.get(i) + " [label = \"" +  L.get(i) + "\"]") ;
        }
    }

    public void geraConexoesDOT(Node n)
    {
        for (int i=0; i<n.getSubtreesSize(); i++)
        {
            Node aux = n.getSubtree(i);
            System.out.println("node" + n.element + " -> " + "node" + aux.element + ";");
            geraConexoesDOT(aux);
        }
    }
    
    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline 
    public void geraDOT()
    {
        if (root != null) {
            System.out.println("digraph g { \n");
            // node [style=filled];

            geraNodosDOT(root);

            geraConexoesDOT(root);
            System.out.println("}\n");
        }
    }    
}
