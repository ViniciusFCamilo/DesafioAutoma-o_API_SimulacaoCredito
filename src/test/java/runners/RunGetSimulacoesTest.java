package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import support.Utils;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/reports/getSimulacoes.html",
        features = "src/test/resources/features/getSimulacoes.feature",
        tags = "@teste",
        glue = {"steps"}
)
public class RunGetSimulacoesTest  extends Utils {
    @BeforeClass
    public static void start() {pegarRequest();
    }
}
