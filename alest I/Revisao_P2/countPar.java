
//arvore binaria - conta o numero de elementos pares (RECURSIVA)
public int countLeavesPar() {
    return countLeaves(root);
}

private int countLeavesPar(Node n) {    
    if (n == null){
        return 0;
    }

        if (n.element % 2 == 0) {
           return 1 + countLeavesPar(n.left) + countLeavesPar(n.right);
        } else

     return countLeavesPar(n.left) + countLeavesPar(n.right);
}
