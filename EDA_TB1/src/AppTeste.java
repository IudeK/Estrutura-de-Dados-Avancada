public class AppTeste {
    public static void main(String[] args) throws Exception {
      
       
      Pedidos Banner = new Pedidos(4, 3, "Banner Estilizado", "Em andamento");
      Pedidos Panfleto = new Pedidos(2, 500, "Panfleto Estilizado", "Concluido");
      Pedidos Arte = new Pedidos(3, 1, "Logo ", "Concluido");

      Cliente Joao = new Cliente("61002166390","Joao Vitor","Crateus",Banner);  
      Cliente Pedro = new Cliente("22456348951", "Pedro Oliveira", "Fortaleza", Arte);

      Joao.adicionarPedido(Panfleto);
     
      Mapa<String, Cliente> map = new Mapa<>();
      
        Joao.arvore.imprime(Joao.arvore.raiz); // todos os valores da avl de Joao

        System.out.println(Joao.arvore.busca(Joao.arvore.raiz, 4).pedido.Status);

        Joao.atualizarPedido(Banner ,"Concluido", 10);
        System.out.println(Joao.arvore.busca(Joao.arvore.raiz, 4).pedido.Quantidade);
        System.out.println(Joao.arvore.busca(Joao.arvore.raiz, 4).pedido.Status);

        map.add(Joao.getCpf(), Joao);//
        map.add(Pedro.getCpf(), Pedro);//

        System.out.println(map.getValor(Joao.getCpf()).Nome);
        
      };

    
}
