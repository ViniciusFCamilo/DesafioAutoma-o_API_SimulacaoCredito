# Desafio de Automação de API - Simulação de Crédito
## ==== Sobre o Projeto ====
Esse projeto tem como objetivo testar uma API de Simulação de Crédito de acordo com as regras passadas
## ==== Requisitos para rodar o projeto ====
- Deve possuir o Java 8+ JDK, e o Maven instalados
- Deve possuir as variaveis de ambiente do java e do maven configuradas

### Configuração das variaveis
#### Criar variavel - Maven 
- Nome da variavel = M2_HOME
- Valor da Variavel = caminho conde o maven foi instalado

Java
- Nome da variavel = CLASS_PATH
- Valor da Variavel = %JAVA_HOME%\lib\tools.jar;.;

#### Adicionar variaveis no path
- Selecionar path e clicar em editar
- Adicionar duas novas variavéis com os seguintes valores

  - caminho conde o maven foi instalado\bin
  - %JAVA_HOME%\bin
  
- Clicar em ok

## ==== Como rodar o projeto ====
1. Subir a aplicação Back-end rodando o projeto localizado em "https://github.com/rh-southsystem/Sicredi-Digital-QA"
2. Abrir o projeto e esperar todas as dependências serem baixadas
3. Abrir o arquivo pom.xml e sincronizar as mudanças do maven (Atalho no IntelliJ: Ctrl + Shift + O)
4. Executar os testes pelas classes que ficam no diretório src/test/java/runners

## ==== Visualizar resultado das execuções ====
Após rodar o projeto, será criado um diretório "\target\reports" dentro da raiz do projeto, com os relatórios de execução de cada Feature
## ==== Regras ====
### Consultar uma restrição pelo CPF
GET <host>/api/v1/restricoes/{cpf}

    Consulta se a simulação informada possui alguma restrição.
    
    - Se não possui restrição o HTTP Status 204 é retornado
    - Se possui restrição o HTTP Status 200 é retornado com a mensagem "O CPF99999999999 possui restrição"
| CPFs com restrição |
|--------------------|
| 97093236014        |
| 60094146012        |
| 84809766080        |
| 62648716050        |
| 26276298085        |
| 01317496094        |
| 55856777050        |
| 19626829001        |
| 24094592008        |
| 58063164083        |

### Consultar todas a simulações cadastradas
GET <host>/api/v1/simulacoes

    Lista as simulações cadastradas.
    
    - Retorna a lista de simulações cadastradas e existir uma ou mais 
    - Retorna HTTP Status 204 se não existir simulações cadastradas 

    
### Consultar uma simulação pelo CPF
GET <host>/api/v1/simulacoes/{cpf}

    Retorna a simulação previamente cadastrada pelo CPF. 

    - Retorna a simulação cadastrada 
    - Se o CPF não possuir uma simulação o HTTP Status 404 é retornado 

### Criar uma simulação
POST <host>/api/v1/simulacoes

    Este endpoint é responsável por inserir uma nova simulação.

    - Uma simulação cadastrada com sucesso retorna o HTTP Status 201 e os dados inseridos como retorno
    - Uma simulação com problema em alguma regra retorna o HTTP Status 400 com a lista de erros
    - Uma simulação para um mesmo CPF retorna um HTTP Status 409 com a mensagem "CPF já existente"
| Atributo | Obrigatório | Regra                                                                                      |
|----------|-------------|--------------------------------------------------------------------------------------------|
| cpf      | sim         | texto informando o CPF não no formato 999.999.999-99                                       |
| nome     | sim         | texto informando o nome da pessoa                                                          |
| email    | sim         | texto informado um e-mail válido                                                           |
| valor    | sim         | valor da simulação que deve ser igual ou maior que R$ 1.000 e menor ou igual que R$ 40.000 |
| parcela  | sim         | número de parcelas para pagamento que deve ser igual ou maior que 2 e menor ou igual a 48  |
| seguro   | sim         | booleano true se com seguro e false se sem seguro                                          |

### Put Simulações
PUT <host>/api/v1/simulacoes/{cpf}

    Altera uma simulação já existente, onde o CPF deve ser informado para que a alteração possa ser efetuada.

    - A alteração pode ser feita em qualquer atributo da simulação
    - As mesmas regras se mantém
    - Se o CPF não possuir uma simulação o HTTP Status 404 é retornado com a mensagem "CPF não encontrado"

### Delete Simulações
DELETE <host>/api/v1/simulacoes/{id}

    Remove uma simulação previamente cadastrada pelo seu ID. 

    - Retorna o HTTP Status 204 se simulação for removida com sucesso
    - Retorna o HTTP Status 404 com a mensagem "Simulação não encontrada" se não existir a simulação pelo ID informado


## ==== Cenários que falharam + bugs encontrados ====
| Feature            | Cenário                                                                              | Bug                                                                                                                                                                                                                 |
|--------------------|--------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------| 
| getRestricoes      | Consultar um CPF que possui restrição                                                | Deve retornar a mensagem "O CPF 99999999999 possui restrição" e está retornando a mensagem "O CPF 99999999999 tem problema"                                                                                         |
| getTodasSimulacoes | Consultar todas as simulações cadastradas (nenhuma simulação cadastrada)             | Deve retornar o StatusCode 204 e está retornando 200                                                                                                                                                                |
| postSimulacoes     | Cadastrar uma nova simulação com o campo "Seguro" vazio                              | A API permite cadastrar uma simulação com valor nulo, sendo assim o teste espera um retorno de StatusCode 400 mas é retornado 201                                                                                   |
| postSimulacoes     | Cadastrar uma nova simulação com o campo "CPF" com formato 999.999.999-99            | A API permite cadastrar o campo CPF como se fosse uma string sem restrição, qualquer coisa que seja colocada no cpf a API vai permitir, sendo assim o teste espera um retorno de StatusCode 400 mas é retornado 201 |
| postSimulacoes     | Cadastrar uma nova simulação com o campo "Email" com formato inválido (gmail.com)    | A API não tem uma mensagem de retorno padrão, as vezes ela retorna "E-mail deve ser um e-mail válido" e outras vezes retorna "não é um endereço de e-mail"                                                          |
| postSimulacoes     | Cadastrar uma nova simulação com o campo "Valor" menor que 1000                      | A API aceita valores menores que 1000 para o campo "Valor", sendo assim o teste espera um retorno de StatusCode 400 mas é retornado 201                                                                             |
| postSimulacoes     | Cadastrar uma nova simulação com o campo "Parcela" maior que 48                      | A API aceita valores maiores que 48 para o campo "Parcelas", sendo assim o teste espera um retorno de StatusCode 400 mas é retornado 201                                                                            |
| postSimulacoes     | Cadastrar uma nova simulação com um CPF que ja está cadastrado                       | Ao cadastrar uma simulação com um cpf que já existe em outra deve retornar o StatusCode 409 e está retornando 400, e a mensagem deve retornar "CPF já existente" e está retonando "CPF duplicado"                   |
| putSimulacoes      | Alterar uma simulação existente mudando o campo Valor                                | A API não permite alterar o campo valor                                                                                                                                                                             |
| putSimulacoes      | Alterar uma simulação existente com o campo "CPF" com formato 999.999.999-99         | A API permite alterar o campo CPF como se fosse uma string sem restrição, qualquer coisa que seja colocada no cpf a API vai permitir, sendo assim o teste espera um retorno de StatusCode 400 mas é retornado 200   |
| putSimulacoes      | Alterar uma nova simulação com o campo "Email" com formato inválido (gmail.com)      | A API não tem uma mensagem de retorno padrão, as vezes ela retorna "E-mail deve ser um e-mail válido" e outras vezes retorna "não é um endereço de e-mail"                                                          |
| putSimulacoes      | Alterar uma simulação existente com o campo "Valor" menor que 1000                   | A API não permite alterar o campo valor                                                                                                                                                                             |
| putSimulacoes      | Alterar uma simulação existente com o campo "Valor" maior que 40000                  | A API não permite alterar o campo valor                                                                                                                                                                             |
| putSimulacoes      | Alterar uma simulação existente com o campo "Parcela" maior que 48                   | A API aceita valores maiores que 48 para o campo "Parcelas", sendo assim o teste espera um retorno de StatusCode 400 mas é retornado 200                                                                            |
| putSimulacoes      | Alterar uma simulação existente com um CPF que ja está cadastrado em outra simulação | Deve retornar o StatusCode 409 e está retornando 400, e a mensagem deve retornar "CPF já existente" e está retonando "CPF duplicado"                                                                                |
| putSimulacoes      | Alterar simulação passando um CPF não cadastrado                                     | Deve retornar a mensagem "CPF não encontrado" e a API retorna "CPF 99999999999 não encontrado"                                                                                                                      |
| DeleteSimulacoes   | Deletar uma simulação cadastrada                                                     | Deve retornar o StatusCode 204 e está retornando 200 com uma mensagem "OK", pois a API não valida o ID passado na requisição delete                                                                                 |
| DeleteSimulacoes   | Deletar uma simulação passando um ID que não está cadastrado                         | Deve retornar o StatusCode 404 e está retornando 200 com uma mensagem "OK", pois a API não valida o ID passado na requisição delete                                                                                 |
