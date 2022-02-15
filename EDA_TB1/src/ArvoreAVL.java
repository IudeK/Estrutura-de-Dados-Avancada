public class ArvoreAVL{

    public NoArvore raiz; //criação do no raiz
    
    public int altura_AVL(NoArvore raiz){ //Função para verificar altura
        int alt_esq=0, alt_dir=0;
        if (raiz == null)// Se a raiz for nula, a altura é 0
            return 0;
        else{ //se não, a função é chamada recursivamente
            alt_esq = altura_AVL(raiz.esq);
            alt_dir = altura_AVL(raiz.dir);
            if (alt_esq > alt_dir)
                return (1 + alt_esq);
            else
                return (1 + alt_dir);
        }
    }
    
    
    
    public int calcula_FB(NoArvore a){ //função para calcular o fator b (Altura do nó esquerdo - altura do nó direito)
        return (altura_AVL(a.esq) - altura_AVL(a.dir));
    }
    
    public NoArvore rotacao_simples_esquerda(NoArvore a){ //Rotação simples 
      NoArvore aux;
      aux = a.dir;
      a.dir = aux.esq;
      aux.esq = a;
      a = aux;
      return a;
    }
    public NoArvore rotacao_simples_direita(NoArvore a){ //Rotação simples 
      NoArvore aux;
    
      aux = a.esq;
      a.esq = aux.dir;
      aux.dir = a;
      a = aux;
      return a;
    }
    public NoArvore balanceio_esquerda(NoArvore a){
      int fator = calcula_FB(a.esq );
      if (fator > 0){
        return rotacao_simples_direita(a);
      }
      else if (fator < 0)// Rotaçao Dupla Direita 
      { 
        a.esq = rotacao_simples_esquerda(a.esq);
        a = rotacao_simples_direita(a); 
        return a;	
      }
      else
          return a;
    }
    
    public NoArvore balanceio_direita(NoArvore a){
      int fator = calcula_FB(a.dir);
      if ( fator< 0 )
      {
        return rotacao_simples_esquerda(a);
      }
      else if (fator > 0 )// Rotaçao Dupla Esquerda
      { 
        a.dir = rotacao_simples_direita(a.dir);
        a = rotacao_simples_esquerda(a); 
          return a;
      }
      else
          return a;
    }
    public NoArvore balanceamento(NoArvore a){ //Função para o balanceamento utilizando como parâmetro o fator b
        int fator = calcula_FB(a);
        if ( fator > 1)
            return balanceio_esquerda(a);
        else if (fator < -1 )
            return balanceio_direita(a);
        return a;
    }

    public NoArvore inserirAVL(NoArvore raiz, Pedidos pedido){ //Função para inserir na AVL
      if (raiz == null){ // Se a raiz for nula, uma nova instancia de raiz é criada
        raiz = new NoArvore();
        raiz.pedido = pedido;
        raiz.esq = null;
        raiz.dir = null;
        return raiz;
      }
      else if ( raiz.pedido.NumPedido > pedido.NumPedido )  { //A hierarquia da arvore é baseada no número do pedido
          raiz.esq = inserirAVL(raiz.esq,pedido); //chamada recursiva
          raiz = balanceamento(raiz);
      }
      else{
          raiz.dir = inserirAVL(raiz.dir,pedido); //chamada recursiva
          raiz = balanceamento(raiz);
      }
       return raiz; 
      }

    
    void imprime(NoArvore a){ // Função para imprimir a arvore
        if (a == null){
            return; //A condição de parada é o nó ser nulo
        }
        System.out.print(a.pedido.NumPedido); // imprime o nó

        if(a.esq != null){
          System.out.print(a.esq.pedido.NumPedido); //Se o nó esquerdo não for nulo, chama a função recursivamente
        }
        if(a.dir != null){
            System.out.print(a.dir.pedido.NumPedido); //Se o nó direito não for nulo, chama a função recursivamente
        }
        System.out.println();
        imprime(a.esq);
        imprime(a.dir);
    }

    NoArvore busca(NoArvore a, int NumPedido){
      if(a==null){
        return null;
      }
      else if(a.pedido.NumPedido==NumPedido){
        return a;
      }
      else{
      busca(a.esq, NumPedido);
      busca(a.dir, NumPedido);
      }
      return a;
    }


    }