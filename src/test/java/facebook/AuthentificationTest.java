package facebook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AuthentificationTest extends BaseTest {

    private WebDriver driver;

    @BeforeTest
    public void up() {
        System.setProperty("webdriver.chrome.driver", "/Users/yantoniuk/Documents/tools/chromedriver");
        this.driver = new ChromeDriver();
    }

    @Test
    public void facebookAuthentification() {
        LoginPage loginPage = openLoginPage(driver);
        loginPage.login("a1s2dcld6", "cfnfjdls");
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://web.facebook.com/?_rdc=1&_rdr", "failed authentidication was expected!");
        Assert.assertTrue(loginPage.wasLogInFailed(), "warning was expected!");
    }

    @AfterTest
    public void down() {
        driver.close();
    }
}
