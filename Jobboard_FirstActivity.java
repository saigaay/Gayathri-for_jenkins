package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Jobboard_FirstActivity {
	 WebDriver driver;
	    WebDriverWait wait;

		@Given("^when user launches page$")
		public void launch() {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\GaminiNagaSaiGayathr\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
	        driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, 10);
	        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
	        
		}
		@When("^user enters \"(.*)\" and \"(.*)\"$")
		public void login(String username, String password)
		{
			driver.findElement(By.id("user_login")).sendKeys(username);
			driver.findElement(By.id("user_pass")).sendKeys(password);
			driver.findElement(By.id("wp-submit")).click();
			
		}
		@Then("^add new user$")
		public void addnewuser()
		{
			driver.findElement(By.xpath("//li[@id='menu-users']/a")).click();
			driver.findElement(By.xpath("//div[@id='wpbody-content']/div[4]/a")).click();
			
			// fill in the details
			driver.findElement(By.id("user_login")).sendKeys("testsample1239912");
			driver.findElement(By.id("email")).sendKeys("testsample1239912@gmail.com");
			driver.findElement(By.id("first_name")).sendKeys("12391");
			driver.findElement(By.id("last_name")).sendKeys("test1239");
			driver.findElement(By.id("url")).sendKeys("sampleurl");
			
			driver.findElement(By.xpath("//button[@class='button wp-generate-pw hide-if-no-js']")).click();
			driver.findElement(By.xpath("//span[./text()='Hide']")).click();
			
//			driver.findElement(By.id("pass1")).clear();
//			driver.findElement(By.id("pass1")).sendKeys("goodlifeisahat");			
			driver.findElement(By.id("createusersub")).click();
			
			
			// searching for the user
			driver.findElement(By.id("user-search-input")).sendKeys("testsample1239912");
			driver.findElement(By.id("search-submit")).click();			
			
			Boolean present=driver.findElement(By.xpath("//a[./text()='testsample1239912']")).isDisplayed();	
			System.out.println("value is"+present);
			Assert.assertTrue(present);
		}
		 
}
