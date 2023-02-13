package testCases;

import org.testng.annotations.BeforeTest;  
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterTest;  

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.homePage;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import java.time.Duration;

public class demoTest {
	public String baseUrl = "https://www.seb.lt/eng/private/calculator-leasing";
	public WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driver=new ChromeDriver();
	}
	
	@Test(priority = 0)
	public void verifyTitle() {
		System.setProperty("webdriver.chrome.driver", "C:\\Projects_lauri\\chromeDriver\\chromedriver.exe");
		//Initiating  chromedriver
		
		// opening browser with the url mentioned above
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		homePage home = new homePage(driver);
		// accepting the cookies
		// ideally this should be done so that browser starts without any cookie popups
		// or done in set up before any test is being run
		home.acceptCookie();
		// clicking on the submit button
		home.clickSubmit();
		
		// Getting the page title just for confirmation
		 String title = driver.getTitle();
		 assertEquals("Lizingas verslui | SEB", title);
		 
		System.out.println("Actual title is: " + driver.getTitle());
		System.out.println("Expected title is: Lizingas verslui | SEB");
		
		// Validating that the current page contains specific string
		 String pageUrl = driver.getCurrentUrl();
		 assertThat(pageUrl, containsString("appform_business_leasing"));
		
		System.out.println("Heading is: " + driver.getCurrentUrl());
	}
	
	@Test(priority = 1)
	public void verifyCalculator() {
		System.setProperty("webdriver.chrome.driver", "C:\\Projects_lauri\\chromeDriver\\chromedriver.exe");
		
		driver.get(baseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		homePage home = new homePage(driver);
		
		 String title = driver.getTitle();
		 assertEquals("Lizingas verslui | SEB", title);
		 home.enterSum();
		
		 // This should be in page objects file ideally
		 // Checking that the calculator works by validating a calculator result is not empty
		String calcResult = driver.findElement(By.cssSelector("[data-name='monthly_payment']")).getText();
		Assert.assertFalse(calcResult.isEmpty());

	}
	
	@AfterTest
	public void endSession() {
		//closing the browser
		driver.close();
	}
}
