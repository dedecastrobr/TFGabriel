## Escopo do Trabalho Final

### Sistema VendasSuplementos

Você deve implementar um sistema de informações para auxiliar um vendedor de suplementos de academias

Considerando esse contexto crie um projeto no Eclipse com o nome de "VendasSuplementos" com as seguintes funcionalidades:

### Menus

* O usuário deve ser capaz de acessar todas as funcionalidades do sistem através de menus, com opções núméricas e todos os menus devem ter a opção "99" para voltar ao menu anterior ou sair do sistema caso, esteja no menu principal;

* O menu principal do sistema deve ter as opções "Clientes", "Produtos", "Pedidos", "Estoque";

### Clientes

* O sistema deve manter um cadastro de clientes, com Nome, CPF, endereço, e-mail.
* O menu de clientes deve ter as opções "Cadastrar" e "Pesquisar".
* Ao selecionar "Cadastrar", o usuário pode adicionar um novo cliente na base de dados;
* Ao "Pesquisar", pode ser informado o código **OU** o nome do cliente. O sistema deve fazer a busca, por código **OU** nome e retornar uma lista com os resultados encontrados.
* Na lista o sistema deve oferecer as opções "Remover" e "Alterar"; O usuário seleciona a opção e o informa o código do registro;
* No caso de remoção deve ser exibida uma mensagem com os dados do cliente e solicitando a confirmação do usuário, caso afirmativo o registro é deletado do banco de dados.
* Caso hajam pedidos associados ao cliente, a remoção pode falhar dependendo da forma que você criar a relação no banco de dados. Caso isso ocorra, informe ao usuário.
* Na alteração, são solicitados os novos dados do cliente, considerando "nulo" como "não alterar". Os novos dados são exibidos no final, solicitando uma confirmação do usuário. Caso afirmativo, os dados são atualizados no banco;

### Produtos

* O sistema deve manter um cadastro de produtos, com nome, descrição, valor e quantidade em estoque.
* O menu de produtos deve ter as opções "Cadastrar" e "Pesquisar".
* Ao selecionar "Cadastrar", o usuário pode adicionar um novo produto na base de dados;
* Ao "Pesquisar", pode ser informado o código **OU** o nome do produto. O sistema deve fazer a busca, por código **OU** nome e retornar uma lista com os resultados encontrados.
* Na lista o sistema deve oferecer as opções "Remover" e "Alterar"; O usuário seleciona a opção e o informa o código do registro;
* No caso de remoção deve ser exibida uma mensagem com os dados do produto e solicitando a confirmação do usuário, caso afirmativo o registro é deletado do banco de dados.
* Caso hajam pedidos associados ao produto, a remoção pode falhar dependendo da forma que você criar a relação no banco de dados. Caso isso ocorra, informe ao usuário.
* Na alteração, são solicitados os novos dados do produto, considerando "nulo" como "não alterar". Os novos dados são exibidos no final, solicitando uma confirmação do usuário. Caso afirmativo, os dados são atualizados no banco;

### Pedidos

* O sistema deve manter um controle de pedidos com produto, cliente, quantidade de itens e status.
* O menu de pedidos deve ter as opções "Cadastrar" e "Pesquisar".
* Ao selecionar "Cadastrar", o usuário pode adicionar um novo pedido na base de dados;
* Ao cadastrar sistema deve solicitar ao usuário o produto e cliente, através de buscas por código **OU** o nome. Após a busca, com o resultado na tela o usuário informa o código dos registros desejados para cliente e/ou produto.
* Selecionado o produto e o cliente, o usuário deve informar a quantidade e seguida conferir os dados do pedido e salvar ele no banco;
* Ao "Pesquisar", deve ser informado o código do pedido. Caso o usuário não saiba, ele pode informar 0 (zero) para que sejam exibidos todos os pedidos. O sistema deve fazer a busca e retornar uma lista com os resultados encontrados, informando o código do pedido, o NOME do produto e o NOME do cliente.
* Na lista o sistema deve oferecer as opções "Cancelar" e "Fechar"; O usuário seleciona a opção e o informa o código do registro;
* No caso de cancelamento deve ser exibida uma mensagem com os dados do pedido solicitando a confirmação do usuário, caso afirmativo o status do pedido é alterado para "CANCELADO".
* No fechamento, o status do pedido é alterado para "FECHADO" e a quantidade é subtraída do total disponível;
* Processamento em lote. Permita que o usuário informe uma sequência de pedidos e efetue o fechamento ou cancelamento de todos ao mesmo tempo;
* Implemente a busca de pedidos por cliente. Nome ou código;

### Estoque

* O controle de estoque se dá através da quantidade, que consta na tabela de produtos;
* Conforme definido anteriormente toda a vez que um pedido é lançado para um produto, a quantidade do pedido deve ser subtraída do total disponível;
* O menu do estoque deve ter as opções "Atualizar" e "Relatório de Estoque";
* Ao atualizar o usuário faz uma busca de produto por código **OU** nome e informa o novo total disponível. Nenhuma outra informação do produto é alterada além da quantidade;
* O relatório de estoque deve mostrar ao usuário qual a situação do estoque com relação aos pedidos efetuados. Deve ser exibida as somas das quantidades dos pedidos com status "NOVO" versus o total disponível no estoque. Caso haja necessidade de reposição, isso deve ser sinalizado para o usuário no relatório de alguma forma;
* Processamento em lote. Permita que o usuário informe uma sequência de produtos e atulize todas as quantidades ao mesmo tempo;
