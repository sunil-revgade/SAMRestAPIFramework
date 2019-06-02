package com.qa.apitest;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.Users;
import com.qa.utils.Utilities;

public class GetAPITest extends  TestBase {
	TestBase testBase;
	String serviceURL;
	String apiURL;
	String url;
	RestClient restClien;
	CloseableHttpResponse httpResponse ;
	
	@BeforeMethod
	public void setUp()
	{
		testBase = new TestBase();
		serviceURL = prop.getProperty("url");
		apiURL = prop.getProperty("serviceURL");
		
		url = serviceURL + apiURL;
		
	}

	
	@Test(priority=1,enabled = true)
	public void getAPITestWithoutHeader() throws ClientProtocolException, IOException, JSONException, ParseException
	{
		System.out.println("Executing Without Headers");
		restClien = new RestClient();
		httpResponse = restClien.get(url);
		
		
		int status = httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code =======> "+status);
		Assert.assertEquals(status, RESPONSE_CODE_200, "Assertion PASS");
		
		String respString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		
		JSONObject respJSON = new JSONObject(respString);
		System.out.println("JSON Resp =======> "+respJSON);
		
		String a = Utilities.getValueByNode(respJSON).toString();
		System.out.println("Values : "+a);
        
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("C:\\Users\\Sunil\\workspace\\RestAPIFramework\\src\\main\\java\\com\\qa\\data\\users.json"), a);
	
        /*
		String perPageVal = Utilities.getValueByJSONPath(respJSON, "/per_page");
		System.out.println("JSONObject Values : "+perPageVal);
		//Assert.assertEquals(Integer.parseInt(perPageVal), 3);
			
		String tzotal = Utilities.getValueByJSONPath(respJSON, "/total");
		System.out.println("JSONObject Values for Total  : "+total);
		Assert.assertEquals(Integer.parseInt(total), 12);*/
		
		//JSON Array
		/*String lastname = Utilities.getValueByJSONPath(respJSON, "/data[0]/last_name");
		String id = Utilities.getValueByJSONPath(respJSON, "/data[0]/id");
		String avatar = Utilities.getValueByJSONPath(respJSON, "/data[0]/avatar");
		String firstname = Utilities.getValueByJSONPath(respJSON, "/data[0]/first_name");
		
		System.out.println(lastname);
		System.out.println(id);
		System.out.println(avatar);
		System.out.println(firstname);*/
				
		Header[] headerArray = httpResponse.getAllHeaders();
		
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		
		for(Header header:headerArray)
		{
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("All Headers are : "+allHeaders);
	}

	@Test(priority=2,enabled=false)
	public void getAPITestWithHeader() throws ClientProtocolException, IOException, JSONException
	{
		System.out.println("Executing With Headers");
		restClien = new RestClient();
		HashMap<String, String> headermMap = new HashMap<String, String>();
		headermMap.put("Content-Type", "application/json");
		httpResponse = restClien.get(url,headermMap);
		
		
		int status = httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code =======> "+status);
		Assert.assertEquals(status, RESPONSE_CODE_200, "Assertion PASS");
		
		String respString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		
		JSONObject respJSON = new JSONObject(respString);
		System.out.println("JSON Resp =======> "+respJSON);
		
		String perPageVal = Utilities.getValueByJSONPath(respJSON, "/per_page");
		System.out.println("JSONObject Values : "+perPageVal);
		Assert.assertEquals(Integer.parseInt(perPageVal), 3);
			
		String total = Utilities.getValueByJSONPath(respJSON, "/total");
		System.out.println("JSONObject Values for Total  : "+total);
		Assert.assertEquals(Integer.parseInt(total), 12);
		
		//JSON Array
		String lastname = Utilities.getValueByJSONPath(respJSON, "/data[0]/last_name");
		String id = Utilities.getValueByJSONPath(respJSON, "/data[0]/id");
		String avatar = Utilities.getValueByJSONPath(respJSON, "/data[0]/avatar");
		String firstname = Utilities.getValueByJSONPath(respJSON, "/data[0]/first_name");
		
		System.out.println(lastname);
		System.out.println(id);
		System.out.println(avatar);
		System.out.println(firstname);
				
		Header[] headerArray = httpResponse.getAllHeaders();
		
		HashMap<String, String> allHeaders = new HashMap<String, String>();
		
		for(Header header:headerArray)
		{
			allHeaders.put(header.getName(), header.getValue());
		}
		System.out.println("All Headers are : "+allHeaders);
	}

}
