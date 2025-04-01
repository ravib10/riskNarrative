package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber-reports/cucumber.json",
                "pretty", "html:target/positive/cucumber.html"},
        features = "src/test/java/features",
        glue = "steps",
        tags = "@test2"
)

public class Test {

}


