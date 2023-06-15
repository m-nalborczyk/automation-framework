package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.Global_Vars;

public class Contact_Us_PO extends Base_PO{

    public Contact_Us_PO(){
        super();
    }

    private @FindBy (xpath = "//input[@name='first_name']") WebElement firstName_TextField;
    private @FindBy (xpath = "//input[@name='last_name']") WebElement lastName_TextField;
    private @FindBy (xpath = "//input[@name='email']") WebElement emailAddress_TextField;
    private @FindBy (xpath = "//textarea[@name='message']") WebElement comment_TextField;
    private @FindBy (xpath = "//input[@value='SUBMIT']") WebElement submit_Button;
    private @FindBy (xpath = "//div[@id='contact_reply']/h1") WebElement submit_Message;

    public void navigateTo_WebdriverUniversity_Contact_Us_Page (){
        navigateTo_URL(Global_Vars.WEBDRIVER_UNIVERSITY_HOMEPAGE_URL + "/Contact-Us/contactus.html");
    }
    public void setUnique_FirstName(){
        sendKeys(firstName_TextField, "AutoFN" + generateRandomNumber(5));
    }
    public void setUnique_LastName(){
        sendKeys(lastName_TextField, "AutoLN" + generateRandomNumber(5));
    }
    public void setUnique_EmailAddress(){
        sendKeys(emailAddress_TextField, "AutoEmail" + generateRandomNumber(20) + "@mail.com");
    }
    public void setUnique_Comment(){
        sendKeys(comment_TextField, "Hello Mr " + generateRandomString(50));
    }
    public void setSpecific_FirstName(String firstName){
        sendKeys(firstName_TextField, firstName);
    }
    public void setSpecific_LastName(String lastName){
        sendKeys(lastName_TextField, lastName);
    }
    public void setSpecific_Email(String email){
        sendKeys(emailAddress_TextField, email);
    }
    public void setSpecific_Comment(String comment){
        sendKeys(comment_TextField, comment);
    }
    public void click_SubmitButton(){
        waitForElementAndClick(submit_Button);
    }
    public void validate_SubmissionMessage (){
        waitFor(submit_Message);
        Assert.assertEquals(submit_Message.getText(), "Thank You for your Message!");
    }

}
