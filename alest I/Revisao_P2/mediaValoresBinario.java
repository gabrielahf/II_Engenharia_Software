
// Método público para calcular a média dos valores da árvore binária
public double calcularMedia() {
    // Calcula a soma dos valores e o número de nós
    int[] sumAndCount = calcularSomaEContagem(root);

    try {
        // Calcula a média dos valores
        double media = (double) sumAndCount[0] / sumAndCount[1];
        return media;
        
    } catch (ArithmeticException e) {
        // Em caso de divisão por zero, retorna 0.0 ou outra ação adequada
        System.err.println("Erro ao calcular a média: divisão por zero.");
        return 0.0;
    }
}

// Método privado recursivo para calcular a soma dos valores e o número de nós na árvore
private int[] calcularSomaEContagem(Node n) {
    if (n == null) {
        // Se o nó for nulo, retorna soma 0 e contagem 0
        return new int[] { 0, 0 };
    }

    // Calcula a soma e contagem dos subárvores esquerdo e direito
    int[] left = calcularSomaEContagem(n.left);
    int[] right = calcularSomaEContagem(n.right);

    // Soma dos valores e contagem dos nós deste nó
    int soma = n.element + left[0] + right[0];
    int contagem = 1 + left[1] + right[1]; // 1 para contar o próprio nó

    return new int[] { soma, contagem };
}
