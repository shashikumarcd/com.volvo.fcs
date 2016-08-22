package testNGClass;

import mainClass.OpenBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ManagementAlarms extends OpenBrowser {
    
    
 public By management = By.xpath("//*[@id='Menu']/li[3]/span");
 
 @Test
  public void ManagementTab()
  {
      System.out.println("Welcome to Factory Control System");
      WebElement Admin = driver.findElement(management);
      Actions action = new Actions(driver);
      action.moveToElement(Admin).click().build().perform();
      System.out.println("Clicked on Management Tab");
      
  }
  
 @Test(dependsOnMethods="ManagementTab")
  public void AlarmPage() {
      
    
      Actions action = new Actions(driver);
      WebElement Mainmenu = driver.findElement(By.xpath("//a[text()='Lock / Unlock']"));
      action.moveToElement(Mainmenu).perform();
      
     WebElement Submenu = driver.findElement(By.xpath("//ul[li[ul[li[a[text()='Lock / Unlock']]]//a[text()='Lock / Unlock']]]//a[text()='Product Unit']"));
     // WebElement Submenu = driver.findElement(By.xpath("//*[text()='Product Unit']"));
    action.moveToElement(Submenu).perform();  
    action.clickAndHold(Submenu);
    action.click().build().perform();
     
      
      // driver.findElement(By.xpath("//a[@href='/OrderAlarm']")).click();
      
      
      
  }
}
