class TabelaHashEnderecamento {
    private int tamanho;
    private Pessoa[] tabelaend;
    private int elementos;
    private double fatorDeCargaLimite = 0.75;

    public TabelaHashEnderecamento() {
        this.tamanho = 11; // Tamanho fixo da tabela hash
        tabelaend = new Pessoa[tamanho];
        elementos = 0;
    }

    private int hash(int chave) {
        return chave % 11;
    }

    public void inserirComEnderecamentoAberto(int chave, String valor) {
        if ((double) elementos / tamanho >= fatorDeCargaLimite) {
            redimensionarTabela();
        }

        int indice = hash(chave);

        while (tabelaend[indice] != null) {
            indice = (indice + 1) % tamanho;
        }

        tabelaend[indice] = new Pessoa(chave, valor);
        elementos++;
    }

    public void removerComEnderecamentoAberto(int chave) {
        int indice = hash(chave);
    
        while (tabelaend[indice] != null) {
            if (tabelaend[indice].getId() == chave) {
                tabelaend[indice] = null;
                elementos--;
                reorganizarTabela();
                System.out.println("Pessoa com o ID " + chave + " foi removida.");
                return;
            }
            indice = (indice + 1) % tamanho;
        }
    
        // Se chegou aqui, o valor não está na tabela
        System.out.println("Pessoa com o ID " + chave + " não está na tabela.");
    }

    public boolean buscarComEnderecamentoAberto(int chave) {
        int indice = hash(chave);

        while (tabelaend[indice] != null) {
            if (tabelaend[indice].getId() == chave) {
                System.out.print("ID: " + tabelaend[indice].getId() + ", Ocupação: " + tabelaend[indice].getOcupacao());
                return true;
            }
            indice = (indice + 1) % tamanho;
        }
        return false; // Chave não encontrada
    }

    private void redimensionarTabela() {
        int novoTamanho = tamanho * 2;
        Pessoa[] novaTabela = new Pessoa[novoTamanho];

        for (int i = 0; i < tamanho; i++) {
            Pessoa pair = tabelaend[i];
            if (pair != null) {
                int chave = pair.getId();
                String valor = pair.getOcupacao();
                int novoIndice = hash(chave);

                while (novaTabela[novoIndice] != null) {
                    novoIndice = (novoIndice + 1) % novoTamanho;
                }

                novaTabela[novoIndice] = new Pessoa(chave, valor);
            }
        }

        tamanho = novoTamanho;
        tabelaend = novaTabela;
    }

    private void reorganizarTabela() {
        int novoTamanho = tamanho;
        Pessoa[] novaTabela = new Pessoa[novoTamanho];

        for (int i = 0; i < tamanho; i++) {
            Pessoa pair = tabelaend[i];
            if (pair != null) {
                int chave = pair.getId();
                String valor = pair.getOcupacao();
                int novoIndice = hash(chave);

                while (novaTabela[novoIndice] != null) {
                    novoIndice = (novoIndice + 1) % novoTamanho;
                }

                novaTabela[novoIndice] = new Pessoa(chave, valor);
            }
        }

        tabelaend = novaTabela;
    }

    public void imprimirTabelaEnd() {
        for (int i = 0; i < tamanho; i++) {
            if (tabelaend[i] != null) {
                System.out.println("Índice " + i + ": " + "(" + tabelaend[i].getId() + ", " + tabelaend[i].getOcupacao() + ")");
            } else {
                System.out.println("Índice " + i + ": null");
            }
        }
    }
}


