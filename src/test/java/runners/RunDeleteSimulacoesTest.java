package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import support.Utils;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/reports/deleteSimulacoes.html",
        features = "src/test/resources/features/deleteSimulacoes.feature",
        tags = "@teste",
        glue = {"steps"}
)

public class RunDeleteSimulacoesTest extends Utils {
    @BeforeClass
    public static void start() {pegarRequest();
    }
}
