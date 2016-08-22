package cucumberClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PrepareReport {
    
    public WebDriver driver;
    public By Administrator = By.xpath("//*[@id='Menu']/li[4]/span");
    
    
    @Test(priority=1)
    @Given("^Open Firefox and Start Applicatoin$")
    public void Open_Firefox_and_Start_Applicatoin() throws Throwable {
       
         driver = new FirefoxDriver();     
         driver.get("http://sesden794:8990");
         Runtime.getRuntime().exec("C:\\Users\\A215776\\Desktop\\WindowAuthen.exe");
     }

    @Test(priority=2)
    @Given("^Go to Adminstrator Module$")
    public void Go_to_Adminstrator_Module() throws Throwable {
        
        WebElement Admin = driver.findElement(Administrator);
        Actions action = new Actions(driver);
        action.moveToElement(Admin).click().build().perform();
       
    }
    
    @Test(priority=3)
    @When("^Go to Prepare Report Menu$")
    public void Go_to_Prepare_Report_Menu() throws Throwable {
       
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Actions action = new Actions(driver);
        WebElement Mainmenu = driver.findElement(By.xpath("//a[text()='Prepare Report']"));
        action.moveToElement(Mainmenu).perform();
        
        
    }
    
    @Test(priority=4)
    @When("^Go to Prepare Reports Submenu$")
    public void Go_to_Prepare_Reports_Submenu() throws Throwable {
        
         Actions action = new Actions(driver);
         WebElement Submenu = driver.findElement(By.xpath("//ul[li[ul[li[a[text()='Prepare Report']]]//a[text()='Prepare Report']]]//a[text()='Prepare Reports']"));
         action.moveToElement(Submenu).perform();  
         action.clickAndHold(Submenu);
         action.click().build().perform();
    }
    
    @Test(priority=5)
    @When("^Add Prepare Report$")
    public void Add_Prepare_Report() throws Throwable {
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[text()='Add']")).click();
        
        
        driver.findElement(By.id("Id")).sendKeys("Test123");
        WebElement DocId=driver.findElement(By.id("DocumentType"));
        Select se=new Select(DocId);
        se.selectByIndex(1);
        
        WebElement Printsystem=driver.findElement(By.xpath("//div[@id='EditReportPopupBox']/table/tbody/tr[3]/td[2]/select[@class='TextBox_Standard']"));
        Select se1=new Select(Printsystem);
        se1.selectByIndex(1);
        
        WebElement ALMP=driver.findElement(By.xpath("//div[@id='EditReportPopupBox']/table/tbody/tr[4]/td[2]/select[@class='TextBox_Standard']"));
        Select SALMP=new Select(ALMP);
        SALMP.selectByIndex(4);
        
        WebElement ALPC=driver.findElement(By.xpath("//div[@id='EditReportPopupBox']/table/tbody/tr[5]/td[2]/select[@class='TextBox_Standard']"));
        Select SALPC=new Select(ALPC);
        SALPC.selectByIndex(4);
        
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id='EditWindow']/div[2]/button[1]")).click();
    }
    
    @Test(priority=6)
    @Then("^Saving Prepare Report$")
    public void Saving_Prepare_Report() throws Throwable {
        
        String Actual = driver.getTitle();
        System.out.println(Actual);
        
        
        System.out.println("Prepare Report Created successfully");
    }


}
