import java.util.LinkedList;

class TabelaHash {
    private int tamanho;
    private LinkedList<Integer>[] tabela;
    private int elementos;
    private double fatorDeCargaLimite = 0.75;

    public TabelaHash() {
        this.tamanho = 11; // Tamanho fixo da tabela hash
        tabela = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
        elementos = 0;
    }

    private int hash(int chave) {
        return chave % 11;
    }

    // Inserção com tratamento de colisão por encadeamento interno
    public void inserirComEncadeamento(int valor) {
        int indice = hash(valor);
        tabela[indice].add(valor);
        elementos++;

        // Verifica o fator de carga
        if ((double) elementos / tamanho > fatorDeCargaLimite) {
            redimensionarTabela();
        }
    }

    // Remoção com tratamento de colisão por encadeamento interno
    public void removerComEncadeamento(int valor) {
        int indice = hash(valor);
        if (tabela[indice].remove(Integer.valueOf(valor))) {
            elementos--;
        }
    }

    // Busca com tratamento de colisão por encadeamento interno
    public boolean buscarComEncadeamento(int valor) {
        int indice = hash(valor);
        return tabela[indice].contains(valor);
    }

    // Inserção com tratamento de colisão por endereçamento aberto
    public void inserirComEnderecamentoAberto(int valor) {
        int indice = hash(valor);
        while (tabela[indice] != null) {
            indice = (indice + 1) % tamanho;
        }
        tabela[indice] = new LinkedList<>();
        tabela[indice].add(valor);
        elementos++;

        // Verifica o fator de carga
        if ((double) elementos / tamanho > fatorDeCargaLimite) {
            redimensionarTabela();
        }
    }

    // Remoção com tratamento de colisão por endereçamento aberto
    public void removerComEnderecamentoAberto(int valor) {
        int indice = hash(valor);
        while (tabela[indice] != null) {
            if (tabela[indice].contains(valor)) {
                tabela[indice].remove(Integer.valueOf(valor));
                elementos--;
                break;
            }
            indice = (indice + 1) % tamanho;
        }
    }

    // Busca com tratamento de colisão por endereçamento aberto
    public boolean buscarComEnderecamentoAberto(int valor) {
        int indice = hash(valor);
        while (tabela[indice] != null) {
            if (tabela[indice].contains(valor)) {
                return true;
            }
            indice = (indice + 1) % tamanho;
        }
        return false;
    }

    // Redimensiona a tabela hash quando o fator de carga é alto
    private void redimensionarTabela() {
        int novoTamanho = tamanho * 2;
        LinkedList<Integer>[] novaTabela = new LinkedList[novoTamanho];

        for (int i = 0; i < novoTamanho; i++) {
            novaTabela[i] = new LinkedList<>();
        }

        for (LinkedList<Integer> lista : tabela) {
            for (int valor : lista) {
                int novoIndice = valor % novoTamanho;
                novaTabela[novoIndice].add(valor);
            }
        }

        tamanho = novoTamanho;
        tabela = novaTabela;
    }

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





