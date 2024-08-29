
public class Funcoes {

    // classe de complexidade: linear
    public int fa(int n) {
        int cont = 0;
        for (int i=0; i < n; i++) {
            cont++;
        }
        return cont;
    }

    // classe de complexidade: quadrática
    public int fb(int n) {
        int cont = 0;
        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                cont++;
        }
    }
        return cont;
    }

    // classe de complexidade: quadrática
    public int fc(int n) {
        int cont = 0;
        for (int i=0; i < n; i++) { 
            for (int j=i; j < 2*i; j++) { // n/2
            cont++;
    }
}
        return cont;
    }

    // classe de complexidade: log n
    public int fd(int n) {
        int cont = 0;
        for (int i=1; i < n; i=i+i) {
        cont++;
        }
        return cont;
    }

    // classe de complexidade: n log n
    public int fe(int n) {
        int cont = 0;
        for (int i=1; i < n; i++) {
            for (int j=1; j < n; j=j+j){
             cont++;
            }
        }
        return cont;
    }

    // classe de complexidade: cúbico
    public int ff(int n) {
        int cont = 0;
        for (int i=0; i < n; i++)
            for (int j=0; j < n; j++)
                for (int k=0; k < n; k++)
        cont++;
        return cont;
    }

    // classe de complexidade: quadrático 
    public int fg(int n) {
        int cont = 0;
        for (int i=0; i < n; i++)
            for (int j=i; j < i+2; j++)
                for (int k=0; k < n; k++)
        cont++;
        return cont;
    }
    
    // classe de complexidade: linear
    public int fh(int n) {
        int cont = 0;
        for (int i=0; i < n; i++)
            for (int j=i; j < i+2; j++)
                for (int k=j; k < j+3; k++)
        cont++;
        return cont;
    }


    // FAZER!!
    public int getTotalSequencias(int v) {
        int cont v = 0;
        for(int i = 0; i < v; i++){
            for(int j = i; j < i + i; j++){
                cont++;
            }
        }
        return cont;
    }
}
