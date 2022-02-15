@SuppressWarnings("unchecked")
public class Cliente {
    //Criação do cliente
   private String Cpf;
   private String Nome;
   private String Endereco;

    //ArvoreAVL arvore = new ArvoreAVL(); //instânciando uma AVL dentro do cliente

    ArvoreB arvore = new ArvoreB<>(2); // Instanciando ArvoreB
    //a raiz contém no mínimo 2 chaves e cada um dos demais nós contém no mínimo M/2 chaves



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
        // primeiro pedido é obrigatório para criação do cliente
        //arvore.raiz=arvore.inserirAVL(arvore.raiz,pedido);  //O primeiro pedido já é enviado para a AVL
        
        arvore.inserir(pedido);//O primeiro pedido já é enviado para a Arvore B
        
    }
    
    public Pedidos BuscarPedido(Pedidos pedido){
        Pedidos busca =(Pedidos) this.arvore.busca(pedido); //funcao para buscar pedido na arvore b
        return busca;
    }

    public void AtualizarStatus(String status,Pedidos pedido){  //funcao para atualizar status do pedido na arvore b
        BuscarPedido(pedido).setStatus(status);
        System.out.println("Pedido atualizado");
    }

    public void AtualizarQtd(int qtd,Pedidos pedido){ //funcao para atualizar status do pedido na arvore b
        BuscarPedido(pedido).setQuantidade(qtd);
        System.out.println("Pedido atualizado");
    }
      
    public void AdicionarPedido(Pedidos pedido){
     //arvore.raiz = arvore.inserirAVL(arvore.raiz,pedido); //Função para adicionar pedido na AVL
     arvore.inserir(pedido); // adiciona pedido na arvore B
    }

    public String toString() {							
        return "(" + Cpf + ", " + Nome + ")";		
    }
}
