#language:pt
Funcionalidade: Deletar simulação cadastrada

  @teste
  Cenario: Deletar uma simulação cadastrada
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    E envio a requisição do tipo DELETE passando o ID da simulacao criada anteriormente
    Entao recebo um HTTP StatusCode 204 como retorno

  @teste
  Cenario: Deletar uma simulação passando um ID que não está cadastrado
    Quando envio a requisição do tipo DELETE passando o ID inválido
    Entao recebo um HTTP StatusCode 404 como retorno
    E a mensagem "Simulação não encontrada"