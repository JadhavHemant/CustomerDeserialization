package Steps;

import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJO.CustomerAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CustomerSteps {
	RequestSpecification httpRequest;
	String postRequestBody;
	Response response;
	String d;
	static String id;
	String putRequestBody;
	String patchRequestBody;
	
@Given("user configure Base URI")
public void user_configure_base_uri() {
    RestAssured.baseURI="http://localhost:4000/customers";
  
}

@Given("user get RequestSpecification Interface object")
public void user_get_request_specification_interface_object() {
     httpRequest = RestAssured.given();
  
}

@Given("user add Request Header")
public void user_add_request_header() {
    httpRequest.header("Content-Type", "application/json");
  
}

@Given("user create request body using Serialization and Deserialization")
public void user_create_request_body_using_serialization_and_deserialization() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    FileReader file = new FileReader(System.getProperty("user.dir")+"//src//test//resources//customer.json");
    JsonNode jsonNode = mapper.readTree(file);
    CustomerAPI cust =  mapper.treeToValue(jsonNode.get("createCustomer"), CustomerAPI.class);
    postRequestBody = mapper.writeValueAsString(cust);

}

@Given("user add request body for Post request")
public void user_add_request_body_for_post_request() {
    httpRequest.body(postRequestBody);
  
}

@When("user select HTTP Post request")
public void user_select_http_post_request() {
   response = httpRequest.post();
  
}

@Then("user capture status code")
public void user_capture_status_code() {
    int a =response.statusCode();
    System.out.println(a);
  
}

@Then("user capture status line")
public void user_capture_status_line() {
	String b = response.statusLine();
	System.out.println(b);
  
}

@Then("user capture response time")
public void user_capture_response_time() {
    long c = response.time(); 
    System.out.println(c);
}

@Then("user capture response body")
public void user_capture_response_body() {
    d = response.body().asPrettyString();
    System.out.println(d);
  
}

@Then("user capture response headers")
public void user_capture_response_headers() {
    Headers allHeader = response.headers();
    for(Header abc: allHeader)
    {
    	System.out.println(abc.getName()+"::"+abc.getValue());
    }
  
}

@Then("user capture id from response body")
public void user_capture_id_from_response_body() {
    JsonPath jsonPath = new JsonPath(d);
    id = jsonPath.getString("id");
    System.out.println(id);
}


@When("user select HTTP get request")
public void user_select_http_get_request() {
   response = httpRequest.get(id);
}


@Given("user create request body Put request using Serialization and Deserialization")
public void user_create_request_body_put_request_using_serialization_and_deserialization() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    FileReader file = new FileReader(System.getProperty("user.dir")+"//src//test//resources//customer.json");
    JsonNode jsonNode = mapper.readTree(file);
    CustomerAPI cust = mapper.treeToValue(jsonNode.get("UpdateCustomer"), CustomerAPI.class);
    putRequestBody = mapper.writeValueAsString(cust);
    
}

@Given("user add request body for Put request")
public void user_add_request_body_for_put_request() {
    httpRequest.body(putRequestBody);
}

@When("user select HTTP Put request")
public void user_select_http_put_request() {
    response = httpRequest.put(id);
}

@Given("user create request body Patch request using Serialization and Deserialization")
public void user_create_request_body_patch_request_using_serialization_and_deserialization() throws IOException {
   
	ObjectMapper mapper = new ObjectMapper();
	FileReader file = new FileReader(System.getProperty("user.dir")+"//src//test//resources//customer.json");
	JsonNode jsonNode = mapper.readTree(file);
	CustomerAPI cust = mapper.treeToValue(jsonNode.get("UpdatePartialCustomer"), CustomerAPI.class);
	patchRequestBody = mapper.writeValueAsString(cust);
}
@Given("user add request body for Patch request")
public void user_add_request_body_for_patch_request() {
    httpRequest.body(patchRequestBody);
}
@When("user select HTTP Patch request")
public void user_select_http_patch_request() {
    response = httpRequest.patch(id);
}

@When("user select HTTP delete request")
public void user_select_http_delete_request() {
   response = httpRequest.delete(id);
}
}
