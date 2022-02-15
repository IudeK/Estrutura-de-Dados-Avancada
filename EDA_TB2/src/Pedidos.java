public class Pedidos {
    //criação de pedidos
    private int NumPedido;
    private int Quantidade;
    private String Descricao;
    private String Status;
    
    //getters e setters
    public int getNumPedido() {
        return NumPedido;
    }
    public void setNumPedido(int numPedido) {
        NumPedido = numPedido;
    }
    public int getQuantidade() {
        return Quantidade;
    }
    public void setQuantidade(int quantidade) {
        Quantidade = quantidade;
    }
    public String getDescricao() {
        return Descricao;
    }
    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }

    //construtor de pedidos
    public Pedidos(int numPedido, int quantidade, String descricao, String status) {
        NumPedido = numPedido;
        Quantidade = quantidade;
        Descricao = descricao;
        Status = status;
    }

    public Pedidos(){
        
    }

    public int compara (Pedidos it ) {  //compara os números dos pedido
        if (this.NumPedido < it.NumPedido) {
            return -1;
        }else if (this.NumPedido > it.NumPedido){
            return 1;
        }
        return 0;
        }     

    
    

}

