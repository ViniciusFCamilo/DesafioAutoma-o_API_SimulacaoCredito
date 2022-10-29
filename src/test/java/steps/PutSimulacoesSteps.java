package steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import runners.RunPutSimulacoesTest;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static steps.PostSimulacoesSteps.*;

public class PutSimulacoesSteps extends RunPutSimulacoesTest {
    PostSimulacoesSteps postSimulacoesSteps = new PostSimulacoesSteps();
    private String cpfPut = null;
    private String nomePut = null;
    private String emailPut = null;
    private float valorPut = 0;
    private Integer parcelasPut = null;
    private Boolean seguroPut = null;
    private String cpfAux = null;

    @Quando("^eu passo o body da requisição PUT passando o campo \"(.*)\" como \"(.*)\"$")
    public void passarBodyPutCorreto(String campo, String alteraAtributo) throws Exception {
        cpfPut = cpf;
        nomePut = nome;
        emailPut = email;
        valorPut = valor;
        parcelasPut = parcelas;
        seguroPut = seguro;
        if(campo.equals("nome")){
            nomePut = alteraAtributo;
        }else if(campo.equals("cpf")){
            postSimulacoesSteps.pegarCpfDoUsuario();
            if (alteraAtributo.equals("não cadastrado")){
                cpfPut = cpf;
            }
        }else if(campo.equals("email")){
            emailPut = alteraAtributo;
        }else if(campo.equals("parcelas")){
            parcelasPut = Integer.parseInt(alteraAtributo);
        }else if(campo.equals("valor")){
            valorPut = Float.parseFloat(alteraAtributo);
        }else if(campo.equals("seguro")){
            if (alteraAtributo.equals("true")){
                seguroPut = true;
            }else if (alteraAtributo.equals("false")){
                seguroPut = false;
            }
        }
        request.body(
                "{\n" +
                        "  \"nome\": \"" + nomePut + "\",\n" +
                        "  \"cpf\": \"" + cpfPut + "\",\n" +
                        "  \"email\": \"" + emailPut + "\",\n" +
                        "  \"valor\": " + valorPut + ",\n" +
                        "  \"parcelas\": " + parcelasPut + ",\n" +
                        "  \"seguro\": " + seguroPut + "\n" +
                        "}").log().all();
    }

    @E("^os dados da simulação editada$")
    public void retornarDadosEditados() {
       response.then().log().all().body("id", notNullValue())
                .body("nome", is(nomePut))
                .body("cpf", is(cpfPut))
                .body("email", is(emailPut))
                .body("valor", is(Float.valueOf(valorPut)))
                .body("parcelas", is(parcelasPut))
                .body("seguro", is(seguroPut));
    }

    @Quando("^eu passo o body da requisição PUT com o campo \"(.*)\" inválido \"(.*)\"$")
    public void passarBodyPostComDadoInvalido(String campo, String campoInvalido){
        cpfPut = cpf;
        nomePut = nome;
        emailPut = email;
        valorPut = valor;
        parcelasPut = parcelas;
        seguroPut = seguro;
        if (campo.equals("cpf")){
            request.body(
                    "{\n" +
                            "  \"nome\": \"" + nomePut + "\",\n" +
                            "  \"cpf\": \"" + campoInvalido + "\",\n" +
                            "  \"email\": \"" + emailPut + "\",\n" +
                            "  \"valor\": " + valorPut + ",\n" +
                            "  \"parcelas\": " + parcelasPut + ",\n" +
                            "  \"seguro\": " + seguroPut + "\n" +
                            "}").log().all();
        } else if (campo.equals("email")) {
            request.body(
                    "{\n" +
                            "  \"nome\": \"" + nomePut + "\",\n" +
                            "  \"cpf\": \"" + cpfPut + "\",\n" +
                            "  \"email\": \"" + campoInvalido + "\",\n" +
                            "  \"valor\": " + valorPut + ",\n" +
                            "  \"parcelas\": " + parcelasPut + ",\n" +
                            "  \"seguro\": " + seguroPut + "\n" +
                            "}").log().all();
        } else if (campo.equals("valor")) {
            request.body(
                    "{\n" +
                            "  \"nome\": \"" + nomePut + "\",\n" +
                            "  \"cpf\": \"" + cpfPut + "\",\n" +
                            "  \"email\": \"" + emailPut + "\",\n" +
                            "  \"valor\": " + campoInvalido + ",\n" +
                            "  \"parcelas\": " + parcelasPut + ",\n" +
                            "  \"seguro\": " + seguroPut + "\n" +
                            "}").log().all();
        } else if (campo.equals("parcelas")) {
            request.body(
                    "{\n" +
                            "  \"nome\": \"" + nomePut + "\",\n" +
                            "  \"cpf\": \"" + cpfPut + "\",\n" +
                            "  \"email\": \"" + emailPut + "\",\n" +
                            "  \"valor\": " + valorPut + ",\n" +
                            "  \"parcelas\": " + campoInvalido + ",\n" +
                            "  \"seguro\": " + seguroPut + "\n" +
                            "}").log().all();
        } else if (campo.equals("seguro")) {
            request.body(
                    "{\n" +
                            "  \"nome\": \"" + nomePut + "\",\n" +
                            "  \"cpf\": \"" + cpfPut + "\",\n" +
                            "  \"email\": \"" + emailPut + "\",\n" +
                            "  \"valor\": " + valorPut + ",\n" +
                            "  \"parcelas\": " + parcelasPut + ",\n" +
                            "  \"seguro\": " + campoInvalido + "\n" +
                            "}").log().all();
        }
    }
    @Quando("^eu passo o body da requisição PUT passando o mesmo cpf da requisição anterior$")
    public void passarBodyPostComCpfJaCadastrado(){
        nomePut = nome;
        emailPut = email;
        valorPut = valor;
        parcelasPut = parcelas;
        seguroPut = seguro;
        request.body(
                "{\n" +
                        "  \"nome\": \"" + nomePut + "\",\n" +
                        "  \"cpf\": \"" + cpfAux + "\",\n" +
                        "  \"email\": \"" + emailPut + "\",\n" +
                        "  \"valor\": " + valorPut + ",\n" +
                        "  \"parcelas\": " + parcelasPut + ",\n" +
                        "  \"seguro\": " + seguroPut + "\n" +
                        "}").log().all();
    }
    @E("^envio a requisição do tipo PUT$")
    public void enviarRequisicaoPut() {
        response = request.when().log().all().put("/api/v1/simulacoes/"+ cpfPut);
    }
    @E("^a mensagem de erro \"(.*)\"$")
    public void informaçãoDeErro(String mensagem) {
        response.then().log().all().body("mensagem", is(mensagem));
    }
    @E("^guardo o CPF usado na simulação criada$")
    public void guardarCpf(){
        cpfAux = cpf;
    }
}
