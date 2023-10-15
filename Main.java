public class Main {
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash(11);

        tabela.inserirComEncadeamento(200);
        tabela.inserirComEncadeamento(2);
        tabela.inserirComEncadeamento(25);

        System.out.println("Usando Encadeamento:");
        tabela.imprimirTabela();

        tabela.removerComEncadeamento(5);
        System.out.println("\nApós remoção:");
        tabela.imprimirTabela();

        tabela.inserirComSondagemLinear(8);
        tabela.inserirComSondagemLinear(18);
        tabela.inserirComSondagemLinear(28);

        System.out.println("\nUsando Sondagem Linear:");
        tabela.imprimirTabela();

        tabela.removerComSondagemLinear(8);
        System.out.println("\nApós remoção:");
        tabela.imprimirTabela();
    }
}
