package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
	WebDriver driver;

		public homePage(WebDriver driver) {
			this.driver=driver;
		}
		
		// Locator for cookie popup
		// ideally not selected by actual text
		By LinkText = By.linkText("Sutinku");
		
		//Locator for submit button
		By SubmitButton = By.id("business_financing_leasing_B_100011_xy6slp");
		
		// Click submit button
		public void clickSubmit() {
			driver.findElement(SubmitButton).click();
		}
		
		// Accept cookies
		public void acceptCookie() {
			driver.findElement(LinkText).click();
		}
		
		// Locator for calculator input Automobilio kaina
		By sum = By.id("f-summa");
		//By iFrame = By.id("calculator-frame-06");
		By button = By.id("f-summa");
		public void enterSum() {
			driver.switchTo().frame("calculator-frame-06");
			driver.findElement(sum).sendKeys("20000");
			driver.findElement(By.xpath("//button[text()= 'Skaičiuoti']")).click();
		}
		
		// Locator for calculator input Palūkanos
		By perc = By.id("f-likme");
		public void enterPerc() {
			driver.findElement(perc).sendKeys("10");
		}

}
