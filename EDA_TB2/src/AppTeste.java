@SuppressWarnings("unchecked")
public class AppTeste {
    public static void main(String[] args) throws Exception {
      
       
      Pedidos a = new Pedidos(22, 3, "Banner Estilizado", "Em andamento");
      Pedidos b = new Pedidos(7, 500, "Panfleto Estilizado", "Concluido");
      Pedidos c = new Pedidos(14, 1, "Logo ", "Concluido");
      Pedidos d = new Pedidos(28, 1, "Cartaz ", "Concluido");
      Pedidos e = new Pedidos(40, 1, "Convites ", "Concluido");

      Pedidos f = new Pedidos(1, 1, "Quadro ", "Concluido");
      Pedidos g = new Pedidos(9, 1, "Agendas ", "Concluido");

      Pedidos h = new Pedidos(15, 1, "Cadernos", "Concluido");
      Pedidos i = new Pedidos(23, 1, "Anuario", "Concluido");
      Pedidos j = new Pedidos(32, 1, "Estojos", "Concluido");
      Pedidos k = new Pedidos(33, 1, "Livros ", "Concluido");
      Pedidos l = new Pedidos(34, 1, "Adesivos", "Concluido");
      Pedidos m = new Pedidos(41, 1, "Painel", "Concluido");
      Pedidos n = new Pedidos(42, 1, "Impressao", "Concluido");
      

      Cliente Joao = new Cliente("61002166390","Joao Vitor","Crateus",a);  
     
      Mapa<String, Cliente> map = new Mapa<>();
      
      
      Joao.arvore.inserir(b); 
      Joao.arvore.inserir(c);
      Joao.arvore.inserir(d); 
      Joao.arvore.inserir(e);

      
      //Joao.arvore.imprime(); // primeira impressão, adicionado 22,7,14,28,40
      
      Joao.arvore.inserir(f);
      Joao.arvore.inserir(g);

      //Joao.arvore.imprime(); // segunda impressão, adicionado 1,9 

      Joao.arvore.inserir(h);
      Joao.arvore.inserir(i);
      Joao.arvore.inserir(j);
      Joao.arvore.inserir(k);
      Joao.arvore.inserir(l);
      Joao.arvore.inserir(m);
      Joao.arvore.inserir(n);
      
      //Joao.arvore.imprime(); // terceira impressao, adicionado 15,23,32,33,34,41,42
      
      
      //System.out.println(Joao.BuscarPedido(b).getDescricao()); // chamada da funcao de buscar cliente

      Joao.AtualizarStatus("Concluido", a); // chamada da funcao de atualizar o status do pedido
      System.out.println(Joao.BuscarPedido(a).getStatus());
      Joao.AtualizarQtd(15, a); // chamada da funcao de atualizar a qtd de itens do pedido
      System.out.println(Joao.BuscarPedido(a).getQuantidade());
      //System.out.println(Joao.BuscarPedido(a).getStatus());
      map.add(Joao.getCpf(), Joao); 
      
      Joao.arvore = null;
      
      };

    
}
