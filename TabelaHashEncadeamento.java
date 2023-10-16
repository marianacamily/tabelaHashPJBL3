import java.util.LinkedList;


class TabelaHashEncadeamento {
    private int tamanho;
    private LinkedList<Pessoa>[] tabelaenc;
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

    public void inserirComEncadeamento(int chave, int valor) {
        int indice = hash(chave);
        tabelaenc[indice].add(new Pessoa(chave, valor));
        elementos++;

        // Verifica o fator de carga
        if ((double) elementos / tamanho > fatorDeCargaLimite) {
            redimensionarTabela();
        }
    }

    public void removerComEncadeamento(int chave) {
        int indice = hash(chave);
        LinkedList<Pessoa> lista = tabelaenc[indice];
        for (Pessoa pessoa : lista) {
            if (pessoa.getId() == chave) {
                lista.remove(pessoa);
                elementos--;
                System.out.println("Pessoa com a chave " + chave + " foi removida.");
                return;
            }
        }
        
        // Se chegou aqui, a pessoa não está na tabela
        System.out.println("Pessoa com a chave " + chave + " não está na tabela.");
    }

    public boolean buscarComEncadeamento(int chave) {
        int indice = hash(chave);
        LinkedList<Pessoa> lista = tabelaenc[indice];
        for (Pessoa pair : lista) {
            if (pair.getId() == chave) {
                System.out.print("ID: " + pair.getId() + ", Matrícula: " + pair.getMatricula());
                return true; 
                
            }
        }
        return false; // Chave não encontrada
    }

    private void redimensionarTabela() {
        int novoTamanho = tamanho * 2;
        LinkedList<Pessoa>[] novaTabela = new LinkedList[novoTamanho];

        for (int i = 0; i < novoTamanho; i++) {
            novaTabela[i] = new LinkedList<>();
        }

        for (LinkedList<Pessoa> lista : tabelaenc) {
            for (Pessoa pair : lista) {
                int novoIndice = hash(pair.getId());
                novaTabela[novoIndice].add(pair);
            }
        }

        tamanho = novoTamanho;
        tabelaenc = novaTabela;
    }

    public void imprimirTabelaEnc() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print("Índice " + i + ": ");
            for (Pessoa pair : tabelaenc[i]) {
                System.out.print("(" + pair.getId() + ", " + pair.getMatricula() + ") -> ");
            }
            System.out.println("null");
        }
    }
}





