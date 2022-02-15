Uma empresa de Arte Gráfica expandiu os seus serviços e aumentou sua cartela de clientes. Buscando melhorar a gestão de seus dados a empresa 
necessita de um módulo para seu sistema de gestão de clientes e dos produtos já desenvolvido para os mesmos.<br>

#Dos Clientes:# Sabe-se, que é necessário armazenar algumas informações: CPF, nome completo
e endereço. O sistema, objetivando validar qualquer inconsistência no cadastro das 
informações. Visto que utiliza o CPF como chave identificadora das informações cadastrais de 
cada cliente.<br>
Dos Pedidos: Cada cliente possui um conjunto de pedidos, cujas as informações armazenadas 
são: número da ordem de serviço (identificação única em todo o sistema), descrição do produto
(banner, logo, crachás, catálogos, por exemplo), quantidade, e status (cancelado, entregue, ou 
em andamento). <br>
#Do módulo:# Observando o dia a dia da empresa, é verificado a necessidade de manter o cadastro 
dos clientes em uma tabela hash, de endereçamento interno e com auto ajuste quando 
necessário, que mapeia os CPFs dos clientes para armazenamento das informações. Já os 
pedidos individuais de cada cliente são armazenados de forma hierárquica em um arranjo do 
tipo árvore. Sendo este arranjo de pedidos vinculado ao registro de cada cliente.
A empresa pode realizar algumas operações, tais como:

• Cadastro de Cliente e Pedido: um cliente não pode ser cadastrado sem pelo menos uma 
ordem de pedido.
• Cadastro de Pedido: vincula uma ordem de serviço de um produto para um cliente já 
cadastrado.
• Atualização de um Pedido: mudança de status ou da quantidade do item de um pedido 
realizado cujo os status está ainda em aberto (em andamento).
• Visualizar todo os Pedidos já realizados por um cliente.
