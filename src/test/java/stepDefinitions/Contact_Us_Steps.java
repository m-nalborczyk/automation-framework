package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObject.Base_PO;
import pageObject.Contact_Us_PO;


public class Contact_Us_Steps extends Base_PO {

    private WebDriver driver = getDriver();
    private Contact_Us_PO contact_us_po;

    public Contact_Us_Steps(Contact_Us_PO contact_us_po){
        this.contact_us_po = contact_us_po;
    }

    @Given("I access webdriver university contact us page")
    public void i_access_webdriver_university_contact_us_page()  {
        contact_us_po.navigateTo_WebdriverUniversity_Contact_Us_Page();
    }
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
        //driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomNumber(5));
        //sendKeys(By.xpath("//input[@name='first_name']"), "AutoFN" + generateRandomNumber(5));
        contact_us_po.setUnique_FirstName();
    }
    @When("I enter a unique last name")
    public void i_enter_a_unique_last_name()  {
        contact_us_po.setUnique_LastName();

    }
    @When("I enter a unique email address")
    public void i_enter_a_unique_email_address()  {
        contact_us_po.setUnique_EmailAddress();
    }
    @When("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        contact_us_po.setUnique_Comment();
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        contact_us_po.setSpecific_FirstName(firstName);
    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        contact_us_po.setSpecific_LastName(lastName);
    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        contact_us_po.setSpecific_Email(email);
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        contact_us_po.setSpecific_Comment(comment);
    }

    @When("I click on the submit button")
    public void i_click_on_the_submit_button()  {
        contact_us_po.click_SubmitButton();

    }
    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        contact_us_po.validate_SubmissionMessage();
    }

}
