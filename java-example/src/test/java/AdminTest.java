import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class AdminTest {
    WebDriver wd;

    String browser = BrowserType.CHROME;

    @BeforeMethod
    public void setUp() throws Exception {

        if (Objects.equals(browser, BrowserType.FIREFOX)) {

            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Program Files/Mozilla Firefox/firefox.exe"));

        } else if (Objects.equals(browser, BrowserType.CHROME)) {

            wd = new ChromeDriver();

        } else if (Objects.equals(browser, BrowserType.IE)) {

            wd = new InternetExplorerDriver();
        }
    }


    @Test
    public void AdminTest() {
        wd.get("http://localhost:8080/litecart/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
        wd.findElement(By.name("username")).click();
        wd.findElement(By.name("username")).clear();
        wd.findElement(By.name("username")).sendKeys("admin");
        wd.findElement(By.name("password")).click();
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys("admin");
        wd.findElement(By.name("login")).click();
    }

    @AfterMethod
    public void stop() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(WebDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
