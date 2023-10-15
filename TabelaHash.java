import java.util.LinkedList;

class TabelaHash {
    private int tamanho;
    private LinkedList<Integer>[] tabela;

    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        tabela = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    // Função de hash usando módulo 11
    private int hash(int chave) {
        return chave % 11;
    }

    // Inserção usando encadeamento (chaining)
    public void inserirComEncadeamento(int valor) {
        int indice = hash(valor);
        tabela[indice].add(valor);
    }

    // Remoção usando encadeamento (chaining)
    public void removerComEncadeamento(int valor) {
        int indice = hash(valor);
        tabela[indice].remove(Integer.valueOf(valor)); // Remove a primeira ocorrência de 'valor'
    }

    // Busca usando encadeamento (chaining)
    public boolean buscarComEncadeamento(int valor) {
        int indice = hash(valor);
        return tabela[indice].contains(valor);
    }

    // Inserção usando sondagem linear
    public void inserirComSondagemLinear(int valor) {
        int indice = hash(valor);
        int i = 1;
        while (tabela[indice].size() > 0) {
            indice = (indice + i) % tamanho;
            i++;
        }
        tabela[indice].add(valor);
    }

    // Remoção usando sondagem linear
    public void removerComSondagemLinear(int valor) {
        int indice = hash(valor);
        int i = 1;
        while (tabela[indice].size() > 0) {
            if (tabela[indice].contains(valor)) {
                tabela[indice].remove(Integer.valueOf(valor)); // Remove a primeira ocorrência de 'valor'
                return;
            }
            indice = (indice + i) % tamanho;
            i++;
        }
    }

    // Busca usando sondagem linear
    public boolean buscarComSondagemLinear(int valor) {
        int indice = hash(valor);
        int i = 1;
        while (tabela[indice].size() > 0) {
            if (tabela[indice].contains(valor)) {
                return true;
            }
            indice = (indice + i) % tamanho;
            i++;
        }
        return false;
    }

    // Função para imprimir a tabela hash
    public void imprimirTabela() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Índice " + i + ": ");
            for (Integer valor : tabela[i]) {
                System.out.print(valor + " -> ");
            }
            System.out.println("null");
        }
    }
}

