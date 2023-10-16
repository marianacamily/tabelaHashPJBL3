import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
        System.out.print("===== PJBL3 - Estrutura de Dados - Tabela HASH =====");
        System.out.println();
        System.out.print("Beatriz Petry, Julia Engels e Mariana Camily");
        System.out.println();
        int var = 1;
        TabelaHashEncadeamento tabelaenc = new TabelaHashEncadeamento();
        TabelaHashEnderecamento tabelaend = new TabelaHashEnderecamento();
        while (var != 0){
            Scanner inicio = new Scanner(System.in);
            System.out.println();
            System.out.print("Deseja Realizar [1] Inserção, [2] Busca, [3] Remoção ou [4] Impressão? (Digite qualquer outro n° para sair): ");
            int resposta = inicio.nextInt();
            if (resposta == 1) {
                System.out.print("===== Opção Selecionada: Inserção =====");
                System.out.println();
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o ID da Pessoa que será inserida: ");
                int idInserir = scanner.nextInt();
                Scanner scannermat = new Scanner(System.in);
                System.out.print("Digite a Matrícula da Pessoa com esse ID: ");
                int matriculaInserir = scannermat.nextInt();
                tabelaenc.inserirComEncadeamento(idInserir, matriculaInserir);
                tabelaend.inserirComEnderecamentoAberto(idInserir, matriculaInserir);
                System.out.print("Tabela com Encadeamento Interno: ");
                System.out.println();
                tabelaenc.imprimirTabelaEnc();
                System.out.println();
                System.out.print("Tabela com Endereçamento Aberto: ");
                System.out.println();
                tabelaend.imprimirTabelaEnd();
            }
            else if (resposta == 2){
                System.out.print("===== Opção Selecionada: Busca =====");
                System.out.println();
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o ID que deseja buscar: ");
                int valorBuscar = scanner.nextInt();
                System.out.print("Busca na tabela com Encadeamento Interno: ");
                System.out.println();
                System.out.println("\nBusca pelo ID " + valorBuscar + " = " + tabelaenc.buscarComEncadeamento(valorBuscar));
                System.out.println();
                System.out.print("Busca na tabela com Endereçamento Aberto: ");
                System.out.println();
                System.out.println("\nBusca pelo ID " + valorBuscar + " = " + tabelaend.buscarComEnderecamentoAberto(valorBuscar));
            }
            else if (resposta == 3){
                System.out.print("===== Opção Selecionada: Remoção =====");
                System.out.println();
                Scanner scanner = new Scanner(System.in);
                System.out.print("Digite o ID da Pessoa que deseja remover: ");
                int valorRemover = scanner.nextInt();
                System.out.print("Remoção na tabela com Encadeamento Interno: ");
                tabelaenc.removerComEncadeamento(valorRemover);
                System.out.println();
                System.out.print("Remoção na tabela com Endereçamento Aberto: ");
                tabelaend.removerComEnderecamentoAberto(valorRemover);
                System.out.println();
            }
            else if (resposta == 4){
                System.out.print("===== Opção Selecionada: Impressão =====");
                System.out.println();
                System.out.print("Tabela com Encadeamento: ");
                System.out.println();
                tabelaenc.imprimirTabelaEnc();
                System.out.println();
                System.out.print("Tabela com Endereçamento Aberto: ");
                System.out.println();
                tabelaend.imprimirTabelaEnd();
            }
            else {
                break;
            }
        }
    }
}