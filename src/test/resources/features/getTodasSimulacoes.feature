#language:pt
Funcionalidade: Consultar todas as simulações cadastradas

  @teste
  Cenario: Consultar todas as simulações cadastradas (ao menos uma simulação cadastrada)
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    E envio uma requisição do tipo GET
    Então recebo um HTTP StatusCode 200 como retorno

  @teste
  Cenario: Consultar todas as simulações cadastradas (nenhuma simulação cadastrada)
    Dado que deleto todos as simulações
    E envio uma requisição do tipo GET
    Então recebo um HTTP StatusCode 204 como retorno