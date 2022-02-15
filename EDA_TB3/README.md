* Implementado com Heap Binomial e Uniao e Busca

Considere o cenário de uma comunidade de usuários pertencente a um clube de vantagens com 
categorias: Prata, Bronze, Ouro e Diamante. A alocação dos usuários em cada categoria ocorre 
por meio do cumprimento de um número de tarefas prioritárias, por exemplo: atingir um certo 
número de pontos ao utilizar o cartão de crédito em um conjunto de estabelecimento, ou 
realizar compras com periodicidade, ou indicar um amigo para o clube de vantagens, entre 
outras. Ao finalizar, de forma gradual, todas as tarefas da categoria almejada, cada usuário, 
individualmente, será automaticamente migrado para categoria seguinte.<br><br>
Pontos de observação:<br>
• Todos os usuários iniciam sem categoria, ao conquistar, individualmente, as tarefas
prioritárias estes serão inseridos no grupo de clientes Prata.<br>
• Não é permitido que os usuários “pulem” categorias. Desta forma, deve ser respeitada 
a sequência: Nenhuma Categoria -> Prata -> Bronze -> Ouro -> Diamante.<br>
• Os usuários conquistando sua inclusão na categoria Diamante, estarão na categoria 
máxima do clube de vantagens e não possuirão mais nenhuma tarefa a ser conquistada.<br>
• O número de tarefas de cada categoria não deverá ser menor que 3, e uma vez definida 
suas prioridades estas não poderão ser alteradas, sendo válidas para todos os usuários 
do sistema.<br>
• A definição das prioridades ficará à livre critério.<br>
• As categorias do clube de vantagens deverão ser construídas com uso da estrutura 
Union and Find e as atividades prioritárias a serem cumpridas por cada usuário deverão 
compor heaps individuais.
