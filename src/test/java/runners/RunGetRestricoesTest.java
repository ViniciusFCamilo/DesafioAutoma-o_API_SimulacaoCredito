package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import support.Utils;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/reports/getRestricoes.html",
        features = "src/test/resources/features/getRestricoes.feature",
        tags = "@teste",
        glue = {"steps"}
)

public class RunGetRestricoesTest extends Utils {
    @BeforeClass
    public static void start() {
        pegarRequest();
    }
}
