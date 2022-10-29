package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;
import runners.RunGetRestricoesTest;

import java.util.Map;

import static org.hamcrest.Matchers.is;

public class GetRestricoesSteps extends RunGetRestricoesTest {

    Response response;
    public static String cpfSemRestricao = "63271443653";
    public String cpfComRestricao = null;

    @Dado("^que faço uma requisição GET passando um CPF que não possui restrição$")
    public void enviarCpfSemRestricao() {
        response = request.when().log().all().get("/api/v1/restricoes/" + cpfSemRestricao);
    }

    @Dado("que faço uma requisição GET passando um CPF que possui restrição")
    public void enviarCpfComRestricao(DataTable table) {
        for (Map<Object, Object> data : table.asMaps(String.class, String.class)) {
            cpfComRestricao = (String) data.get("CPF");
            response = request.when().log().all().get("/api/v1/restricoes/" + cpfComRestricao);
        }
    }
    /** Método é usado para todas as classes*/
    @Então("^recebo um HTTP Status (.*) como retorno$")
    public void retornarStatusCode(int statusCode) {
        response.then().log().all().statusCode(statusCode);
    }

    @E("^a mensagem \"(.*)\"$")
    public void retornarMensagem(String message) {
        response.then().log().all().body("mensagem", is(message));
    }
}
