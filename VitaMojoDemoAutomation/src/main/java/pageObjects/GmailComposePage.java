package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GmailComposePage {
    public GmailComposePage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(how= How.XPATH,using="//div[text()='Compose']")
    private WebElement btnCompose;

    @FindBy(how= How.XPATH,using="//div[@aria-label='Search Field']//div//input")
    private WebElement inputRecipients;

    @FindBy(how= How.NAME,using="subjectbox")
    private WebElement inputSubject;

    @FindBy(how= How.XPATH,using="//div[@aria-label='Message Body']")
    private WebElement inputBody;

    @FindBy(how= How.XPATH,using="//div[text()='Send']")
    private WebElement btnSend;

    @FindBy(how= How.XPATH,using="//span[text()='Message sent']")
    private List<WebElement> eleMessageSent;

    public void sendEmail(){
        btnCompose.click();
        //Enter your email ID in below line
        inputRecipients.sendKeys("");
        inputSubject.sendKeys("Incubyte");
        inputBody.sendKeys("Automation QA Test for Incubyte");
        btnSend.click();
        int successfulMessage = eleMessageSent.size();
        if(successfulMessage>0){
            Assert.assertTrue(true);
            System.out.println("Mail sent successfully");
        }
        else{
            System.out.println("Mail sending Unsuccessful");
            Assert.assertTrue(false);
        }
    }

}
