package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONException;

public class RestClient {
	
//GET Method without Header
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException, JSONException
	{
		CloseableHttpClient httpClients = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		CloseableHttpResponse httpResponse =  httpClients.execute(httpget);
		return httpResponse;
	}
	

	//GET method with header
	public CloseableHttpResponse get(String url, HashMap<String, String> headerMap) throws ClientProtocolException, IOException, JSONException
	{
		CloseableHttpClient httpClients = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url);
		
		for(Map.Entry<String, String> entry : headerMap.entrySet() )
		{
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse httpResponse =  httpClients.execute(httpget);
		return httpResponse;
	}

	public CloseableHttpResponse post(String url, String jPaylod, HashMap<String, String> headerMap) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClients = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url);
		httppost.setEntity(new StringEntity(jPaylod));
		
		for(Map.Entry<String, String> entry : headerMap.entrySet() )
		{
			httppost.addHeader(entry.getKey(), entry.getValue());
		}
		
		CloseableHttpResponse httpResponse = httpClients.execute(httppost);
		return httpResponse;
	}
	
	public CloseableHttpResponse put(String url, String jPaylod, HashMap<String, String> headerMap) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpClients = HttpClients.createDefault();
		HttpPut httpput = new HttpPut(url);
		httpput.setEntity(new StringEntity(jPaylod));
		
		for(Map.Entry<String, String> entry : headerMap.entrySet() )
		{
			httpput.addHeader(entry.getKey(), entry.getValue());
		}
		
		CloseableHttpResponse httpResponse = httpClients.execute(httpput);
		return httpResponse;
	}
}
