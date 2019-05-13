import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class CaseWorkInTATest {
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new TrueAutomationDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @Test
    public void exampleTest1() throws InterruptedException {
        driver.get("https://trueautomation.io");

        /* This is an example of elements that do work with TA */

        /* method "partialLinkText" works with TA */

        WebElement loginLink = driver.findElement(By.linkText("Login"));       //the "partialLinkText" method also works
        loginLink.click();

        //WebElement forgotling = driver.findElement(By.linkText("Forgot your password?"));      //the "partialLinkText" method also works
        WebElement forgotling = driver.findElement(By.partialLinkText(ta("TA:Forgot_Link1","Forgot your password?")));
        forgotling.click();

        //WebElement didNotReceiveLink = driver.findElement(By.linkText("Did not receive confirmation instructions?"));
        //WebElement didNotReceiveLink = driver.findElement(By.partialLinkText(ta("TA:ReceiveLink", "Did not receive confirmation instructions?")));
        //didNotReceiveLink.click();

        Thread.sleep(2000);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}

