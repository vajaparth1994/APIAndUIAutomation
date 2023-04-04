package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;

public class APIStepDefinitions {

    Response response;
    @Given("User connects to user API")
    public void userConnectsToUserAPI() {
        JSONObject obj=new JSONObject();
        obj.put("email","demo@gmail.com");
        obj.put("password","Demo@123");
        obj.put("storeUUID","ced48917-54c2-40ad-a646-5315f5dcb28f");
        obj.put("locale","en-GB");
        JSONObject profile = new JSONObject();
        profile.put("firstName", "Demo");
        profile.put("phone", "+44 1234 565456");
        profile.put("birthDate", "2002-11-19");
        obj.put("profile", profile);
        JSONArray arr = new JSONArray();
        arr.add("marketing");
        obj.put("subscriptions", arr);
        //System.out.println(obj);

        response = RestAssured.given()
                .baseUri("https://vmos2.vmos-demo.com/user/v1")
                .contentType(ContentType.JSON)
                .body(obj).
                when().
                post("/user");
    }

    @Then("User should get response code of {int}")
    public void userShouldGetResponseCodeOf(int responseCode) {
        Assert.assertEquals(responseCode,response.getStatusCode());
    }

    @Given("User connects to Auth API")
    public void userConnectsToAuthAPI() {
        JSONObject obj=new JSONObject();
        obj.put("email","demo@gmail.com");
        obj.put("password","Demo@123");

        response = RestAssured.given()
                .baseUri("https://vmos2.vmos-demo.com/user/v1")
                .contentType(ContentType.JSON)
                .body(obj)
                .when()
                .post("/auth");
    }
}
