
import java.util.ArrayList;
import java.util.Objects;
 

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
    
    private ArrayList<HashCV<C, V> > bucketArray;
 
   
    private int numBuckets;
 
    
    private int tamanho;
 
    
    public Mapa()
    {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        tamanho = 0;
 

        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }
 
    public int tamanho() { return tamanho; }
    public boolean Vazio() { return tamanho() == 0; }
     
      private final int hashCode (C chave) {
        return Objects.hashCode(chave);
    }
   
    
    private int indice(C chave)
    {
        int hashCode = hashCode(chave);
        int index = hashCode % numBuckets;
   
        index = index < 0 ? index * -1 : index;
        return index;
    }
 
 
    public V remover(C chave)
    {
        
        int indice = indice(chave);
        int hashCode = hashCode(chave);
    
        HashCV<C, V> inicio = bucketArray.get(indice);
 
      
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
            bucketArray.set(indice, inicio.proximo);
 
        return inicio.valor;
    }
 
   
    public V getValor(C chave)
    {
     
        int indice = indice(chave);
          int hashCode = hashCode(chave);
       
        HashCV<C, V> inicio = bucketArray.get(indice);
 
     
        while (inicio != null) {
            if (inicio.chave.equals(chave) && inicio.hashCode == hashCode)
                return inicio.valor;
            inicio = inicio.proximo;
        }
 
  
        return null;
    }
 
 
    public void add(C chave, V valor)
    {
     
        int indice = indice(chave);
          int hashCode = hashCode(chave);
        HashCV<C, V> inicio = bucketArray.get(indice);
 
       
        while (inicio != null) {
            if (inicio.chave.equals(chave) && inicio.hashCode == hashCode) {
                inicio.valor = valor;
                return;
            }
            inicio = inicio.proximo;
        }
 
    
        tamanho++;
        inicio = bucketArray.get(indice);
        HashCV<C, V> newNode
            = new HashCV<C, V>(chave, valor, hashCode);
        newNode.proximo = inicio;
        bucketArray.set(indice, newNode);
 
        if ((1.0 * tamanho) / numBuckets >= 0.7) {
            ArrayList<HashCV<C, V> > temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            tamanho = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);
 
            for (HashCV<C, V> headNode : temp) {
                while (headNode != null) {
                    add(headNode.chave, headNode.valor);
                    headNode = headNode.proximo;
                }
            }
        }
    }
}
