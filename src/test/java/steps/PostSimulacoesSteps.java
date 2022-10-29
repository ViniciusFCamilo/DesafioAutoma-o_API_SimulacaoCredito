package steps;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;
import runners.RunPostSimulacoesTest;
import support.Utils;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class PostSimulacoesSteps extends RunPostSimulacoesTest {
    public static Response response;
    Utils utils;
    public  static String cpf = null;
    public static String nome = "Vinicius Ferreira Camilo";
    public static String email = "vini@gmail.com";
    public static Integer parcelas = 10;
    public static float valor = 3000;
    public static Boolean seguro = true;
    public static int id = 0;

    public void pegarCpfDoUsuario(){
        utils = new Utils();
        cpf = utils.getCpf();

    }
    @Dado("que eu passo o body da requisição POST com os dados corretos")
    public void passarBodyPostCorreto(){
        pegarCpfDoUsuario();
        request.body(
                "{\n" +
                        "  \"nome\": \"" + nome + "\",\n" +
                        "  \"cpf\": \"" + cpf + "\",\n" +
                        "  \"email\": \"" + email + "\",\n" +
                        "  \"valor\": " + valor + ",\n" +
                        "  \"parcelas\": " + parcelas + ",\n" +
                        "  \"seguro\": " + seguro + "\n" +
                        "}").log().all();
    }
    @E("^os dados da simulação cadastrada$")
    public void retornarDadosCadastrados() {
        response.then().log().all().body("id", notNullValue())
                .body("nome", is(nome))
                .body("cpf", is(cpf))
                .body("email", is(email))
                .body("valor", is(valor))
                .body("parcelas", is(parcelas))
                .body("seguro", is(seguro));
        id = response.path("id");
    }
    @Dado("^que eu passo o body da requisição POST com o campo \"(.*)\" vazio$")
    public void passarBodyPostComDadoVazio(String campo){
        pegarCpfDoUsuario();
        if (campo.equals("cpf")){
            request.body(
                    "{\n" +
                            "  \"nome\": \"" + nome + "\",\n" +
                            "  \"cpf\": null,\n" +
                            "  \"email\": \"" + email + "\",\n" +
                            "  \"valor\": " + valor + ",\n" +
                            "  \"parcelas\": " + parcelas + ",\n" +
                            "  \"seguro\": " + seguro + "\n" +
                            "}").log().all();
        } else if (campo.equals("nome")) {
            request.body(
                    "{\n" +
                            "  \"nome\": null,\n" +
                            "  \"cpf\": \"" + cpf + "\",\n" +
                            "  \"email\": \"" + email + "\",\n" +
                            "  \"valor\": " + valor + ",\n" +
                            "  \"parcelas\": " + parcelas + ",\n" +
                            "  \"seguro\": " + seguro + "\n" +
                            "}").log().all();
        } else if (campo.equals("email")) {
            request.body(
                    "{\n" +
                            "  \"nome\": \"" + nome + "\",\n" +
                            "  \"cpf\": \"" + cpf + "\",\n" +
                            "  \"email\": null,\n" +
                            "  \"valor\": " + valor + ",\n" +
                            "  \"parcelas\": " + parcelas + ",\n" +
                            "  \"seguro\": " + seguro + "\n" +
                            "}").log().all();
        } else if (campo.equals("parcelas")) {
            request.body(
                "{\n" +
                        "  \"nome\": \"" + nome + "\",\n" +
                        "  \"cpf\": \"" + cpf + "\",\n" +
                        "  \"email\": \"" + email + "\",\n" +
                        "  \"valor\": " + valor + ",\n" +
                        "  \"parcelas\": null,\n" +
                        "  \"seguro\": " + seguro + "\n" +
                        "}").log().all();
        } else if (campo.equals("valor")) {
            request.body(
                    "{\n" +
                            "  \"nome\": \"" + nome + "\",\n" +
                            "  \"cpf\": \"" + cpf + "\",\n" +
                            "  \"email\": \"" + email + "\",\n" +
                            "  \"valor\": null,\n" +
                            "  \"parcelas\": " + parcelas + ",\n" +
                            "  \"seguro\": " + seguro + "\n" +
                            "}").log().all();
        } else if (campo.equals("seguro")) {
            request.body(
                    "{\n" +
                            "  \"nome\": \"" + nome + "\",\n" +
                            "  \"cpf\": \"" + cpf + "\",\n" +
                            "  \"email\": \"" + email + "\",\n" +
                            "  \"valor\": " + valor + ",\n" +
                            "  \"parcelas\": " + parcelas + ",\n" +
                            "  \"seguro\": null\n" +
                            "}").log().all();
        }
    }

    @Dado("^que eu passo o body da requisição POST com o campo \"(.*)\" inválido \"(.*)\"$")
    public void passarBodyPostComDadoInvalido(String campo, String campoInvalido){
        pegarCpfDoUsuario();
        if (campo.equals("cpf")){
            request.body(
                    "{\n" +
                            "  \"nome\": \"" + nome + "\",\n" +
                            "  \"cpf\": \"" + campoInvalido + "\",\n" +
                            "  \"email\": \"" + email + "\",\n" +
                            "  \"valor\": " + valor + ",\n" +
                            "  \"parcelas\": " + parcelas + ",\n" +
                            "  \"seguro\": " + seguro + "\n" +
                            "}").log().all();
        } else if (campo.equals("email")) {
            request.body(
                    "{\n" +
                            "  \"nome\": \"" + nome + "\",\n" +
                            "  \"cpf\": \"" + cpf + "\",\n" +
                            "  \"email\": \"" + campoInvalido + "\",\n" +
                            "  \"valor\": " + valor + ",\n" +
                            "  \"parcelas\": " + parcelas + ",\n" +
                            "  \"seguro\": " + seguro + "\n" +
                            "}").log().all();
        } else if (campo.equals("valor")) {
            request.body(
                "{\n" +
                        "  \"nome\": \"" + nome + "\",\n" +
                        "  \"cpf\": \"" + cpf + "\",\n" +
                        "  \"email\": \"" + email + "\",\n" +
                        "  \"valor\": " + campoInvalido + ",\n" +
                        "  \"parcelas\": " + parcelas + ",\n" +
                        "  \"seguro\": " + seguro + "\n" +
                        "}").log().all();
        } else if (campo.equals("parcelas")) {
            request.body(
                "{\n" +
                        "  \"nome\": \"" + nome + "\",\n" +
                        "  \"cpf\": \"" + cpf + "\",\n" +
                        "  \"email\": \"" + email + "\",\n" +
                        "  \"valor\": " + valor + ",\n" +
                        "  \"parcelas\": " + campoInvalido + ",\n" +
                        "  \"seguro\": " + seguro + "\n" +
                        "}").log().all();
        } else if (campo.equals("seguro")) {
            request.body(
                "{\n" +
                        "  \"nome\": \"" + nome + "\",\n" +
                        "  \"cpf\": \"" + cpf + "\",\n" +
                        "  \"email\": \"" + email + "\",\n" +
                        "  \"valor\": " + valor + ",\n" +
                        "  \"parcelas\": " + parcelas + ",\n" +
                        "  \"seguro\": " + campoInvalido + "\n" +
                        "}").log().all();
        }
    }

    @Dado("^eu passo o body da requisição POST passando o mesmo cpf da requisição anterior$")
    public void passarBodyPostComCpfJaCadastrado(){
        request.body(
                "{\n" +
                        "  \"nome\": \"" + nome + "\",\n" +
                        "  \"cpf\": \"" + cpf + "\",\n" +
                        "  \"email\": \"" + email + "\",\n" +
                        "  \"valor\": " + valor + ",\n" +
                        "  \"parcelas\": " + parcelas + ",\n" +
                        "  \"seguro\": " + seguro + "\n" +
                        "}").log().all();
    }

    @E("envio a requisição do tipo POST")
    public void enviarRequisicaoPost() {
        response = request.when().log().all().post("/api/v1/simulacoes");
    }
    @Então("^recebo um HTTP StatusCode (.*) como retorno$")
    public void retornarStatusCode(int statusCode) {
        response.then().log().all().statusCode(statusCode);
    }

    @E("^status de erro para o campo (.*) \"(.*)\"$")
    public void statusDeErro(String campo, String mensagem) {
        response.then().log().all().body("erros."+campo, is(mensagem));
    }

}
