package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO{

    public Login_PO(){
        super();
    }

    private @FindBy(xpath = "//input[@type='text']") WebElement username_TextField;
    private @FindBy(xpath = "//input[@type='password']") WebElement password_TextField;
    private @FindBy(xpath = "//button[@type='submit']") WebElement login_Button;

    public void navigateTo_WebDriverUniversity_Login_Page(){
        navigateTo_URL("https://www.webdriveruniversity.com/Login-Portal/index.html?");
    }
    public void setUsername (String username) {
        sendKeys(username_TextField, username);
    }
    public void setPassword(String password){
        sendKeys(password_TextField, password);
    }
    public void clickLoginButton(){
        waitForElementAndClick(login_Button);
    }

}
