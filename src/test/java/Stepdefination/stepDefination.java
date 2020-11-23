package Stepdefination;



import org.junit.runner.RunWith;

import Resources.AddResource;
import Resources.Testdata;
import Resources.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.junit.Assert.*;

import java.util.HashMap;

import static io.restassured.RestAssured.*;


public class stepDefination extends Utils {
	
	
	RequestSpecification reqspec;
	ResponseSpecification resspec;
 Response resp;
String dess;
static String placeId;
	Testdata td=new Testdata();
	

	    @Given("^Add Place Payload with \"([^\"]*)\"  \"([^\"]*)\" \"([^\"]*)\"$")
	    public void add_place_payload_with_something_something_something(String name, String language, String address) throws Throwable {
	    reqspec=given().spec(requestSpecification()).body(td.Addplace(name, language, address));
	    	
	    }

	   

	    @When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
	    public void user_calls_something_with_something_http_request(String resource, String method) throws Throwable {
	          AddResource resourceAPI= AddResource.valueOf(resource);
	          
	        System.out.println(resourceAPI.getResource());
	    //	resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	        if(method.equalsIgnoreCase("POST")) {
	        resp=reqspec.when().post(resourceAPI.getResource());
	      
	        }
	        else if(method.equalsIgnoreCase("GET")) {
	        	resp=reqspec.when().get(resourceAPI.getResource());
	        	  
	        }
	    	
	    
	    	
	    }

	    @Then("the API call got success with status code {int}")
	    public void the_api_call_got_success_with_status_code(Integer remo) throws Throwable {
	    	
	      assertEquals(resp.getStatusCode(),200);
	    }

	   
		@And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	    public void something_in_response_body_is_something(String key, String expectedvalue) throws Throwable {
	       assertEquals(getPath(resp, key), expectedvalue);
			
	    }

	   @And("^verify place_Id created maps to \"([^\"]*)\" using \"([^\"]*)\"$")
	    public void verify_placeid_created_maps_to_something_using_something(String name, String resource) throws Throwable {
	          placeId=getPath(resp, "place_id");
	          System.out.println(placeId);
	        reqspec=given().spec(requestSpecification()).queryParam("place_id", placeId);
	        user_calls_something_with_something_http_request(resource, "GET");
	        String actualname=getPath(resp, "name");
	        assertEquals(actualname, name);
	        System.out.println(actualname);
	        
	    }


	    @Given("^DeletePlace Payload$")
	    public void deleteplace_payload() throws Throwable {
	    	//System.out.println(placeId);
	    	
	    	HashMap<String, Object> hs=new HashMap<String, Object>();
	    	hs.put("place_id", "123456789");
	    	System.out.println(hs.get(0));
	        reqspec=given().spec(requestSpecification()).body(hs);
	        		
	    }

	}


