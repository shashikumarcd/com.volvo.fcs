package cucumberClassess1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PrepareReports {

    public WebDriver driver;
    public By Administrator = By.xpath("//*[@id='Menu']/li[4]/span");
    @Given("^Go to Adminstrator Module$")
    public void Go_to_Adminstrator_Module() throws Throwable {
       
        WebElement Admin = driver.findElement(Administrator);
        Actions action = new Actions(driver);
        action.moveToElement(Admin).click().build().perform();
    }

    @When("^Go to Prepare Report Menu$")
    public void Go_to_Prepare_Report_Menu() throws Throwable {
        
    }

    @When("^Go to Prepare Reports Submenu$")
    public void Go_to_Prepare_Reports_Submenu() throws Throwable {
       
    }

    @When("^Add Prepare Report$")
    public void Add_Prepare_Report() throws Throwable {
       
    }

    @Then("^Saving Prepare Report$")
    public void Saving_Prepare_Report() throws Throwable {
       
    }
}
