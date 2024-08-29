

//RECURSIVA
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
