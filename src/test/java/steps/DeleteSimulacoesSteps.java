package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.restassured.RestAssured;
import runners.RunDeleteSimulacoesTest;
import static steps.PostSimulacoesSteps.*;

public class DeleteSimulacoesSteps extends RunDeleteSimulacoesTest {
    @E("^envio a requisição do tipo DELETE passando o ID (.*)$")
    public void deletarSimulacao(String mensagem){
        if(mensagem.equals("inválido")){
            id = -1;
        }
        response = request.when().log().all().delete("/api/v1/simulacoes/" + id);
    }

    @Dado("^que deleto todos as simulações$")
    public void deletarTodasAsSimulacoes() {
        response = request.when().log().all().get("/api/v1/simulacoes");
        response.then().log().all();
        String body = response.body().asString();
        while (body.contains("id")){
            response = request.when().log().all().get("/api/v1/simulacoes");
            response.then().log().all();
            body = response.body().asString();
            if (body.contains("id")){
                id = response.path("id[0]");
                request = RestAssured.given().log().all();
                response = request.when().log().all().delete("/api/v1/simulacoes/" + id);
            }
        }
    }
}
