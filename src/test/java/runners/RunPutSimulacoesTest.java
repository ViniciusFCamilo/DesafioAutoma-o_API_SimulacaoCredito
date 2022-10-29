package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import support.Utils;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/reports/putSimulacoes.html",
        features = "src/test/resources/features/putSimulacoes.feature",
        tags = "@teste",
        glue = {"steps"}
)

public class RunPutSimulacoesTest extends Utils {
    @BeforeClass
    public static void start() {pegarRequest();}
}
