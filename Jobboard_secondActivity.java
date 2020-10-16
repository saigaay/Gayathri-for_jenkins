package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Jobboard_secondActivity {
	 WebDriver driver;
	    WebDriverWait wait;

	@Given("^when user launches jobs site$")
	public void launch() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\GaminiNagaSaiGayathr\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://alchemy.hguy.co/jobs/");
        
	}
	@Then("^search and apply for job$")
	public void applyForJob() {
		driver.findElement(By.xpath("//ul[@id='primary-menu']/li[1]/a")).click();
		driver.findElement(By.id("search_keywords")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
		Boolean selected=driver.findElement(By.id("job_type_freelance")).isSelected();
		if(selected)
		{
			driver.findElement(By.id("job_type_freelance")).click();
		}
		 selected=driver.findElement(By.id("job_type_full-time")).isSelected();
		if(!selected)
		{
			driver.findElement(By.id("job_type_full-time")).click();
		}
		 selected=driver.findElement(By.id("job_type_internship")).isSelected();
		if(selected)
		{
			driver.findElement(By.id("job_type_internship")).click();
		}
		 selected=driver.findElement(By.id("job_type_part-time")).isSelected();
		if(selected)
		{
			driver.findElement(By.id("job_type_part-time")).click();
		}
		 selected=driver.findElement(By.id("job_type_temporary")).isSelected();
		if(selected)
		{
			driver.findElement(By.id("job_type_temporary")).click();
		}
		List<WebElement> jobs=driver.findElements(By.xpath("//ul[@class='job_listings']/li/a/div/h3"));
		for(WebElement title:jobs) {
			System.out.println(title.getText());
		}
		driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]/a")).click();
		driver.findElement(By.xpath("//input")).click();
		driver.findElement(By.tagName("input")).click();
		
	}
	
	
}
