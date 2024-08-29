

import java.util.Queue;

//arvore binaria - conta o numero de folhas da arvore (RECURSIVA)
public int countLeavesBinaria() {
    return countLeaves(root);
}

private int countLeavesBinaria(Node n) {
    if (n == null)
        return 0;
    if (n.left==null && n.right==null) // se eh uma folha
        return 1; // retorna 1
    // senao, conta o total de folhas da esq + total de folhas da dir
    return countLeaves(n.left) + countLeaves(n.right);
}


// NAO RECURSIVA
public int countLeavesNoRec(Node root){
    int count = 0;

    while(root != null){ //enquanto a arvore tiver elementos para contar
        Queue<Node> fila = new Queue<>(); // instancia uma fila para ajudar a percorrer a arvore
        fila.enquaue(root); // adiciona a raiz na fila

        while(!fila.isEmpty()){ // enquanto a fila tiver elementos para contar
            Node aux = fila.dequeue; //tira da fila e atribui a um nodo auxiliar

            if (aux.left == null && aux.right == null) { // caso não tenha filhos, considera como folha e incrementa contador
                count++;
            } else{
                if (aux.left != null) { //filhos da esquerda
                    fila.enqueue(aux.left); // adiciona na fila os filhos da esquerda
                }
                if (aux.right != null) { //filhos da direita
                    fila.enqueue(aux.right); //adiciona na fila os filhos da direita
                }
            }
        }
        return count;
    }


}