package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"rerun:src/test/resources/failedscenarios/api_failed_scenarios.txt","json:target/reports/parallel-web.json", "pretty","html:target/reports/parallel-web.html"},
        features = "src/test/resources/features/API",
        glue="steps/APISteps",
        monochrome = true,
        dryRun = false,
        tags= "@Test"
)
public class APIRunner extends AbstractTestNGCucumberTests {

}
