package steps;

import io.cucumber.java.pt.E;
import static steps.PostSimulacoesSteps.*;

public class GetSimulacoesSteps {

    @E("^envio uma requisição do tipo GET passando o CPF da simulacao criada anteriormente$")
    public void enviarRequisicaoGetParaUmaSimulacao(){
        response = request.when().log().all().get("/api/v1/simulacoes/"+ cpf);
    }
    @E("^envio uma requisição do tipo GET passando o CPF da simulação que foi deletada$")
    public void enviarRequisicaoGetParaUmaSimulacaoErrada(){
        response = request.when().log().all().get("/api/v1/simulacoes/"+ cpf);
    }
    @E("^envio uma requisição do tipo GET$")
    public void enviarRequisicaoGetParaTodasAsSimulacoes(){
        response = request.when().log().all().get("/api/v1/simulacoes");
    }
    }
