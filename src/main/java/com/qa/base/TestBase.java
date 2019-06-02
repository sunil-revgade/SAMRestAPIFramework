package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class TestBase {

	public static Properties prop;
	public int RESPONSE_CODE_200 = 200;
	public int RESPONSE_CODE_400 = 400;
	public int RESPONSE_CODE_201 = 201;
	public int RESPONSE_CODE_404 = 404;
	public int RESPONSE_CODE_500 = 500;

	public TestBase()
	{
		try{
			prop = new Properties();
			FileInputStream fp = new FileInputStream("C:\\Users\\Sunil\\workspace\\RestAPIFramework\\src\\main\\java\\com\\qa\\configs\\config.properties");
			prop.load(fp);
		}
		catch(FileNotFoundException e)
		{
			e.getMessage();
		}
		catch(IOException e)
		{
			e.getMessage();
		}
	}
}
