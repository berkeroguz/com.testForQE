package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features",
        glue="steps",
        monochrome = true,
        dryRun = false,
        tags= "@Test"
)
public class Runner extends AbstractTestNGCucumberTests {

}
