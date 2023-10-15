public class Main {
    public static void main(String[] args) {
        TabelaHashEncadeamento tabelaenc = new TabelaHashEncadeamento();

        tabelaenc.inserirComEncadeamento(2);
        tabelaenc.inserirComEncadeamento(200);

        System.out.println("Usando Encadeamento:");
        tabelaenc.imprimirTabelaEnc();

        tabelaenc.removerComEncadeamento(5);
        System.out.println("\nApós remoção:");
        tabelaenc.imprimirTabelaEnc();


        TabelaHashEnderecamento tabelaend = new TabelaHashEnderecamento();
        System.out.println("Usando Endereçamento Aberto:");

        tabelaend.inserirComEnderecamentoAberto(2);
        tabelaend.inserirComEnderecamentoAberto(200);
        tabelaend.inserirComEnderecamentoAberto(25);
        tabelaend.inserirComEnderecamentoAberto(7);
        tabelaend.imprimirTabelaEnd();

        System.out.println("Buscar 5: " + tabelaend.buscarComEnderecamentoAberto(5)); // Deve imprimir true
        System.out.println("Buscar 15: " + tabelaend.buscarComEnderecamentoAberto(15)); // Deve imprimir true
        System.out.println("Buscar 7: " + tabelaend.buscarComEnderecamentoAberto(7)); // Deve imprimir true

        tabelaend.removerComEnderecamentoAberto(5);
        System.out.println("\nApós remoção:");
        System.out.println("Buscar 5: " + tabelaend.buscarComEnderecamentoAberto(5)); // Deve imprimir false
    }
}
