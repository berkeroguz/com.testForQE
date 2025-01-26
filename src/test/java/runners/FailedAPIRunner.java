package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"json:target/reports/parallel-web.json", "pretty","html:target/reports/parallel-web.html"},
        features = "@src/test/resources/failedscenarios/api_failed_scenarios.txt",
        glue="steps/APISteps",
        monochrome = true,
        dryRun = false,
        tags= "@Test"
)
public class FailedAPIRunner extends AbstractTestNGCucumberTests {

}
