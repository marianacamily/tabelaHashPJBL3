import java.util.LinkedList;

class TabelaHashEncadeamento {
    private int tamanho;
    private LinkedList<Integer>[] tabelaenc;
    private int elementos;
    private double fatorDeCargaLimite = 0.75;

    public TabelaHashEncadeamento() {
        this.tamanho = 11; // Tamanho fixo da tabela hash
        tabelaenc = new LinkedList[tamanho];
        for (int i = 0; i < tamanho; i++) {
            tabelaenc[i] = new LinkedList<>();
        }
        elementos = 0;
    }

    private int hash(int chave) {
        return chave % 11;
    }

    // Inserção com tratamento de colisão por encadeamento interno
    public void inserirComEncadeamento(int valor) {
        int indice = hash(valor);
        tabelaenc[indice].add(valor);
        elementos++;

        // Verifica o fator de carga
        if ((double) elementos / tamanho > fatorDeCargaLimite) {
            redimensionarTabela();
        }
    }

    // Remoção com tratamento de colisão por encadeamento interno
    public void removerComEncadeamento(int valor) {
        int indice = hash(valor);
        if (tabelaenc[indice].remove(Integer.valueOf(valor))) {
            elementos--;
        }
    }

    // Busca com tratamento de colisão por encadeamento interno
    public boolean buscarComEncadeamento(int valor) {
        int indice = hash(valor);
        return tabelaenc[indice].contains(valor);
    }

    // Redimensiona a tabela hash quando o fator de carga é alto
    private void redimensionarTabela() {
        int novoTamanho = tamanho * 2;
        LinkedList<Integer>[] novaTabela = new LinkedList[novoTamanho];

        for (int i = 0; i < novoTamanho; i++) {
            novaTabela[i] = new LinkedList<>();
        }

        for (LinkedList<Integer> lista : tabelaenc) {
            for (int valor : lista) {
                int novoIndice = valor % novoTamanho;
                novaTabela[novoIndice].add(valor);
            }
        }

        tamanho = novoTamanho;
        tabelaenc = novaTabela;
    }

    public void imprimirTabelaEnc() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Índice " + i + ": ");
            for (Integer valor : tabelaenc[i]) {
                System.out.print(valor + " -> ");
            }
            System.out.println("null");
        }
    }
}





