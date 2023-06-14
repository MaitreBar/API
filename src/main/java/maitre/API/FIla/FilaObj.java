package maitre.API.FIla;

public class FilaObj {
    private int tamanho;
    private String[] fila;

    public FilaObj(int capacidade) {
        fila = new String[capacidade];
        tamanho = 0;
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == fila.length;
    }

    public void insert(String info) {
        if (isFull()) {
            throw new IllegalStateException("Fila cheia!");
        }
        else {
            fila[tamanho++] = info;
        }

    }

    public String peek() {
        return fila[0];
    }

    public String poll() {
        String primeiro = fila[0];

        if (!isEmpty()) {
            for (int i = 0; i < tamanho - 1; i++) {
                fila[i] = fila[i+1];
            }
            fila[tamanho - 1] = null;
            tamanho--;
        }

        return primeiro;
    }

    public void exibe() {
        if (isEmpty()) {
            System.out.println("Fila vazia!");
        }
        else {
            System.out.println("Conteúdo da fila:");
            for (int i = 0; i < tamanho;i++) {
                System.out.println(fila[i]);
            }
        }

    }

    public int getTamanho(){
        return tamanho;
    }
}
