package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/reports/parallel-web.json", "pretty","html:target/reports/parallel-web.html"},
        features = "@src/test/resources/failedscenarios/web_failed_scenarios.txt",
        glue="steps/WebSteps",
        monochrome = true,
        dryRun = false,
        tags= "@Regression"
)
public class FailedWebRunner extends AbstractTestNGCucumberTests {

}
