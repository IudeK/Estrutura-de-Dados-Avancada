
import java.util.ArrayList;
import java.util.Objects;
 
//Criação do Nó
class HashCV<C, V> {
    C chave;
    V valor;
      final int hashCode;
 
   
    HashCV<C, V> proximo;
 
    // Construtor
    public HashCV(C chave, V valor, int hashCode)
    {
        this.chave = chave;
        this.valor = valor;
          this.hashCode = hashCode;
    }
}
 

class Mapa<C, V> {
    //listaVetor é usado para os elementos inseridos com seus próprios parâmetros
    private ArrayList<HashCV<C, V> > listaVetor;
 
   
    private int numElementos;
 
    
    private int tamanho;
 
    //Construtor
    public Mapa()
    {
        listaVetor = new ArrayList<>();
        numElementos = 10;
        tamanho = 0;
 

        for (int i = 0; i < numElementos; i++)
            listaVetor.add(null);
    }
 
    public int tamanho() { return tamanho; }
    public boolean Vazio() { return tamanho() == 0; }
     
      private final int hashCode (C chave) {
        return Objects.hashCode(chave);
    }
   
    //Implementa uma função hash para encontrar o índice para uma chave
    private int indice(C chave)
    {
        int hashCode = hashCode(chave);
        int indice = hashCode % numElementos;
   
        indice = indice < 0 ? indice * -1 : indice;
        return indice;
    }
 
 //Função que remove uma chave associada a um valor
    public V remover(C chave)
    {
        
        int indice = indice(chave);
        int hashCode = hashCode(chave);
    
        HashCV<C, V> inicio = listaVetor.get(indice);
 
       //Procura pela chave na corrente
        HashCV<C, V> prev = null;
        while (inicio != null) {
           
            if (inicio.chave.equals(chave) && hashCode == inicio.hashCode)
                break;
 
         
            prev = inicio;
            inicio = inicio.proximo;
        }
 
       
        if (inicio == null)
            return null;
 
     
        tamanho--;
 
   
        if (prev != null)
            prev.proximo = inicio.proximo;
        else
            listaVetor.set(indice, inicio.proximo);
 
        return inicio.valor;
    }
 
//Função que retorna o valor/valores associados
    public V getValor(C chave)
    {
     
        int indice = indice(chave);
          int hashCode = hashCode(chave);
       
        HashCV<C, V> inicio = listaVetor.get(indice);
 
     
        while (inicio != null) {
            if (inicio.chave.equals(chave) && inicio.hashCode == hashCode)
                return inicio.valor;
            inicio = inicio.proximo;
        }
 
  
        return null;
    }
 
 //Função que insere um determinado valor para associar a uma determinada chave
    public void add(C chave, V valor)
    {
     
        int indice = indice(chave);
          int hashCode = hashCode(chave);
        HashCV<C, V> inicio = listaVetor.get(indice);
 
       
        while (inicio != null) {
            if (inicio.chave.equals(chave) && inicio.hashCode == hashCode) {
                inicio.valor = valor;
                return;
            }
            inicio = inicio.proximo;
        }
 
    
        tamanho++;
        inicio = listaVetor.get(indice);
        HashCV<C, V> newNode
            = new HashCV<C, V>(chave, valor, hashCode);
        newNode.proximo = inicio;
        listaVetor.set(indice, newNode);
 
        if ((1.0 * tamanho) / numElementos >= 0.7) {
            ArrayList<HashCV<C, V> > temp = listaVetor;
            listaVetor = new ArrayList<>();
            numElementos = 2 * numElementos;
            tamanho = 0;
            for (int i = 0; i < numElementos; i++)
                listaVetor.add(null);
 
            for (HashCV<C, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.chave, headNode.valor);
                    headNode = headNode.proximo;
                }
            }
        }
    }
}
