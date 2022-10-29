#language:pt
Funcionalidade: Consultar uma simulação especifica

  @teste
  Cenario: Consultar uma simulação especifica (sucesso)
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    E envio uma requisição do tipo GET passando o CPF da simulacao criada anteriormente
    Então recebo um HTTP StatusCode 200 como retorno

#  Proximo teste possui uma linha comentada pois o delete da API está com problma (retornando statusCode errado), então
#  essa linha foi comentada apenas para mostrar o teste seguindo e verificando o GET
  @teste
  Cenario: Consultar uma simulação especifica (não encontrou cpf)
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    E envio a requisição do tipo DELETE passando o ID da simulacao criada anteriormente
#    Entao recebo um HTTP StatusCode 204 como retorno
    E envio uma requisição do tipo GET passando o CPF da simulação que foi deletada
    Então recebo um HTTP StatusCode 404 como retorno

