package StepDefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Set;

import org.junit.Assert;

public class Apiget {
	Response rs;

	@When("user send the GET request")
	public void user_send_the_get_request() {
		rs = given().when().get("https://api.coindesk.com/v1/bpi/currentprice.json");
		int status = rs.getStatusCode();
		Assert.assertTrue(status == 200);
	}

	
	@Then("verify GBP description equals {string}")
	public void verify_gbp_description_equals(String string) {
		JsonPath js = rs.jsonPath();
		String ls = js.get("bpi.GBP.description").toString();
		// System.out.println(ls);
		Assert.assertEquals("Description mismatch", ls, "British Pound Sterling");
	}

		@Then("verify the response contains {int} BPIs  as {string} and {string} and {string}")
	public void verify_the_response_contains_bp_is_as_and_and(Integer count, String USD, String GBP, String EUR) {
		String response = rs.asString();
		JSONObject jsonObject = new JSONObject(response);
		JSONObject bpiObject = jsonObject.getJSONObject("bpi");
		Set<String> jsobj = bpiObject.keySet();
		Assert.assertEquals((jsobj.size() == count), true);
		Assert.assertEquals(jsobj.contains(USD), true);
		Assert.assertEquals(jsobj.contains(GBP), true);
		Assert.assertEquals(jsobj.contains(EUR), true); 
	}



}
