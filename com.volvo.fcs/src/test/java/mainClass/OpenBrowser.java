package mainClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OpenBrowser {
  
    
   public WebDriver driver;
   public By Administrator = By.xpath("//*[@id='Menu']/li[4]/span");
    
    @BeforeClass
    public void BrowserOpen() throws IOException, InterruptedException
    {
            driver = new FirefoxDriver();
            driver.get("http://sesden794:8990");
            Runtime.getRuntime().exec("C:\\Users\\A215776\\Desktop\\WindowAuthen.exe");
            System.out.println("Browser Opened");
    }  
       
    @AfterClass
    public void BrowserClose() throws IOException, InterruptedException     {  
        
             driver.quit();
             System.out.println("Browser Closed");              
    }  
    
    @Test()
    public void AdministratorTab() {
        
            //driver.manage().window().maximize();
            System.out.println("Welcome to Factory Control System");
            //Go to Administration Tab
            WebElement Admin = driver.findElement(Administrator);
            Actions action = new Actions(driver);
            action.moveToElement(Admin).click().build().perform();       
            System.out.println("Clicked on Adminstrator Tab");      
              
    }    
}
