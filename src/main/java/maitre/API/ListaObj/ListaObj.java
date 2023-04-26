package maitre.API.ListaObj;

public class ListaObj <Estabelecimento>{
    private Estabelecimento[] vetor;
    private int nroElem;

    public ListaObj(int tamanho) {
        vetor = (Estabelecimento[]) new Object[tamanho];
        nroElem = 0;
    }

    public void adiciona(Estabelecimento elemento){
        if(nroElem >= vetor.length){
            System.out.println("Lista esta cheia");
        }else{
            vetor[nroElem++] =elemento;
        }
    }

    public void exibe(){
        if (nroElem == 0) {
            System.out.println("\nA lista esta vazia");
        }else{
            System.out.println("\nElementos da lista");
            for (int i = 0; i<nroElem; i++){
                System.out.println(vetor[i]);
            }
        }
    }

    public int busca(Estabelecimento elementoBuscado) {
        for (int i = 0; i < nroElem; i++) {
            if (vetor[i].equals(elementoBuscado)) {
                return i;
            }
        }
        return -1;
    }

    public int getTamanho() {
        return nroElem;
    }

    public Estabelecimento getElemento(int i) {
        if (i < 0 || i >= nroElem) {
            return null;
        } else {
            return vetor[i];
        }
    }
}
