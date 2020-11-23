package Stepdefination;

import io.cucumber.java.Before;

public class Hooks{

	
	@Before("@DeletePlace")
	
		public void deleteAPI() throws Throwable {
		stepDefination sp=new stepDefination();
		if(sp.placeId==null){
			
			sp.add_place_payload_with_something_something_something("Wasim", "demp", "Ndl");
			sp. user_calls_something_with_something_http_request("AddPlaceAPI", "POST");
			 sp.the_api_call_got_success_with_status_code(200);
			sp. something_in_response_body_is_something("status", "OK");
			sp. verify_placeid_created_maps_to_something_using_something("Wasim", "DeletePlaceAPI");
			 
		}
	}
	
	
}
