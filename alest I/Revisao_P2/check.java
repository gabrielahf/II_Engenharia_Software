//verifica se o vetor esta ordenadoou nao 
public boolean check(int []vet){
    
    // Verificação inicial para um vetor vazio ou de tamanho 1
    if (vet == null || vet.length <= 1) {
        return true;
    }

    // Percorre o vetor e verifica se cada elemento é menor ou igual ao próximo
    for (int i = 0; i < vet.length - 1; i++) {
        if (vet[i] > vet[i + 1]) {
            return false;
        }
    }

    // Se passou por todos os elementos sem encontrar violação da ordenação, está ordenado
    return true;
}
