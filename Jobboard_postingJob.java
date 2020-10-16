package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Jobboard_postingJob {
	WebDriver driver;
    WebDriverWait wait;
    @Given("^when user launches jobs site for job posting$")
	public void launch() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\GaminiNagaSaiGayathr\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://alchemy.hguy.co/jobs/");
        
	}
	@When("^user go to post a job page$")
	public void jobpposting()
	{
		driver.findElement(By.xpath("//ul[@id='primary-menu']/li[3]/a")).click();
		
	}
	@And("^fill details \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" \"(.*)\" and submit$")
	public void filldetails(String gmail,String title,String location,String decs,String url,String company) {
		driver.findElement(By.id("create_account_email")).sendKeys(gmail);
		driver.findElement(By.id("job_title")).sendKeys(title);
		driver.findElement(By.id("job_location")).sendKeys(location);
		driver.findElement(By.id("job_description_ifr")).sendKeys(decs);
		driver.findElement(By.id("application")).sendKeys(url);
		driver.findElement(By.id("company_name")).sendKeys(company);
		driver.findElement(By.xpath("//input[@value='Preview']")).click();
		driver.findElement(By.id("job_preview_submit_button")).click();
		
		
	}
	@And("^verify the posted job$")
	public void verifyJob()
	{
		driver.findElement(By.xpath("//ul[@id='primary-menu']/li[1]/a")).click();
		driver.findElement(By.id("search_keywords")).sendKeys("Automation Test Specialist");
		driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.linkText("Load more listings")));
		driver.findElement(By.xpath("//a[@class='load_more_jobs']")).click();
		Boolean present=driver.findElement(By.xpath("//h3[text()='Automation test Specialist']")).isDisplayed();
		System.out.println("value is"+present);
		Assert.assertTrue(present);
		
	}
	
	
}
