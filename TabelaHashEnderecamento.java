class TabelaHashEnderecamento {
    private int tamanho;
    private Integer[] tabelaend;
    private int elementos;
    private double fatorDeCargaLimite = 0.75;

    public TabelaHashEnderecamento() {
        this.tamanho = 11; // Tamanho fixo da tabela hash
        tabelaend = new Integer[tamanho];
        elementos = 0;
    }

    private int hash(int chave) {
        return chave % 11;
    }

    // Inserção com tratamento de colisão por endereçamento aberto 
    public void inserirComEnderecamentoAberto(int valor) {
        if ((double) elementos / tamanho >= fatorDeCargaLimite) {
            redimensionarTabela();
        }

        int indice = hash(valor);

        while (tabelaend[indice] != null) {
            indice = (indice + 1) % tamanho;
        }

        tabelaend[indice] = valor;
        elementos++;
    }

    // Remoção com tratamento de colisão por endereçamento aberto
    public void removerComEnderecamentoAberto(int valor) {
        int indice = hash(valor);

        while (tabelaend[indice] != null) {
            if (tabelaend[indice].equals(valor)) {
                tabelaend[indice] = null;
                elementos--;
                reorganizarTabela();
                return;
            }
            indice = (indice + 1) % tamanho;
        }
    }

    // Busca com tratamento de colisão por endereçamento aberto
    public boolean buscarComEnderecamentoAberto(int valor) {
        int indice = hash(valor);

        while (tabelaend[indice] != null) {
            if (tabelaend[indice].equals(valor)) {
                return true;
            }
            indice = (indice + 1) % tamanho;
        }
        return false;
    }

    // Redimensiona a tabela hash quando o fator de carga é alto
    private void redimensionarTabela() {
        int novoTamanho = tamanho * 2;
        Integer[] novaTabela = new Integer[novoTamanho];

        for (int i = 0; i < tamanho; i++) {
            if (tabelaend[i] != null) {
                int valor = tabelaend[i];
                int novoIndice = hash(valor);

                while (novaTabela[novoIndice] != null) {
                    novoIndice = (novoIndice + 1) % novoTamanho;
                }

                novaTabela[novoIndice] = valor;
            }
        }

        tamanho = novoTamanho;
        tabelaend = novaTabela;
    }

    // Reorganiza a tabela após a remoção de um elemento
    private void reorganizarTabela() {
        int novoTamanho = tamanho;
        Integer[] novaTabela = new Integer[novoTamanho];

        for (int i = 0; i < tamanho; i++) {
            if (tabelaend[i] != null) {
                int valor = tabelaend[i];
                int novoIndice = hash(valor);

                while (novaTabela[novoIndice] != null) {
                    novoIndice = (novoIndice + 1) % novoTamanho;
                }

                novaTabela[novoIndice] = valor;
            }
        }

        tabelaend = novaTabela;
    }

        // Função para imprimir a tabela hash
        public void imprimirTabelaEnd() {
        for (int i = 0; i < tamanho; i++) {
            if (tabelaend[i] != null) {
                System.out.println("Índice " + i + ": " + tabelaend[i]);
            } else {
                System.out.println("Índice " + i + ": null");
            }
        }
    }
}


