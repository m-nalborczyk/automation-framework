package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Login_Steps {

    private WebDriver driver;

    @Before("@login")
    public void setup (){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
    @After("@login")
    public void tearDown(){
        driver.quit();
    }

    @Given("I access webdriver university login page")
    public void i_access_webdriver_university_login_page() {
    driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html?");
    }
    @When("I enter a username {}")
    public void i_enter_a_correct_username(String username) {
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(username);
    }
    @When("I enter a password {}")
    public void i_enter_a_password(String password) {
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
    }
    @When("I click on login button")
    public void i_click_login_btn() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();

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
}
