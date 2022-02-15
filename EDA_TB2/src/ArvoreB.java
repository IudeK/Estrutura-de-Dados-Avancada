
// Site referência https://www.ime.usp.br/~pf/estruturas-de-dados/aulas/B-trees.html
//                 https://docs.ufpr.br/~marcosantonio/disciplinas/algIII/arvoreB.pdf

public class ArvoreB<T> implements InterArvoreB<T>{
    
    private PaginaB raiz;
    private int m, mm;

    public ArvoreB(int m) { 
        this.raiz = null;
        this.m = m;
        this.mm = 2*m;
    }

    /*
    As chaves são inseridos nos nós folhas.
    Se o nó ficar cheio, divida a folha em duas partes e sobe a chave central para o nó pai.
    Se o pai ficar cheio repita o processo, no pior caso até a raiz.
    Se necessário o nó raiz deverá ser divido e a chave central será transformada em nova raiz.
    */
    @Override
    public boolean inserir(T valor) {  
        Pedidos aux = (Pedidos) valor;                                                
        Pedidos regRetorno[] = new Pedidos[1]; 
        boolean cresceu[] = new boolean[1];
        PaginaB apRetorno = this.insere (aux, this.raiz, regRetorno, cresceu);
        if (cresceu[0]) {
          PaginaB apTemp = new PaginaB(this.mm);
          apTemp.r[0] = regRetorno[0];
          apTemp.p[0] = this.raiz;
          apTemp.p[1] = apRetorno;
          this.raiz = apTemp; this.raiz.n++;
        } else {
            this.raiz = apRetorno;
        }
        return true;
    }
       
    @Override
    public T busca(T reg) {
        return this.pesquisa (reg, this.raiz); // chamada public da funcao busca
    }

    
    //Métodos Privados
    @SuppressWarnings("unchecked")
    private T pesquisa (T reg, PaginaB ap) {  //funcao de busca na arvore
        
        Pedidos aux = (Pedidos) reg;
        if (ap == null) return null; // Registro nao econtrado
        else {
          int i = 0;
          while ((i < ap.n-1) && (aux.compara (ap.r[i]) > 0)) i++;
          if (aux.compara (ap.r[i]) == 0) 
            {
                T result =(T) ap.r[i];
                return result;
            }
          else if (aux.compara (ap.r[i]) < 0) return pesquisa (reg, ap.p[i]);
          else return pesquisa (reg, ap.p[i+1]);
        }
    }
    private void imprime (PaginaB p, int nivel) {
        if (p != null) {
            System.out.print ("  Nivel " + nivel + ":");
            for (int i = 0; i < p.n; i++)   // exibe todos no mesmo nível
                System.out.print (" "+p.r[i].getDescricao()+" , ");
            System.out.println ();
            for (int i = 0; i <= p.n; i++) {
                if (p.p[i] != null)
                    if (i < p.n) System.out.println ("  Esq: "+ p.r[i].getDescricao()); //exibe as chaves que estão na esq e dir
                    else System.out.println ("  Dir: "+ p.r[i-1].getDescricao());
                imprime (p.p[i], nivel + 1);      //chama recursivamente a funcao
            }
        }
    }
    
    public void imprime () {
        System.out.println ("ARVORE:"); 
        this.imprime (this.raiz, 0); //função imprime chama a função this.imprime
    }
    
    private void insereNaPagina (PaginaB ap, Pedidos reg, PaginaB apDir) { 
    int k = ap.n - 1;
    while ((k >= 0) && (reg.compara (ap.r[k]) < 0)) {
      ap.r[k+1] = ap.r[k]; ap.p[k+2] = ap.p[k+1]; k--; 
    }
    ap.r[k+1] = reg; ap.p[k+2] = apDir; ap.n++;     
  }
  
  private PaginaB insere (Pedidos reg, PaginaB ap, Pedidos[] regRetorno, 
                         boolean[] cresceu) {
    PaginaB apRetorno = null;
    if (ap == null) { cresceu[0] = true; regRetorno[0] = reg; } 
    else {
      int i = 0;
      while ((i < ap.n-1) && (reg.compara (ap.r[i]) > 0)) i++;      
      if (reg.compara (ap.r[i]) == 0) {
        System.out.println ("Erro: Registro ja existente");
        cresceu[0] = false;
      } 
      else {
        if (reg.compara (ap.r[i]) > 0) i++;
        apRetorno = insere (reg, ap.p[i], regRetorno, cresceu);
        if (cresceu[0])          
          if (ap.n < this.mm) { // Pagina tem espaco
            this.insereNaPagina (ap, regRetorno[0], apRetorno);
            cresceu[0] = false; apRetorno = ap;
          } 
          else { // A Pagina tem que ser dividida
            PaginaB apTemp = new PaginaB (this.mm); apTemp.p[0] = null;
            if (i <= this.m) {
              this.insereNaPagina (apTemp, ap.r[this.mm-1], ap.p[this.mm]);
              ap.n--;
              this.insereNaPagina (ap, regRetorno[0], apRetorno);
            } else this.insereNaPagina (apTemp, regRetorno[0], apRetorno);
            for (int j = this.m+1; j < this.mm; j++) {
              this.insereNaPagina (apTemp, ap.r[j], ap.p[j+1]);
              ap.p[j+1] = null; // Transfere a posse da memoria
            }
            ap.n = this.m; apTemp.p[0] = ap.p[this.m+1]; 
            regRetorno[0] = ap.r[this.m]; apRetorno = apTemp;
          }
      }        
    }
    return (cresceu[0] ? apRetorno : ap);
  }
}