package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CRM_activities {
	WebDriver driver;
    WebDriverWait wait;

	@Given("^when user launches CRM site and login$")
	public void launch() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\GaminiNagaSaiGayathr\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://alchemy.hguy.co/crm/");
        driver.findElement(By.id("user_name")).sendKeys("admin");
        driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("bigbutton")).click();
        
	}
	@When("^user count the dashlets$")
	public void counting()
	{
		
				List<WebElement> dashlets=driver.findElements(By.xpath("//div[contains(@id,'dashlet_header')]/div[2]/table/tbody/tr/td/h3"));
				
				System.out.println("count of dashlets is "+dashlets.size());
		for(WebElement title:dashlets) {
			System.out.println(title.getText());
		}
	}
	
	@Then("^create leads and verify$")
	public void createleads()
	{
		Actions actions = new Actions(driver);
    	actions.moveToElement(driver.findElement(By.xpath("//a[text()='Sales']"))).build().perform();
    	driver.findElement(By.xpath("//a[text()='Leads']")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Create Lead']")));
    	driver.findElement(By.xpath("//div[text()='Create Lead']")).click();
    	
//    	Select salute = new Select(driver.findElement(By.id("salutation")));
//		salute.selectByVisibleText("Ms.");
//		
////		driver.findElement(By.name("first_name").cssSelector(cssSelector)
//		
//		driver.findElement(By.id("phone_mobile")).sendKeys("7463746384");
//		driver.findElement(By.id("SAVE")).click();
//		driver.findElement(By.id("first_name")).sendKeys("Ztestfirstname");
//		driver.findElement(By.id("last_name")).sendKeys("Ztestlastname");
		
		String inputText = "Ztestfirstname";
		WebElement myElement = driver.findElement(By.id("first_name"));
		String js = "arguments[0].setAttribute('value','"+inputText+"')";
		((JavascriptExecutor) driver).executeScript(js, myElement);
		
		String inputText1 = "Ztestfirstname";
		myElement = driver.findElement(By.id("last_name"));
		String js1 = "arguments[0].setAttribute('value','"+inputText1+"')";
		((JavascriptExecutor) driver).executeScript(js1, myElement);
		
		myElement = driver.findElement(By.id("SAVE"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", myElement);
		
		
//		driver.findElement(By.id("SAVE")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='View Leads']")));
    	driver.findElement(By.xpath("//div[text()='View Leads']")).click();
		
		List<WebElement> leads = driver.findElements(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr/td[3]/b/a"));

		for (WebElement lead : leads) {
			if (lead.getText().equals(" Ztestfirstname Ztestlastname")) {
				System.out.println("Lead found");
				break;
			}

		}
	}
	@When("^schedule meeting and verify \"(.*)\" \"(.*)\" \"(.*)\"$")
	public void schedulemeeting(String firstname,String firstname1,String firstname2) {
		Actions actions = new Actions(driver);
    	actions.moveToElement(driver.findElement(By.xpath("//a[text()='Activities']"))).build().perform();
    	driver.findElement(By.xpath("//a[text()='Meetings']")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Schedule Meeting']")));
    	driver.findElement(By.xpath("//div[text()='Schedule Meeting']")).click();
		
    	
    	String inputText = "Test_title1";
		WebElement myElement = driver.findElement(By.id("name"));
		String js = "arguments[0].setAttribute('value','"+inputText+"')";
		((JavascriptExecutor) driver).executeScript(js, myElement);
		
		
		myElement = driver.findElement(By.id("search_first_name"));
		js = "arguments[0].setAttribute('value','"+firstname+"')";
		((JavascriptExecutor) driver).executeScript(js, myElement);
		myElement = driver.findElement(By.id("invitees_search"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", myElement);
		myElement = driver.findElement(By.id("invitees_add_1"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", myElement);
		
		
		myElement = driver.findElement(By.id("search_first_name"));
		js = "arguments[0].setAttribute('value','"+firstname1+"')";		
		myElement = driver.findElement(By.id("invitees_search"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", myElement);
		myElement = driver.findElement(By.id("invitees_add_1"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", myElement);
		
		myElement = driver.findElement(By.id("search_first_name"));
		js = "arguments[0].setAttribute('value','"+firstname2+"')";
		((JavascriptExecutor) driver).executeScript(js, myElement);
		myElement = driver.findElement(By.id("invitees_search"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", myElement);
		myElement = driver.findElement(By.id("invitees_add_1"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", myElement);
		
		myElement = driver.findElement(By.id("SAVE_HEADER"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", myElement);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='View Meetings']")));
    	driver.findElement(By.xpath("//div[text()='View Meetings']")).click();
    	
    	List<WebElement> leads = driver.findElements(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr/td[4]/b/a"));

		for (WebElement lead : leads) {
			if (lead.getText().equals("Test_title1")) {
				System.out.println("Meeting found");
				break;
			}

		}
    	
	}
	
	@When("^create product using \"(.*)\" \"(.*)\" \"(.*)\" and verify$")
	public void createproduct(String product,String price,String desc) {
		Actions actions = new Actions(driver);
    	actions.moveToElement(driver.findElement(By.xpath("//a[text()='All']"))).build().perform();
    	driver.findElement(By.xpath("//a[text()='Products']")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Create Product']")));
    	driver.findElement(By.xpath("//div[text()='Create Product']")).click();
    	
    	WebElement myElement = driver.findElement(By.id("name"));
    	String js = "arguments[0].setAttribute('value','"+product+"')";
		((JavascriptExecutor) driver).executeScript(js, myElement);
		
		 myElement = driver.findElement(By.id("price"));
    	 js = "arguments[0].setAttribute('value','"+price+"')";
		((JavascriptExecutor) driver).executeScript(js, myElement);
		
		myElement = driver.findElement(By.id("description"));
   	 	js = "arguments[0].setAttribute('value','"+desc+"')";
		((JavascriptExecutor) driver).executeScript(js, myElement);
		
		myElement = driver.findElement(By.id("SAVE"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", myElement);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='View Products']")));
    	driver.findElement(By.xpath("//div[text()='View Products']")).click();
    	
    	List<WebElement> leads = driver.findElements(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr/td[4]/b/a"));

		for (WebElement lead : leads) {
			if (lead.getText().equals(product)) {
				System.out.println("Product found");
				break;
			}

		}
	}
	@Then("^quit the browser$")
	public void close() {
		driver.close();
	}
}
