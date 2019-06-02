
package com.qa.apitest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;

public class PutAPITest extends TestBase{
	
	TestBase testBase;
	String serviceURL;
	String apiURL;
	String url;
	RestClient restClient;
	CloseableHttpResponse httpResponse ;
	
	@BeforeMethod
	public void setUp()
	{
		testBase = new TestBase();
		serviceURL = prop.getProperty("url");
		apiURL = prop.getProperty("putserviceURL");
		
		url = serviceURL + apiURL;
		
	}
	
	@Test
	public void putAPITest() throws JsonGenerationException, JsonMappingException, IOException, JSONException
	{
		restClient = new RestClient();
		HashMap<String, String> headerMap = new HashMap<String, String>();
		headerMap.put("Content-Type", "application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		Users users = new Users("Janet","HeadDeprt");
		mapper.writeValue(new File("C:\\Users\\Sunil\\workspace\\RestAPIFramework\\src\\main\\java\\com\\qa\\data\\users.json"), users);
	
		//
		String userJSONVal = mapper.writeValueAsString(users);
		
		
		System.out.println(userJSONVal);

		httpResponse = restClient.put(url, userJSONVal, headerMap);
		
		int status = httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code ======>"+status);
		
		String respString = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
		JSONObject obj = new JSONObject(respString);
		System.out.println("Response got =====> "+obj);
		 
		Users userRespObj = mapper.readValue(respString, Users.class);
		 System.out.println(userRespObj);
		 
	}

}
