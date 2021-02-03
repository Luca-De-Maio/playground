package facebook;

import com.zebrunner.agent.core.annotation.Maintainer;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.agent.core.registrar.Screenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class AuthentificationTest extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private WebDriver driver;

    @BeforeTest
    public void up() {
        System.setProperty("webdriver.chrome.driver", "/Users/yantoniuk/Documents/tools/chromedriver");
        this.driver = new ChromeDriver();
    }

    @Test
    @Maintainer("yantoniuk")
    public void facebookAuthentification() {
        LoginPage loginPage = openLoginPage(driver);
        loginPage.login("a1s2d1cldfd6", "cfnfjdls");
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://web.facebook.com/?_rdc=1&_rdr", "failed authentidication was expected!");
        Assert.assertTrue(loginPage.wasLogInFailed(), "warning was expected!");
    }

    @AfterTest
    public void down() {
        driver.close();
    }
}
