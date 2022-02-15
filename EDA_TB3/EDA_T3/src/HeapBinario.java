import java.util.ArrayList;
import java.util.List;

public class HeapBinario<E extends Comparable<E>> {
    Comparable  c =null;
  
    private ArrayList<E> heapArray = new ArrayList<>();

    private boolean max = true;

    public HeapBinario(Boolean maxFlag) { //Construtor
        this.max = maxFlag;
    }

    public void add(E item) {
        heapArray.add(item);
        swim(heapArray.size() - 1);
    }

    public void addAll(List<E> list) {
        for (E item : list) {
            add(item);
        }
    }

    public E takeRoot() {
        if (heapArray.size() == 0) {
            return null;
        }
        E raiz = heapArray.get(0);
        E ultimo = heapArray.remove(heapArray.size() - 1);

        if (heapArray.size() == 0) {
            return raiz;
        }

        heapArray.set(0, ultimo);
        afunda(0);
        return raiz;
    }

    private void troca(int i, int j) {
        E remember = heapArray.get(i);
        heapArray.set(i, heapArray.get(j));
        heapArray.set(j, remember);

    }

    private void swim(int i) {
        E filho = heapArray.get(i);
        int parentIndex = (i - 1) / 2;
        E parent = heapArray.get(parentIndex);
        if (devetroca(filho, parent)) {
            troca(i, parentIndex);
            if (parentIndex > 0) {
                swim(parentIndex);
            }
        }

    }

    private boolean devetroca(E filho, E parent) {
        return max && filho.compareTo(parent) >= 1 || !max && filho.compareTo(parent) <= -1;
    }

    private void afunda(int i) {
        E parent = heapArray.get(i);
        int indiceEsquerdo = 2*i + 1;
        int indiceDireito = 2*i + 2;
        int indiceFilhoSelecionado = -1;
        E filhoSelecionado = null;
        if (indiceEsquerdo > heapArray.size() - 1 && indiceDireito > heapArray.size() - 1) {
            return;
        }
        if (indiceDireito > heapArray.size() - 1) {
            indiceFilhoSelecionado = indiceEsquerdo;
            filhoSelecionado = heapArray.get(indiceEsquerdo);
        } else {

            E esquerda = heapArray.get(indiceEsquerdo);
            E direita = heapArray.get(indiceDireito);

            if (devetroca(esquerda, direita)) {
                indiceFilhoSelecionado = indiceEsquerdo;
                filhoSelecionado = esquerda;
            }
            else {
                indiceFilhoSelecionado = indiceDireito;
                filhoSelecionado = direita;
            }
        }
        if (devetroca(filhoSelecionado, parent)) {
            troca(indiceFilhoSelecionado, i);
            afunda(indiceFilhoSelecionado);

        }

    }
}