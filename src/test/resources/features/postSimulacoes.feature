#language:pt
Funcionalidade: Cadastrar Simulacões de acordo com as informações passadas na requisição

  @teste
  Cenario: Cadastrar uma nova simulação com todos os dados corretos
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada

  @teste
  Cenario: Cadastrar uma nova simulação com o campo "CPF" vazio
    Dado que eu passo o body da requisição POST com o campo "cpf" vazio
    E envio a requisição do tipo POST
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo cpf "CPF não pode ser vazio"

  @teste
  Cenario: Cadastrar uma nova simulação com o campo "Nome" vazio
    Dado que eu passo o body da requisição POST com o campo "nome" vazio
    E envio a requisição do tipo POST
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo nome "Nome não pode ser vazio"

  @teste
  Cenario: Cadastrar uma nova simulação com o campo "Email" vazio
    Dado que eu passo o body da requisição POST com o campo "email" vazio
    E envio a requisição do tipo POST
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo email "E-mail não deve ser vazio"

  @teste
  Cenario: Cadastrar uma nova simulação com o campo "Valor" vazio
    Dado que eu passo o body da requisição POST com o campo "valor" vazio
    E envio a requisição do tipo POST
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo valor "Valor não pode ser vazio"

  @teste
  Cenario: Cadastrar uma nova simulação com o campo "Parcelas" vazio
    Dado que eu passo o body da requisição POST com o campo "parcelas" vazio
    E envio a requisição do tipo POST
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo parcelas "Parcelas não pode ser vazio"

  @teste
  Cenario: Cadastrar uma nova simulação com o campo "Seguro" vazio
    Dado que eu passo o body da requisição POST com o campo "seguro" vazio
    E envio a requisição do tipo POST
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo seguro "Seguro não pode ser vazio"

  @teste
  Cenario: Cadastrar uma nova simulação com o campo "CPF" com formato 999.999.999-99
    Dado que eu passo o body da requisição POST com o campo "cpf" inválido "999.999.999-99"
    E envio a requisição do tipo POST
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo cpf "CPF com formato inválido"

  @teste
  Cenário: Cadastrar uma nova simulação com o campo "Email" com formato inválido (gmail.com)
    Dado que eu passo o body da requisição POST com o campo "email" inválido "gmail.com"
    E envio a requisição do tipo POST
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo email "E-mail deve ser um e-mail válido"

  @teste
  Cenario: Cadastrar uma nova simulação com o campo "Valor" menor que 1000
    Dado que eu passo o body da requisição POST com o campo "valor" inválido "999"
    E envio a requisição do tipo POST
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo valor "Valor deve ser maior ou igual a R$ 1.000"

  @teste
  Cenario: Cadastrar uma nova simulação com o campo "Valor" maior que 40000
    Dado que eu passo o body da requisição POST com o campo "valor" inválido "40001"
    E envio a requisição do tipo POST
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo valor "Valor deve ser menor ou igual a R$ 40.000"

  @teste
  Cenario: Cadastrar uma nova simulação com o campo "Parcela" menor que 2
    Dado que eu passo o body da requisição POST com o campo "parcelas" inválido "1"
    E envio a requisição do tipo POST
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo parcelas "Parcelas deve ser igual ou maior que 2"

  @teste
  Cenario: Cadastrar uma nova simulação com o campo "Parcela" maior que 48
    Dado que eu passo o body da requisição POST com o campo "parcelas" inválido "49"
    E envio a requisição do tipo POST
    Entao recebo um HTTP StatusCode 400 como retorno
    E status de erro para o campo parcelas "Parcelas deve ser igual ou menor que 48"

  @teste
  Cenario: Cadastrar uma nova simulação com o campo "Seguro" diferente de false e true
    Dado que eu passo o body da requisição POST com o campo "seguro" inválido "teste"
    E envio a requisição do tipo POST
    Entao recebo um HTTP StatusCode 400 como retorno

  @teste
  Cenario: Cadastrar uma nova simulação com um CPF que ja está cadastrado
    Dado que eu passo o body da requisição POST com os dados corretos
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 201 como retorno
    E os dados da simulação cadastrada
    Quando eu passo o body da requisição POST passando o mesmo cpf da requisição anterior
    E envio a requisição do tipo POST
    Então recebo um HTTP StatusCode 409 como retorno
    E status de erro para o campo cpf "CPF já existente"
