package stepDefinition;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
/**
 * Created by 1547857 on 4/24/2017.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resource/feature/",
        format = {"pretty","json:target/cucumber.json"},
        glue = {"stepDefinition"},
        tags = {"@smoke"}
)
public class testRunner {
}
