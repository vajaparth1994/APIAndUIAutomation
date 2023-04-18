package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObjects.GmailComposePage;

import java.time.Duration;

public class UIStepDefinitions {

    WebDriver driver;
    @Before("@WEB")
    public void setup(){

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//main//resources//Drivers//chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=C:/Users/Lenovo/AppData/Local/Google/Chrome/User Data");
        options.addArguments("--disable-dev-shm-usage");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After("@WEB")
    public void tearDown(){
        driver.quit();
    }
    @Given("User launch application {string}")
    public void userLaunchApplication(String url) {
        driver.navigate().to(url);
    }


    @Then("User should be able to send email successfully")
    public void userShouldBeAbleToSendEmailSuccessfully()  {
        GmailComposePage gmailComposePage = new GmailComposePage(driver);
        gmailComposePage.sendEmail();

    }
}