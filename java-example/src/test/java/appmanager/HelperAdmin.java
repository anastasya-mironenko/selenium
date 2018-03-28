package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class HelperAdmin extends HelperBase {
   int menuCol, submenuCol;

    public HelperAdmin(WebDriver wd){
        super(wd);
    }

    private WebDriverWait wait;

    public void goToAdmin(){
        wd.get("http://localhost:8080/litecart/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
    }

    public void login(String username, String password) {
        type(By.name("username"), username);
        type(By.name("password"), password);
        wd.findElement(By.name("login")).click();
    }

    public void ClickMenu() {

        wait = new WebDriverWait(wd, 10);
        wait.until(titleIs("My Store"));

        List<WebElement> menuPoints = wd.findElements(By.id("app-"));
        List<WebElement> submenuPoints;
        WebElement menuPoint, submenuPoint;
        menuCol = menuPoints.size(); //сохранение количества пунктов меню

        for (int i = 0; i < menuCol; i++) {
            menuPoints = wd.findElements(By.id("app-"));
            menuPoint = menuPoints.get(i);
            wait = new WebDriverWait(wd, 10);
            menuPoint.click();

            menuPoints = wd.findElements(By.id("app-"));
            menuPoint = menuPoints.get(i); //выбор пункта меню
            submenuPoints = menuPoint.findElements(By.cssSelector("[id^=doc-]"));
            submenuCol = submenuPoints.size(); // сохранение количества пунктов подменю

            if (submenuCol > 0) {
                for (int j = 0; j < submenuCol; j++) {
                    menuPoints = wd.findElements(By.id("app-"));
                    menuPoint = menuPoints.get(i); //выбор пункта меню
                    submenuPoints = menuPoint.findElements(By.cssSelector("[id^=doc-]"));
                    submenuPoint = submenuPoints.get(j); //выбор пункта подменю
                    submenuPoint.click();
                    wd.findElement(By.cssSelector("h1")); //проверка наличия заголовка
                }
            } else {
                wd.findElement(By.cssSelector("h1")); //проверка наличия заголовка
            }

        }
    }

}
