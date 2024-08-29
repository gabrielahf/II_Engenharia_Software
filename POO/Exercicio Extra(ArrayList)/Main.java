public class Main {
    public static void main(String[] args) {
        Agenda ag = new Agenda();
        ag.criaPessoa("Pedro",1998);
        ag.criaPessoa("Maria",2000);
        ag.criaPessoa("Joao",1999);
        Pessoa p = ag.pesquisaPessoa(2000);
        System.out.print("Dados de pessoa - nome: " + p.getNome());
        //quantos objetos (das classes implementadas) estariam em memória? 3 objetos Pessoa e 1 objeto Agenda
        System.out.println(", Ano de nascimento: "+ p.getAnoNascimento());
        //o que aparecia no console(tela)? Dados de  pessoa - nome: Maria, Ano de nascimento: 2000
        p = ag.pesquisaPessoa(2001);
        System.out.print("Dados de pessoa - nome: "+ p.getNome());
        System.out.println(", Ano de nascimento: "+ p.getAnoNascimento());

        //Haveria algum erro de execução (exceção) ou o sistema terminaria normalmente? Sim, haveria exceçao na linha 12 pois não ha pessoas nascidas em 2001
    }
}
