import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class CaseNotWorkInTATest {
    private WebDriver driver;


    @BeforeTest
    public void beforeTest() {
        driver = new TrueAutomationDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    @Test
    public void exampleTest1() throws InterruptedException {
        driver.get("https://trueautomation.io");

        /* This is an example of elements that do not work with TA */

        //WebElement loginLink = driver.findElement(By.linkText("Login"));       //the "partialLinkText" method also works
        WebElement loginLink = driver.findElement(By.partialLinkText(ta("TA:Login_Home_Button1", "Login")));        //not work and method "linkText"
        //WebElement loginLink = driver.findElement(By.xpath(ta("TA:Login_Home_Button","//div[./span[text()='Login']]")));      //but through "xpath" works
        loginLink.click();

        //WebElement singUpLink = driver.findElement(By.linkText("Sign up"));     //the "partialLinkText" method also works
        //WebElement singUpLink = driver.findElement(By.partialLinkText(ta("TA:SingUp_Button", "Sing up")));
        //WebElement singUpLink = driver.findElement(By.xpath(ta("TA:SingUp_Button","//div//a[text()='Sign up']")));
        //singUpLink.click();

        //WebElement backToMainLink = driver.findElement(By.linkText("Back to main"));    //the "partialLinkText" method also works
        //WebElement backToMainLink = driver.findElement(By.partialLinkText(ta("TA:BackToMain", "Back to main")));
        //backToMainLink.click();

        Thread.sleep(2000);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
