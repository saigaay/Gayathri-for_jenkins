package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import junit.framework.Assert;

public class HRM_activities {
	WebDriver driver;
    WebDriverWait wait;

	@Given("^when user launches HRM site and login$")
	public void launch() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\GaminiNagaSaiGayathr\\Downloads\\geckodriver-v0.27.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://alchemy.hguy.co:8080/orangehrm/symfony/web/index.php/auth/login");
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();
        
	}
	@When("^user search for vacancies and create one$")
	public void createvacancy()
	{
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
		driver.findElement(By.id("btnAdd")).click();
		
		Select jobTitle = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
    	jobTitle.selectByVisibleText("Java Developer");
    	driver.findElement(By.id("addJobVacancy_name")).sendKeys("Senior Java Architect-Test");
    	driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys("demo user");
    	driver.findElement(By.id("btnSave")).click();
    	driver.findElement(By.id("btnBack")).click();
    	
		
    	jobTitle = new Select(driver.findElement(By.id("vacancySearch_jobTitle")));
    	jobTitle.selectByVisibleText("Java Developer");
    	driver.findElement(By.id("btnSrch")).click();
    	Boolean present=driver.findElement(By.xpath("//a[text()='Senior Java Architect-Test']")).isDisplayed();
    	Assert.assertTrue(present);
    	
	}
	
	@When("^user add candidate and verify$")
	public void addcandidate()
	{
//		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		driver.findElement(By.xpath("//b[text()='Recruitment']")).click();
		
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("addCandidate_firstName")).sendKeys("test_first");
		driver.findElement(By.id("addCandidate_lastName")).sendKeys("test-last");
		driver.findElement(By.id("addCandidate_email")).sendKeys("sample@gmail.com");
		driver.findElement(By.id("addCandidate_resume")).sendKeys("C:\\Users\\GaminiNagaSaiGayathr\\Desktop\\resume\\Test-resume.docx");
		driver.findElement(By.id("btnSave")).click();
		driver.findElement(By.id("btnBack")).click();
		
		Boolean present1=driver.findElement(By.xpath("//a[text()='test_first  test-last']")).isDisplayed();
    	Assert.assertTrue(present1);
		
	}
	
	@When("^user add multiple employees with \"(.*)\" \"(.*)\" \"(.*)\"$")
	public void multipleEmployees(String firstname, String lastname,String username) throws InterruptedException
	{
		
		Actions action = new Actions(driver);

		WebElement employe = driver.findElement(By.id("menu_pim_viewPimModule"));
		action.moveToElement(employe).build().perform();
		employe.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnAdd")));
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstname);
		driver.findElement(By.id("lastName")).sendKeys(lastname);
		
		Boolean selected=driver.findElement(By.id("chkLogin")).isSelected();
		if(!selected)
		{
			driver.findElement(By.id("chkLogin")).click();
		}
		
		
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("btnSave")).click();
		
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(2000);
		Boolean present=driver.findElement(By.xpath("//a[text()='"+firstname+"']")).isDisplayed();
    	Assert.assertTrue(present);
	}
	
	@When("^user creates multiple vacancies with \"(.*)\" \"(.*)\"$")
	public void multiplevaccancies(String jobtitle,String hiringmanger) {
		
		driver.findElement(By.id("menu_recruitment_viewRecruitmentModule")).click();
		driver.findElement(By.id("menu_recruitment_viewJobVacancy")).click();
		driver.findElement(By.id("btnAdd")).click();
		
		Select jobTitle = new Select(driver.findElement(By.id("addJobVacancy_jobTitle")));
    	jobTitle.selectByVisibleText("Java Developer");
    	driver.findElement(By.id("addJobVacancy_name")).sendKeys(jobtitle);
    	driver.findElement(By.id("addJobVacancy_hiringManager")).sendKeys(hiringmanger);
    	driver.findElement(By.id("btnSave")).click();
    	driver.findElement(By.id("btnBack")).click();
    	
		
    	jobTitle = new Select(driver.findElement(By.id("vacancySearch_jobTitle")));
    	jobTitle.selectByVisibleText("Java Developer");
    	driver.findElement(By.id("btnSrch")).click();
    	Boolean present=driver.findElement(By.xpath("//a[text()='"+jobtitle+"']")).isDisplayed();
    	Assert.assertTrue(present);
	}
	@Then("^close the browser$")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }
}
