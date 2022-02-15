public class Pedidos {
    //criação de pedidos
    int NumPedido;
    int Quantidade;
    String Descricao;
    String Status;
    
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

    

}

