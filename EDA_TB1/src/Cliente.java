public class Cliente {
    //Criação do cliente
    String Cpf;
    String Nome;
    String Endereco;
    Pedidos PrimeiroPedido;
    ArvoreAVL arvore = new ArvoreAVL(); //instânciando uma AVL dentro do cliente
    
    //Getters e setters
    public String getCpf() {
        return Cpf;
    }
    public void setCpf(String cpf) {
        Cpf = cpf;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }
    public String getEndereco() {
        return Endereco;
    }
    public void setEndereco(String endereco) {
        Endereco = endereco;
    }
    //criação do construtor
    public Cliente(String cpf, String nome, String endereco, Pedidos pedido) {
        Cpf = cpf;
        Nome = nome;
        Endereco = endereco;
        PrimeiroPedido = pedido; // primeiro pedido é obrigatório para criação do cliente
        arvore.raiz=arvore.inserirAVL(arvore.raiz,pedido);  //O primeiro pedido já é enviado para a AVL
        
    }

    public void adicionarPedido(Pedidos pedido){
     arvore.raiz = arvore.inserirAVL(arvore.raiz,pedido); //Função para adicionar pedido na AVL
    }
    
    public void atualizarPedido(Pedidos pedido, String status, int quantidade ){ //Atualizar pedido
        if(pedido.Status.equals("Em andamento")){
        arvore.busca(arvore.raiz, pedido.NumPedido).pedido.Quantidade= quantidade;
        arvore.busca(arvore.raiz, pedido.NumPedido).pedido.Status= status;
        }
    }

    public String toString() {							
        return "(" + Cpf + ", " + Nome + ")";		
    }
}
