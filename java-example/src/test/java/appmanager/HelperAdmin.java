package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class HelperAdmin extends HelperBase {
    int menuCol, submenuCol;
    int prodCol, stickerCol;
    WebElement prodUnit;
    List<WebElement> prodList, stickerList;

    int countryCol, zoneCol, geoZoneCol; // количество стран в списке, зон в списке
    int[] zones;  // массив количества зон для списка стран
    int a, az;
    WebElement countryRow, zoneRow, geoZoneRow;  // строка по стране и по зоне
    List<WebElement> countryRows, zoneRows, geoZoneRows;  // список стран, список зон
    String[] countryName, zoneName;  // имена стран, имена зон

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

    public void goToSite(){
        wd.get("http://localhost:8080/litecart/en/");
    }

    public void CheckStiker(){

        wait = new WebDriverWait(wd,10);

        prodList = wd.findElements(By.id("li.product"));
        prodCol = prodList.size();

        for (int i = 0; i < prodCol; i++) {

            prodList = wd.findElements(By.id("li.product"));
            prodUnit = prodList.get(i);

            stickerList = wd.findElements(By.cssSelector("li.product .sticker"));
            stickerCol = stickerList.size();
            Assert.assertTrue(stickerCol == 1);
        }
    }

    public static int Alphabet (String[] testArr, int arrSize) {
        int isAlphab=1;
        for (int i=1; i<arrSize;i++) {
            int k;
            k=testArr[i-1].compareToIgnoreCase(testArr[i]);
            if(k>=0) isAlphab=-1;
        }
        return isAlphab;
    }

    public void CheckCountries() {

        wd.get("http://localhost:8080/litecart/admin/?app=countries&doc=countries");

        countryRows = wd.findElements(By.cssSelector("[name=countries_form] .row"));

        countryCol = countryRows.size();
        countryName = new String[countryCol];
        zones = new int[countryCol];

        for (int i = 0; i< countryCol; i++) {
            countryRow = countryRows.get(i);
            countryName[i] = countryRow.findElement(By.cssSelector("a")).getText();
            zones[i]=Integer.parseInt(countryRow.findElement(By.cssSelector("td:nth-child(6)")).getText());
        }

        a = Alphabet(countryName, countryCol);

        Assert.assertTrue(a==1);

        for (int i = 0; i< countryCol; i++) {
            if (zones[i]>0) {
                countryRows = wd.findElements(By.cssSelector("[name=countries_form] .row"));
                countryRow=countryRows.get(i);
                countryRow.findElement(By.cssSelector("a")).click();
                wait = new WebDriverWait(wd,10);

                zoneRows = wd.findElements(By.cssSelector("[id=table-zones] tr"));
                zoneCol = zoneRows.size() - 2;
                zoneName = new String[zoneCol];

                for (int j = 1; j<= zoneCol; j++) {
                    zoneRow = zoneRows.get(j);
                    zoneName[j-1]=zoneRow.findElement(By.cssSelector("td:nth-child(3)")).getText();
                }
                az = Alphabet(zoneName, zoneCol);
                Assert.assertTrue(az==1);

                wd.get("http://localhost:8080/litecart/admin/?app=countries&doc=countries");
            }
        }

        wd.get("http://localhost:8080/litecart/admin/?app=geo_zones&doc=geo_zones");

        geoZoneRows = wd.findElements(By.cssSelector("[name=geo_zones_form] .row"));
        geoZoneCol = geoZoneRows.size();

        for (int i = 0; i< geoZoneCol; i++) {
            geoZoneRows = wd.findElements(By.cssSelector("[name=geo_zones_form] .row"));
            geoZoneRow = geoZoneRows.get(i);
            geoZoneRow.findElement(By.cssSelector("a")).click();
            wait = new WebDriverWait(wd,10);

            zoneRows = wd.findElements(By.cssSelector("[id=table-zones] tr"));
            zoneCol = zoneRows.size() - 2;
            zoneName = new String[zoneCol];

            for (int j = 1; j<= zoneCol; j++) {
                zoneRow=zoneRows.get(j);
                zoneName[j-1] = zoneRow.findElement(
                        By.cssSelector("[id=table-zones] tr td:nth-child(3) [selected=selected]")).
                        getAttribute("textContent");
            }
            az = Alphabet(zoneName, zoneCol);
            Assert.assertTrue(az==1);
            wd.get("http://localhost:8080/litecart/admin/?app=geo_zones&doc=geo_zones");
        }
    }

}
