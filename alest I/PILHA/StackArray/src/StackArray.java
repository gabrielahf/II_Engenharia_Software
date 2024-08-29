/*
Apresente os algoritmos para um TAD Pilha que armazena números inteiros, considerando que os
elementos da pilha devem ser armazenados em um arranjo. Implemente a classe Pilha na linguagem
de programação Java ou C++ e apresente a notação O para cada um dos seus métodos (inclua a
notação como comentário para cada método implementado). Crie uma classe App e inclua nela o
método main. Dentro deste método main instancie a pilha implementada, inclua 4 elementos nesta
pilha e depois imprima o seu conteúdo
 */


import java.util.EmptyStackException;

public class StackArray {
    private Integer stack[]; // array para guardar os elementos
    private int count; //tamanho

    //construtor
    public StackArray() {
        stack = new Integer[10];
        count = 0;
    }

    public void push(Integer element){
        if (isFull()){
            System.out.println("A pilha esta cheia!");
            System.out.println("Nao e possivel inserir este elemento!");
            throw new StackOverflowError();
        } else{
            stack[count] = element;
            count++;
        }
    }

    public Integer pop(){
        if (isEmpty()){
            System.out.println("A pilha esta vazia!");
            System.out.println("Nao tem elemento para ser removido!");
            throw new EmptyStackException();
        } else{
            Integer elemTopo = stack[count - 1];
            stack[count - 1]= null;
            count--;
            return elemTopo;

        }
    }

    public Integer top(Integer element){
        if (isEmpty()){
            System.out.println("A pilha esta vazia!");
            System.out.println("Nao tem elemento para ser removido!");
            throw new EmptyStackException();
        } else{
            return stack[count - 1];
        }
    }

    public int size(){return count;}

    public boolean isEmpty(){return count == 0;}

    public boolean isFull(){return count == stack.length;}

    public void clear(){
        stack = new Integer[10];
        count = 0;
    }
}

