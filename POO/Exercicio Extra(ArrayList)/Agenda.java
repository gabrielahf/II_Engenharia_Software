public class Agenda {
    private Pessoa cadastro[] = new Pessoa[5];
    private int ind = 0;
    public void criaPessoa(String n, int a) {
        Pessoa p = new Pessoa(n,a);
        cadastro[ind] = p;
        ind++;
    }
    public Pessoa pesquisaPessoa(int a) {
        for(int i=0; i<ind;i++)
            if(cadastro[i].getAnoNascimento() == a)
                return cadastro[i];
        return null;
    }

}
