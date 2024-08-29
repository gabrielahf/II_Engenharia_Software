
//arvore generica - contar o numero de nodos (RECURSIVA)

import org.w3c.dom.Node;

public int countNodesGenerica() {
    return countNodesGenerica(root); // Chamada inicial a partir do nó raiz
}


private int countNodesGenerica(Node node) {
    if (node == null)
        return 0; 

    int count = 1; // Conta o próprio nó

    // Percorre todos os filhos do nó atual e conta seus nodos recursivamente
    for (Node child : node.children) {
        count += countNodesGenerica(child);
    }

    return count;
}