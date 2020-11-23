Feature: Validating Place API's

@AddPlace @Regression
Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
	Given Add Place Payload with "<name>"  "<language>" "<address>"
	When user calls "AddPlaceAPI" with "POST" http request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
		
Examples:
	|name 	 | language |address		   |
	|AAhouse123 |  English1 |Worlds crossed center|
#	|BBhouse | Spanish  |Sea cross center  |


@DeletePlace @Regression
Scenario: Verify if Delete Place functionality is working

	Given DeletePlace Payload
	When user calls "deletePlaceAPI" with "POST" http request
	Then the API call got success with status code 200
	#And "status" in response body is "OK"
	 



	

	
	
	
	
	
	

	
	
	