public class ArranjoEstatico {

    int data[];
    int count;

    ArranjoEstatico(int size){ //construtor
        data = new data[size];
        count = 0;
    }

    public void add(int elemento){
        if(count == data.length) // verificar se o numero de elementos é igual ao tamanho do arranjo
            aumentaArray(count * 2); // dobrar o tamanho do arranjo
        data[count] = elemento; // adicionar elemento dentro do arranjo
        count++; // incrementar numero de elementos
    }

    public void aumentaArray(int tam){
        int[] aux = new int[tam];
        for (int i = 0; i < count; i++){
            aux[i] = data[i];
            data = aux;
        }
    }

    public int get(int index){ //sempre que pedir "index", verificar se é valido
        if(index < 0 || index >= count)
            //erro
        return data[index];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean size(){
        return count;
    }

    public void clear(){ // similar ao construtor
        data = new int[10];
        count = 0;
    }


}
