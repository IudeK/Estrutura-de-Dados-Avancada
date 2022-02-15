public class ListaSimples{     
                              
    NoLista inicio;                             
    int tamanho;                            
   
   public void inserir(Cliente cliente) {     
           NoLista no = new NoLista();                   
           no.cliente = cliente;                    
           no.proximo = inicio;                
           inicio = no;                       
            tamanho++;                          
      }
  
    public Cliente buscar(String Cpf) {     
          NoLista no = inicio;                    
          while (no != null) {                
              if (no.cliente.getCpf() == Cpf) { 
                  return no.cliente;             
           }
              no = no.proximo;               
          }
          return null;
      }

      public String toString() {              
          String out = "";                    
           NoLista no = inicio;                     
          while (no != null) {                
              out += no.cliente + " ";           
              no = no.proximo;                
          }
          return out;                         
      }
  }