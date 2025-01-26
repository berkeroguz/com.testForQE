package steps.APISteps;

import io.cucumber.java.Before;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import operations.APIMethods;
import utils.Log;
import utils.PropertyUtils;

public class Hooks {
    public static RequestSpecification baseSpec;
    @Before
    public void setUpBaseUrl(){
        baseSpec = new RequestSpecBuilder().setBaseUri(PropertyUtils.getProperty("baseUrl")).build();
        baseSpec.header("Authorization","Bearer "+ APIMethods.generateToken());

    }
}
