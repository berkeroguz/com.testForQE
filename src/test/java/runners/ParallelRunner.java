package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {"json:target/reports/parallel-web.json", "pretty","html:target/reports/parallel-web.html"},
        features = "src/test/resources/Features",
        glue="steps/WebSteps",
        monochrome = true,
        dryRun = false,
        tags= "@Regression"
)
public class ParallelRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
