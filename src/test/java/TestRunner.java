import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/resources/feature/"},
        tags = {"@contact_us"},
        format = {"pretty", "json:target/cucumber.json", "html:target/cucumber.html"})
public class TestRunner {
}
