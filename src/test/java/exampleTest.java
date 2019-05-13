import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.trueautomation.client.TrueAutomationHelper.byTa;
import static io.trueautomation.client.TrueAutomationHelper.ta;

public class exampleTest {
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new TrueAutomationDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void exampleTest() throws InterruptedException {
        driver.get("https://trueautomation.io");

        WebElement loginLink = driver.findElement(By.linkText("Login"));       //the "partialLinkText" method also works
        //WebElement loginLink = driver.findElement(By.partialLinkText(ta("TA:Login_Home_Button1", "Login")));        //not work and method "linkText"
        //WebElement loginLink = driver.findElement(By.xpath(ta("TA:Login_Home_Button","//div[./span[text()='Login']]")));      //but through "xpath" works
        loginLink.click();

        //WebElement forgotling = driver.findElement(By.linkText("Forgot your password?"));      //the "partialLinkText" method also works
        WebElement forgotling = driver.findElement(By.partialLinkText(ta("TA:Forgot_Link1","Forgot your password?")));
        forgotling.click();

        //WebElement didNotReceiveLink = driver.findElement(By.linkText("Did not receive confirmation instructions?"));
        //WebElement didNotReceiveLink = driver.findElement(By.partialLinkText(ta("TA:ReceiveLink", "Did not receive confirmation instructions?")));
        //didNotReceiveLink.click();

        //WebElement singUpLink = driver.findElement(By.linkText("Sign up"));     //the "partialLinkText" method also works
        //WebElement singUpLink = driver.findElement(By.partialLinkText(ta("TA:SingUp_Button", "Sing up")));
        //WebElement singUpLink = driver.findElement(By.xpath(ta("TA:SingUp_Button","//div//a[text()='Sign up']")));
        //singUpLink.click();

        //WebElement backToMainLink = driver.findElement(By.linkText("Back to main"));    //the "partialLinkText" method also works
        //WebElement backToMainLink = driver.findElement(By.linkText(ta("TA:BackToMain", "Back to main")));    //not work and method "partialLinkTest"
        //backToMainLink.click();

        Thread.sleep(2000);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
