package testNGClass;


import java.util.concurrent.TimeUnit;
import mainClass.OpenBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class PrepareReports extends OpenBrowser {
   
  @Test
  public void PrepareReport() throws InterruptedException  {
      
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          Actions action = new Actions(driver);
          WebElement Mainmenu = driver.findElement(By.xpath("//a[text()='Prepare Report']"));
          action.moveToElement(Mainmenu).perform();          
          WebElement Submenu = driver.findElement(By.xpath("//ul[li[ul[li[a[text()='Prepare Report']]]//a[text()='Prepare Report']]]//a[text()='Prepare Reports']"));
          action.moveToElement(Submenu).perform();  
          action.clickAndHold(Submenu);
          action.click().build().perform();                   
  }
   
  @Test(dependsOnMethods="PrepareReport")
  public void AddPrepareReports() {    
      
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          driver.findElement(By.xpath("//a[text()='Add']")).click(); 
          //Pass Report Id
          driver.findElement(By.id("Id")).sendKeys("Test123");
          //Select Documenttype
          WebElement DocId=driver.findElement(By.id("DocumentType"));
          Select se=new Select(DocId);
          se.selectByIndex(1);  
          //Select Print System
          WebElement Printsystem=driver.findElement(By.xpath("//div[@id='EditReportPopupBox']/table/tbody/tr[3]/td[2]/select[@class='TextBox_Standard']"));
          Select se1=new Select(Printsystem);
          se1.selectByIndex(1);   
          //Select Authrization Level Manual Print
          WebElement ALMP=driver.findElement(By.xpath("//div[@id='EditReportPopupBox']/table/tbody/tr[4]/td[2]/select[@class='TextBox_Standard']"));
          Select SALMP=new Select(ALMP);
          SALMP.selectByIndex(4);     
          //Select Authrization Level Print Copy
          WebElement ALPC=driver.findElement(By.xpath("//div[@id='EditReportPopupBox']/table/tbody/tr[5]/td[2]/select[@class='TextBox_Standard']"));
          Select SALPC=new Select(ALPC);
          SALPC.selectByIndex(4);     
          //Saving Report
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          driver.findElement(By.xpath("//*[@id='EditWindow']/div[2]/button[1]")).click();      
               
  }
  
  @Test(dependsOnMethods="AddPrepareReports")
  public void DeletePrepareReports() { 
      
          //Identifiying Fliter option
          driver.findElement(By.xpath("//*[@id='PrepareReportGrid']/div[2]/div/table/thead/tr/th[1]/a[1]/span[@class='k-icon k-i-arrowhead-s']")).click();
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          //Go to Filter
          Actions action = new Actions(driver);
          WebElement Mainmenu = driver.findElement(By.xpath("//span[text()='Filter']"));
          action.moveToElement(Mainmenu).perform();      
          driver.findElement(By.xpath("//form[@class='k-filter-menu']/div[1]/input[1][@class='k-textbox']")).sendKeys("Test123");
          //Filtering record
          driver.findElement(By.xpath("//form[@class='k-filter-menu']/div[1]/div/button[@class='k-button k-primary']")).click();
          //Selecting recrod
          driver.findElement(By.xpath("//*[@id='PrepareReportGrid']/div[3]/table/tbody/tr/td[1][text()='Test123']")).click();
          //Delete Record
          driver.findElement(By.id("DeleteCommand")).click();
          //Do you want to delete this report?
          driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);      
          driver.findElement(By.xpath("//div[8]/div[2]/div[2]/button[1][text()='Yes']")).click();       
          
  }  

}


