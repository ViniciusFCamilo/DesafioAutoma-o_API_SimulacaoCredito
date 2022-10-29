#language:pt
Funcionalidade: Alterar Simulacões de acordo com as informações passadas na requisição

  @teste
  Cenário: Alterar uma simulação existente mudando o campo Nome passando um valor válido
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    Quando eu passo o body da requisição PUT passando o campo "nome" como "Letycia Silveira da Rosa"
    E envio a requisição do tipo PUT
    Então recebo um HTTP StatusCode 200 como retorno
    E os dados da simulação editada

  @teste
  Cenário: Alterar uma simulação existente mudando o campo CPF passando um valor válido
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    Quando eu passo o body da requisição PUT passando o campo "cpf" como "aleatório"
    E envio a requisição do tipo PUT
    Então recebo um HTTP StatusCode 200 como retorno
    E os dados da simulação editada

  @teste
  Cenário: Alterar uma simulação existente mudando o campo Email passando um valor válido
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    Quando eu passo o body da requisição PUT passando o campo "email" como "letycia@gmail.com"
    E envio a requisição do tipo PUT
    Então recebo um HTTP StatusCode 200 como retorno
    E os dados da simulação editada

  @teste
  Cenário: Alterar uma simulação existente mudando o campo Valor passando um valor válido
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    Quando eu passo o body da requisição PUT passando o campo "valor" como "25000"
    E envio a requisição do tipo PUT
    Então recebo um HTTP StatusCode 200 como retorno
    E os dados da simulação editada

  @teste
  Cenário: Alterar uma simulação existente mudando o campo Parcelas passando um valor válido
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    Quando eu passo o body da requisição PUT passando o campo "parcelas" como "15"
    E envio a requisição do tipo PUT
    Então recebo um HTTP StatusCode 200 como retorno
    E os dados da simulação editada

  @teste
  Cenário: Alterar uma simulação existente mudando o campo Seguro passando um valor válido
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    Quando eu passo o body da requisição PUT passando o campo "seguro" como "falso"
    E envio a requisição do tipo PUT
    Então recebo um HTTP StatusCode 200 como retorno
    E os dados da simulação editada

  @teste
  Cenario: Alterar uma simulação existente com o campo "CPF" com formato 999.999.999-99
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    Quando eu passo o body da requisição PUT com o campo "cpf" inválido "999.999.999-99"
    E envio a requisição do tipo PUT
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo cpf "CPF com formato inválido"

  @teste
  Cenário: Alterar uma simulação existente com o campo "Email" com formato inválido (gmail.com)
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    Quando eu passo o body da requisição PUT com o campo "email" inválido "gmail.com"
    E envio a requisição do tipo PUT
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo email "E-mail deve ser um e-mail válido"

  @teste
  Cenario: Alterar uma simulação existente com o campo "Valor" menor que 1000
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    Quando eu passo o body da requisição PUT com o campo "valor" inválido "999"
    E envio a requisição do tipo PUT
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo valor "Valor deve ser maior ou igual a R$ 1.000"

  @teste
  Cenario: Alterar uma simulação existente com o campo "Valor" maior que 40000
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    Quando eu passo o body da requisição PUT com o campo "valor" inválido "40001"
    E envio a requisição do tipo PUT
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo valor "Valor deve ser menor ou igual a R$ 40.000"

  @teste
  Cenario: Alterar uma simulação existente com o campo "Parcela" menor que 2
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    Quando eu passo o body da requisição PUT com o campo "parcelas" inválido "1"
    E envio a requisição do tipo PUT
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo parcelas "Parcelas deve ser igual ou maior que 2"

  @teste
  Cenario: Alterar uma simulação existente com o campo "Parcela" maior que 48
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    Quando eu passo o body da requisição PUT com o campo "parcelas" inválido "49"
    E envio a requisição do tipo PUT
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo parcelas "Parcelas deve ser igual ou menor que 48"

  @teste
  Cenario: Alterar uma simulação existente com o campo "Seguro" diferente de false e true
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    Quando eu passo o body da requisição PUT com o campo "seguro" inválido "teste"
    E envio a requisição do tipo PUT
    Entao recebo um HTTP StatusCode 400 como retorno

  @teste
  Cenario: Alterar uma simulação existente com um CPF que ja está cadastrado em outra simulação
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    E guardo o CPF usado na simulação criada
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    Quando eu passo o body da requisição PUT passando o mesmo cpf da requisição anterior
    E envio a requisição do tipo PUT
    Então recebo um HTTP StatusCode 409 como retorno
    E status de erro para o campo cpf "CPF já existente"

  @teste
  Cenario: Alterar simulação passando um CPF ainda não cadastrado
    Quando  eu passo o body da requisição PUT passando o campo "cpf" como "não cadastrado"
    E envio a requisição do tipo PUT
    Então recebo um HTTP StatusCode 404 como retorno
    E a mensagem de erro "CPF não encontrado"

