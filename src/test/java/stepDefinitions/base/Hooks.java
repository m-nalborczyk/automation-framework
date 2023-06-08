package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import static driver.DriverFactory.cleanupDriver;
import static driver.DriverFactory.getDriver;

public class Hooks {

    @Before("@login")
    public void setup (){
        getDriver();
    }
    @After("@login")
    public void tearDown(){
        cleanupDriver();
    }
}
