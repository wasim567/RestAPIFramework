package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	public static RequestSpecification reqs;
	public RequestSpecification requestSpecification() throws IOException {
		if(reqs==null) {
			PrintStream log=new PrintStream(new FileOutputStream("log.txt"));
		reqs=new RequestSpecBuilder().setBaseUri(globalData("baseUri")).addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log)).addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
	   return reqs;
		}
		return reqs;
		
		
	}
	
	
	public String globalData(String baseUri) throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//Resources//global.properties");
		prop.load(fis);
		return prop.getProperty("baseUri");
	}
	
	public String getPath(Response resource, String key) {
	String res=resource.asString();
	JsonPath Js=new JsonPath(res);
	return Js.getString(key);
	}

}
