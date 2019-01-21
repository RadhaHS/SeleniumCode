package com.selenium.works;



import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.radha.utitily.Driver;

public class PHPTest01 {

	WebDriver driver; 
	String baseURL ; 
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.out.println("in before class...");
		System.setProperty(Driver.CHROME, Driver.CHROME_PATH); 
	}
	
	@Before
	public void setUp() {
		System.out.println("i'm in before ");
		driver = new ChromeDriver(); 
		baseURL = "http://php.net/"; 
		driver.get(baseURL);
		driver.manage().window().maximize(); 
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.close(); 
	}
	
	@Test
	public void phpTest() {
		// entering eval on top right search box 
		driver.findElement(By.name("pattern")).sendKeys("eval");
		
		sleep(700);
		// click the drop down of eval string
		String evalDropDownXpath ="//*[@id=\"topsearch\"]/span/span[2]/div[1]/span/div[1]/h4";
		driver.findElement(By.xpath(evalDropDownXpath)).click();
		
		System.out.println(driver.getCurrentUrl().contains("http://php.net/manual/en/function.eval.php"));
		Assert.assertTrue("URL Redirected",driver.getCurrentUrl().contains("function.eval.php") );
		
		String text ="Caution";
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
		Assert.assertTrue("Text not found!", list.size() > 0);
		
	}

	private void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
