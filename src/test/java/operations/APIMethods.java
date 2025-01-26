package operations;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import utils.Log;
import utils.PropertyUtils;

import static io.restassured.RestAssured.given;
import static steps.APISteps.Hooks.baseSpec;

public class APIMethods {
    public static String preparePathParameters(String givenPaths){
        String [] paths = givenPaths.split("/");
        StringBuilder tempPath = new StringBuilder("{");

        for ( int i =1 ; i<paths.length;i++){
            String key = "pp"+i;
            String value = paths[i].trim();
            baseSpec.pathParam(key,value);

            tempPath.append(key+"}/{");
        }
        tempPath.deleteCharAt(tempPath.lastIndexOf("{"));
        tempPath.deleteCharAt(tempPath.lastIndexOf("/"));
        return tempPath.toString();
    }

    public static JSONObject setValidUser(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", PropertyUtils.getProperty("username"));
        requestBody.put("password", PropertyUtils.getProperty("password"));
        return requestBody;
    }
    public static String generateToken (){
        Response response = given().
                contentType(ContentType.JSON).
                spec(baseSpec).
                body(setValidUser().toString())
                .post("/api/v1/login").prettyPeek();
        JsonPath jsonPath = response.jsonPath();
        Log.info("Token alındı !");
        return jsonPath.getString("access_token");
    }

    public static Response getRequest(String path){
        return given().contentType(ContentType.JSON).spec(baseSpec).get(path).prettyPeek();
    }
    public static Response postRequestWithBody(String path,Object body){
        return given().contentType(ContentType.JSON).spec(baseSpec).body(body).post(path).prettyPeek();
    }
}
