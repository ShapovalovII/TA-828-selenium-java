import io.trueautomation.client.driver.TrueAutomationDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.trueautomation.client.TrueAutomationHelper.ta;

public class WeKeepIdeaTest {
    private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new TrueAutomationDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void checklink() throws InterruptedException {
        driver.get("https://ru.wikipedia.org");
        Thread.sleep(2000);

        //WebElement spravka = driver.findElement(By.linkText("Справка"));
        WebElement spravka = driver.findElement(By.partialLinkText(ta("WeKeepIdea:SPRAVKA", "Справка")));
        spravka.click();

        driver.get("https://ru.wikipedia.org");
        Thread.sleep(2000);

        //WebElement book = driver.findElement(By.linkText("Создать книгу"));
        WebElement book = driver.findElement(By.partialLinkText(ta("WeKeepIdea:CreateBook", "Создать книгу")));
        book.click();

        driver.get("https://ru.wikipedia.org");
        Thread.sleep(2000);


        //WebElement lang = driver.findElement(By.linkText("English"));
        WebElement lang = driver.findElement(By.partialLinkText(ta("WeKeepIdea:LangEnglish", "English")));
        lang.click();
    }
    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}
