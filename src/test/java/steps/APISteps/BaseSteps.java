package steps.APISteps;

import io.cucumber.java.en.Given;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import operations.APIMethods;
import org.json.JSONObject;
import org.testng.Assert;
import utils.GeneralVariables;
import utils.Log;

import static io.restassured.RestAssured.given;
import static steps.APISteps.Hooks.baseSpec;

public class BaseSteps{

    public static Response response;
    JSONObject requestBody = new JSONObject();
    JsonPath jsonPath;
    String pathParam;

    @Given("Endpointin path parametresini olarak {string} ayarla")
    public void endpointin_path_parametresini_olarak_ayarla(String givenPath) {
        pathParam = APIMethods.preparePathParameters(givenPath);
        Log.info("path = > " + pathParam);
    }
    @Given("{string} method ile response kaydet")
    public void method_ile_response_kaydet(String method) {
        switch (method){
            case "GET":
                response = APIMethods.getRequest(pathParam);
                Log.info(method + " isteği başarılı bir şekilde atıldı !");
                break;
            case "POST":
                response= APIMethods.postRequestWithBody(pathParam,requestBody.toString());
        }

    }
    @Given("Statu kod {string} oldugunu dogrula")
    public void statu_kod_oldugunu_dogrula(String kod) {
        Assert.assertEquals(Integer.parseInt(kod), response.getStatusCode(), "Status code eslesmiyor..");
        Log.info("Statüs kod " + kod + " olarak dogrulandi !");
    }

    @Given("Sender accountId olarak {string} id kullan")
    public void sender_account_ıd_olarak_id_kullan(String sender) {
        requestBody.put("sender_account_id",sender);
    }
    @Given("Receiver accountId olarak {string} id kullan")
    public void receiver_account_ıd_olarak_id_kullan(String receiver) {
        requestBody.put("receiver_account_id",receiver);
    }
    @Given("Amount olarak {string} degerini kullan")
    public void amount_olarak_degerini_kullan(String amount) {
        requestBody.put("amount",amount);
    }
    @Given("ClientId olarak {string} degerini kullan")
    public void clientId_olarak_degerini_kullan(String clientId) {
        requestBody.put("client_id",clientId);
    }

}
