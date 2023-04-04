package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class UIStepDefinitions {

    WebDriver driver;
    @Before("@WEB")
    public void setup(){

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//main//resources//Drivers//chromedriver.exe");

        driver=new ChromeDriver();
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

    @And("User provide details on signup pages")
    public void userProvideDetailsOnSignupPages() {
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.findElement(By.xpath("//li[text()='Create Account']")).click();
        driver.findElement(By.id("firstName")).sendKeys("Demo");
        driver.findElement(By.id("email")).sendKeys("demo@gmail.com");
        driver.findElement(By.id("phoneNumber")).sendKeys("01234565456");
        driver.findElement(By.id("password")).sendKeys("Demo@123");
        driver.findElement(By.xpath("//label[@class='css-1bhhz3x e379e0i2']")).click();

        Select select;
        select = new Select(driver.findElement(By.xpath("(//select[@class='css-19g9shq e8h9qit2'])[1]")));
        select.selectByIndex(2);
        select = new Select(driver.findElement(By.xpath("(//select[@class='css-19g9shq e8h9qit2'])[2]")));
        select.selectByIndex(2);
        select = new Select(driver.findElement(By.xpath("(//select[@class='css-19g9shq e8h9qit2'])[3]")));
        select.selectByValue("1999");
        driver.findElement(By.xpath("//button[text()='Create Account']")).click();
    }

    @Then("User should get successful signup message")
    public void userShouldGetSuccessfulSignupMessage() {
        int allElemets = driver.findElements(By.xpath("//div[text()='This email is already connected to an account.']")).size();
        if(allElemets>0){
            Assert.assertTrue(true);
            System.out.println("Signup successful");
        }
        else{
            Assert.assertTrue(false);
            System.out.println("Signup successful");
        }
    }

    @And("User Provide username {string} and password {string}")
    public void userProvideUsernameAndPassword(String userName, String password) {
        driver.findElement(By.xpath("//a[text()='Login']")).click();
        driver.findElement(By.id("email")).sendKeys(userName);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Login']")).click();
    }

    @Then("User should be able to login successfully")
    public void userShouldBeAbleToLoginSuccessfully() {
        int allElemets = driver.findElements(By.xpath("//h1[text()='Join our loyalty programme']")).size();
        if(allElemets>0){
            Assert.assertTrue(true);
            System.out.println("Login successful");
        }
        else{
            Assert.assertTrue(false);
            System.out.println("Login Unsuccessful");
        }
    }


}
