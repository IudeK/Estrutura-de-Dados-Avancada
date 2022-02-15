public class PaginaB { // Um nó de uma árvore B é chamado PÁGINA e armazena m chaves. 
    public int n; 
    public Pedidos r[];
    public PaginaB p[]; 
    public PaginaB (int mm) {
      this.n = 0; 
      this.r = new Pedidos[mm]; 
      this.p = new PaginaB[mm+1];
    }
    
}