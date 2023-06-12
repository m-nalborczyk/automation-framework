package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.Base_PO;
import pageObject.Login_PO;


public class Login_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    private Login_PO login_po;

    public Login_Steps (Login_PO login_po){
        this.login_po = login_po;
    }

    @Given("I access webdriver university login page")
    public void i_access_webdriver_university_login_page() {
        login_po.navigateTo_WebDriverUniversity_Login_Page();
    }
    @When("I enter a username {}")
    public void i_enter_a_username(String username) {
        login_po.setUsername(username);
    }
    @When("I enter an outlined username {}")
    public void i_enter_an_outlined_username(String username) {
        login_po.setUsername(username);
    }
    @When("I enter a password {}")
    public void i_enter_a_password(String password) {
        login_po.setPassword(password);
    }
    @When("I enter an outlined password {}")
    public void i_enter_an_outlined_password(String password) {
        login_po.setPassword(password);
    }
    @When("I click on login button")
    public void i_click_login_btn() {
        login_po.clickLoginButton();
    }
    @Then("I should be presented with a successful validation info")
    public void i_should_be_presented_with_a_successful_validation_info() {
        // Switching to the alert popup
        Alert alert = driver.switchTo().alert();
        // Getting the actual message displayed in the popup
        String actualMessage = alert.getText();
        // Closing the alert popup
        alert.accept();
        // Asserting the expected and actual messages
        Assert.assertEquals(actualMessage, "validation succeeded");
    }
    @Then("I should be presented with a unsuccessful validation info")
    public void i_should_be_presented_with_a_unsuccessful_validation_info() {
        // Switching to the alert popup
        Alert alert = driver.switchTo().alert();
        // Getting the actual message displayed in the popup
        String actualMessage = alert.getText();
        // Closing the alert popup
        alert.accept();
        // Asserting the expected and actual messages
        Assert.assertEquals(actualMessage, "validation failed");
    }
    @Then("I should be presented with a validation message {}")
    public void i_should_be_presented_with_a_validation_msg(String validationMessage) {
        // Switching to the alert popup
        Alert alert = driver.switchTo().alert();
        // Getting the actual message displayed in the popup
        String actualMessage = alert.getText();
        // Closing the alert popup
        alert.accept();
        // Asserting the expected and actual messages
        Assert.assertEquals(actualMessage, validationMessage);
    }
}
