public class Main {
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash();

        tabela.inserirComEncadeamento(5);
        tabela.inserirComEncadeamento(15);

        System.out.println("Usando Encadeamento:");
        tabela.imprimirTabela();

        tabela.removerComEncadeamento(5);
        System.out.println("\nApós remoção:");
        tabela.imprimirTabela();

        tabela.inserirComEnderecamentoAberto(8);
        tabela.inserirComEnderecamentoAberto(18);

        System.out.println("\nUsando Endereçamento Aberto:");
        tabela.imprimirTabela();

        tabela.removerComEnderecamentoAberto(8);
        System.out.println("\nApós remoção:");
        tabela.imprimirTabela();
    }
}
