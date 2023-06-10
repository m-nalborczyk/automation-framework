package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObject.Base_PO;


public class Contact_Us_Steps extends Base_PO {

    private WebDriver driver = getDriver();


    @Given("I access webdriver university contact us page")
    public void i_access_webdriver_university_contact_us_page()  {
        navigateTo_URL("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        //driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomNumber(5));
        sendKeys(By.xpath("//input[@name='first_name']"), "AutoFN" + generateRandomNumber(5));
    }
    @When("I enter a unique last name")
    public void i_enter_a_unique_last_name()  {
        sendKeys(By.xpath("//input[@name='last_name']"), "AutoLN" + generateRandomNumber(5));

    }
    @When("I enter a unique email address")
    public void i_enter_a_unique_email_address()  {
        sendKeys(By.xpath("//input[@name='email']"), "AutoEmail" + generateRandomNumber(20) + "@mail.com");

    }
    @When("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        sendKeys(By.xpath("//textarea[@name='message']"),"Hello Mr " + generateRandomString(50));
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        sendKeys(By.xpath("//input[@name='first_name']"), firstName);

    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        sendKeys(By.xpath("//input[@name='last_name']"), lastName);

    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        sendKeys(By.xpath("//input[@name='email']"), email);

    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        sendKeys(By.xpath("//textarea[@name='message']"), comment);
    }

    @When("I click on the submit button")
    public void i_click_on_the_submit_button()  {
        waitForElementAndClick(By.xpath("//input[@value='SUBMIT']"));

    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() throws InterruptedException {
        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Thank You for your Message!");
    }

}
