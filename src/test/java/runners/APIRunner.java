package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/API",
        glue="steps/APISteps",
        monochrome = true,
        dryRun = false,
        tags= "@Test"
)
public class APIRunner extends AbstractTestNGCucumberTests {

}
