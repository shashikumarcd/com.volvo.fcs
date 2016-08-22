package testNGClass;


import java.io.IOException;

import mainClass.OpenBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PrepareEquipment extends OpenBrowser{
  
             
    public By Administrator = By.xpath("//*[@id='Menu']/li[4]/span");
    
    public By PrepareEquipment = By.xpath("//*[@id='Menu']/li[4]/ul/li[1]/a");
    public By AddEquipmentButton = By.id("addEquipmentButton");
    public By EquipmentName = By.id("equipmentName");
    public By GlobalIdentifier = By.id("newGlobalIdentifier");
    public By SaveButton = By.xpath("//*[@id='equipmentButtonsDiv']/button[1]");
    public By SelectEquipment = By.xpath("//*[@id='equipmentTreeBox']/div/div/table/tbody/tr[502]/td/span[3]");
    public By DeleteEquipment = By.xpath("//*[@id='equipmentButtonsDiv']/button[2]");
     
          
            
    @Test
    public void PrepareEquipmentPage() throws IOException {
            driver.findElement(PrepareEquipment).click();
            System.out.println("Clicked on Prepare Equipment");
                
    }
    
    @Test (dependsOnMethods = "PrepareEquipmentPage") 
    public void ClickingAddEquipmentButton() throws IOException {
             WebDriverWait wait = new WebDriverWait(driver, 10);
             wait.until(ExpectedConditions.elementToBeClickable(By.id("addEquipmentButton")));    
             driver.findElement(AddEquipmentButton).click();
             System.out.println("Add Button Clicked");
                
    }
    
    @Test (dependsOnMethods = "ClickingAddEquipmentButton") 
    public void EquipmentDetails() throws IOException {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("equipmentName")));
            driver.findElement(EquipmentName).sendKeys("ShashiTest");            
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("newGlobalIdentifier")));
            driver.findElement(GlobalIdentifier).sendKeys("ShashiTest123");
            System.out.println("Equipment details passed");
                
    }
    
    @Test (dependsOnMethods = "EquipmentDetails") 
    public void SaveEquipment() throws IOException {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='equipmentButtonsDiv']/button[1]")));
            driver.findElement(SaveButton).click();
            System.out.println("page title = "+driver.getTitle());
            System.out.println("Data saved Successfully");
                        
    }
    
    @Test (dependsOnMethods="SaveEquipment")  
    public void DeleteEquipment() throws IOException, InterruptedException {
            System.out.println("you are in delete method");
            WebDriverWait wait = new WebDriverWait(driver, 20);                      
            WebElement select = driver.findElement(EquipmentName);
                if(select.equals(SelectEquipment)) {
                    
                    System.out.println("welcome to deletion");
                    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='equipmentTreeBox']/div/div/table/tbody/tr[502]/td/span[3]")));
                    driver.navigate().refresh();                   
                    driver.findElement(SelectEquipment).click();                 
                
                }  
                else {
                    
                    System.out.println("Failed to identify Element");
                }
                     
               wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='equipmentButtonsDiv']/button[2]")));
               driver.findElement(DeleteEquipment).click();
               System.out.println("Do you want to delete records 'Yes' or 'No' ");                  
               driver.switchTo().alert().accept(); 
               System.out.println("Record Deleted");      
      
   }   

}


