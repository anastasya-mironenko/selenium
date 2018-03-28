package appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class ApplicationManager {

    WebDriver wd;

    private HelperAdmin helperAdmin;
    private String browser;

    public ApplicationManager(String browser) {

        this.browser = browser;
    }

    public void init() {

        if (Objects.equals(browser, BrowserType.FIREFOX)) {

            wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Program Files (x86)/Mozilla Firefox/firefox.exe"));

        } else if (Objects.equals(browser, BrowserType.CHROME)) {

            wd = new ChromeDriver();

        } else if (Objects.equals(browser, BrowserType.IE)) {

            wd = new InternetExplorerDriver();
        }
        //wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        helperAdmin = new HelperAdmin(wd);


    }

    public void stop() {
        wd.quit();
    }

    public HelperAdmin getHelperAdmin(){
        return helperAdmin;
    }
}
