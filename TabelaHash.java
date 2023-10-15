import java.util.LinkedList;
import java.lang.System;

class TabelaHash {
    private LinkedList<Integer>[] tabela; // Array de listas encadeadas para encadeamento
    private int[] tabelaLinear; // Array para sondagem linear
    private int tamanho;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = new LinkedList[tamanho];
        this.tabelaLinear = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
            tabelaLinear[i] = -1;
        }
    }

    // Funções de Hash
    private int hashLinear(int chave) {
        return chave % tamanho;
    }

    private int hashEncadeamento(int chave) {
        return chave % tamanho;
    }

    // Inserção usando sondagem linear
    public void inserçãoLinear(int chave) {
        int indice = hashLinear(chave);

        while (tabelaLinear[indice] != -1) {
            indice = (indice + 1) % tamanho; // Sondagem linear
        }

        tabelaLinear[indice] = chave;
    }

    // Inserção usando encadeamento
    public void inserçãoEncadeamento(int chave) {
        int indice = hashEncadeamento(chave);
        tabela[indice].add(chave);
    }

    // Busca usando sondagem linear
    public boolean buscaLinear(int chave) {
        long tempoInicial = System.currentTimeMillis();
        long tempoFinal = System.currentTimeMillis();
        long tempoTotal = tempoFinal - tempoInicial;
        System.out.println("Tempo total de busca: " + tempoTotal + " milissegundos");

        int indice = hashLinear(chave);

        while (tabelaLinear[indice] != -1) {
            if (tabelaLinear[indice] == chave) {
                return true;
            }
            indice = (indice + 1) % tamanho; // Sondagem linear
        }
        return false;

        
    }

    // Busca usando encadeamento
    public boolean buscaEncadeamento(int chave) {
        long tempoInicial = System.currentTimeMillis();
        long tempoFinal = System.currentTimeMillis();
        long tempoTotal = tempoFinal - tempoInicial;
        System.out.println("Tempo total de busca: " + tempoTotal + " milissegundos");
        
        int indice = hashEncadeamento(chave);
        LinkedList<Integer> lista = tabela[indice];
        return lista.contains(chave);
    }

    // Remoção usando sondagem linear
    public void remoçãoLinear(int chave) {
        int indice = hashLinear(chave);

        while (tabelaLinear[indice] != -1) {
            if (tabelaLinear[indice] == chave) {
                tabelaLinear[indice] = -1;
                return;
            }
            indice = (indice + 1) % tamanho; // Sondagem linear
        }
    }

    // Remoção usando encadeamento
    public void remoçãoEncadeamento(int chave) {
        int indice = hashEncadeamento(chave);
        LinkedList<Integer> lista = tabela[indice];

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == chave) {
                lista.remove(i);
                return;
            }
        }
    }

    // Função para imprimir a tabela
    public void imprimir() {
        System.out.println("Tabela com Sondagem Linear:");
        for (int i = 0; i < tamanho; i++) {
            System.out.println("Slot " + i + ": " + tabelaLinear[i]);
        }

        System.out.println("\nTabela com Encadeamento:");
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Slot " + i + ": ");
            for (Integer elemento : tabela[i]) {
                System.out.print(elemento + " -> ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        TabelaHash tabela = new TabelaHash(10);

        tabela.inserçãoLinear(5);
        tabela.inserçãoLinear(15);
        tabela.inserçãoLinear(25);
        tabela.inserçãoLinear(35);
        tabela.inserçãoLinear(45);
        tabela.inserçãoLinear(10);

        tabela.inserçãoEncadeamento(7);
        tabela.inserçãoEncadeamento(17);
        tabela.inserçãoEncadeamento(27);
        tabela.inserçãoEncadeamento(37);
        tabela.inserçãoEncadeamento(47);
        tabela.inserçãoEncadeamento(12);

        tabela.imprimir();

        System.out.println("\nBusca por 15 (Sondagem Linear): " + tabela.buscaLinear(15));
        System.out.println("Busca por 20 (Sondagem Linear): " + tabela.buscaLinear(20));

        System.out.println("\nBusca por 15 (Encadeamento): " + tabela.buscaEncadeamento(15));
        System.out.println("Busca por 20 (Encadeamento): " + tabela.buscaEncadeamento(20));

        tabela.remoçãoLinear(35);
        tabela.remoçãoEncadeamento(27);

        System.out.println("\nApós a remoção (Sondagem Linear):");
        tabela.imprimir();
    }
}
