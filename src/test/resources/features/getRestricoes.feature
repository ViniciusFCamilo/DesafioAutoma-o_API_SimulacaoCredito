#language:pt
Funcionalidade: Verificar se o CPF passado possui restrição

  @teste
  Cenario: Consultar um CPF que não possui restrição
    Dado que faço uma requisição GET passando um CPF que não possui restrição
    Então recebo um HTTP Status 204 como retorno

  @teste
  Esquema do Cenario: Consultar um CPF que possui restrição
    Dado que faço uma requisição GET passando um CPF que possui restrição
      | CPF   |
      | <CPF> |
    Então recebo um HTTP Status 200 como retorno
    E a mensagem "O CPF <CPF> possui restrição"

    Exemplos:
      |CPF        |
      |97093236014|
      |60094146012|
      |84809766080|
      |62648716050|
      |26276298085|
      |01317496094|
      |55856777050|
      |19626829001|
      |24094592008|
      |58063164083|



