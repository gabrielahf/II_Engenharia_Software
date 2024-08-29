//arvore generica - contar o numero de folhas (RECURSIVA)
public int countLeavesGenerica() {
    return countLeaves(root); // Chamada inicial a partir do nó raiz
}

// Método privado recursivo para contar o número de folhas a partir de um nó
private int countLeaves(Node n) {
    if (n == null)
        return 0; // Se o nó for nulo, não há folhas, retorna 0

    // Se o nó não tiver filhos (ou seja, é uma folha), retorna 1
    if (n.next == null)
        return 1;

    int count = 0;

    // Percorre todos os filhos (nós irmãos) e soma as folhas de cada um
    Node aux = n.next;
    while (aux != null) {
        count += countLeaves(aux);
        aux = aux.next; //passa para o proximo 
    }

    return count;
}