package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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


    public HelperAdmin(WebDriver wd) {
        super(wd);
    }

    private WebDriverWait wait;

    public void goToAdmin() {
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

    public void goToSite() {
        wd.get("http://localhost:8080/litecart/en/");
    }

    public void CheckStiker() {

        wait = new WebDriverWait(wd, 10);

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

    public static int Alphabet(String[] testArr, int arrSize) {
        int isAlphab = 1;
        for (int i = 1; i < arrSize; i++) {
            int k;
            k = testArr[i - 1].compareToIgnoreCase(testArr[i]);
            if (k >= 0) isAlphab = -1;
        }
        return isAlphab;
    }

    public void CheckCountries() {

        wd.get("http://localhost:8080/litecart/admin/?app=countries&doc=countries");

        countryRows = wd.findElements(By.cssSelector("[name=countries_form] .row"));

        countryCol = countryRows.size();
        countryName = new String[countryCol];
        zones = new int[countryCol];

        for (int i = 0; i < countryCol; i++) {
            countryRow = countryRows.get(i);
            countryName[i] = countryRow.findElement(By.cssSelector("a")).getText();
            zones[i] = Integer.parseInt(countryRow.findElement(By.cssSelector("td:nth-child(6)")).getText());
        }

        a = Alphabet(countryName, countryCol);

        Assert.assertTrue(a == 1);

        for (int i = 0; i < countryCol; i++) {
            if (zones[i] > 0) {
                countryRows = wd.findElements(By.cssSelector("[name=countries_form] .row"));
                countryRow = countryRows.get(i);
                countryRow.findElement(By.cssSelector("a")).click();
                wait = new WebDriverWait(wd, 10);

                zoneRows = wd.findElements(By.cssSelector("[id=table-zones] tr"));
                zoneCol = zoneRows.size() - 2;
                zoneName = new String[zoneCol];

                for (int j = 1; j <= zoneCol; j++) {
                    zoneRow = zoneRows.get(j);
                    zoneName[j - 1] = zoneRow.findElement(By.cssSelector("td:nth-child(3)")).getText();
                }
                az = Alphabet(zoneName, zoneCol);
                Assert.assertTrue(az == 1);

                wd.get("http://localhost:8080/litecart/admin/?app=countries&doc=countries");
            }
        }

        wd.get("http://localhost:8080/litecart/admin/?app=geo_zones&doc=geo_zones");

        geoZoneRows = wd.findElements(By.cssSelector("[name=geo_zones_form] .row"));
        geoZoneCol = geoZoneRows.size();

        for (int i = 0; i < geoZoneCol; i++) {
            geoZoneRows = wd.findElements(By.cssSelector("[name=geo_zones_form] .row"));
            geoZoneRow = geoZoneRows.get(i);
            geoZoneRow.findElement(By.cssSelector("a")).click();
            wait = new WebDriverWait(wd, 10);

            zoneRows = wd.findElements(By.cssSelector("[id=table-zones] tr"));
            zoneCol = zoneRows.size() - 2;
            zoneName = new String[zoneCol];

            for (int j = 1; j <= zoneCol; j++) {
                zoneRow = zoneRows.get(j);
                zoneName[j - 1] = zoneRow.findElement(
                        By.cssSelector("[id=table-zones] tr td:nth-child(3) [selected=selected]")).
                        getAttribute("textContent");
            }
            az = Alphabet(zoneName, zoneCol);
            Assert.assertTrue(az == 1);
            wd.get("http://localhost:8080/litecart/admin/?app=geo_zones&doc=geo_zones");
        }
    }

    public class ProductData {
        public String name;
        public String regularPrice;
        public String campaignPrice;
        boolean isCrossedRegularPrice;
        boolean isGrayColorRegularPrice;
        boolean isBoldСampaignPrice;
        boolean isRedColorСampaignPrice;
        boolean isTextSizeСampaignPriceBigger;
    }

    public void CheckProductPage() {

        ProductData dataFromMainPage = new ProductData();
        ProductData dataFromProductPage = new ProductData();

        dataFromMainPage = makeProductFormCurrentPage(
                "#box-campaigns div.name",
                "#box-campaigns div.price-wrapper .regular-price",
                "#box-campaigns div.price-wrapper .campaign-price");

        wd.findElement(By.cssSelector("#box-campaigns img")).click();
        dataFromProductPage = makeProductFormCurrentPage(
                "#box-product h1",
                ".information .regular-price",
                ".information .campaign-price");

        compareProductData(dataFromMainPage, dataFromProductPage);
    }

    public int[] getRGB(String color) {

        int[] rgb = new int[3];

        int bracketOpen = color.indexOf('(');
        int bracketClose = color.indexOf(')');

        color = color.substring(bracketOpen + 1, bracketClose);

        int comma1 = color.indexOf(',');
        String element = color.substring(0, comma1);
        rgb[0] = Integer.parseInt(element);
        color = color.substring(comma1 + 2, color.length());

        int comma2 = color.indexOf(',');
        element = color.substring(0, comma2);
        rgb[1] = Integer.parseInt(element);
        color = color.substring(comma2 + 2, color.length());

        int comma3 = color.indexOf(',');
        if (comma3 != -1) {
            element = color.substring(0, comma3);
            rgb[2] = Integer.parseInt(element);
        } else {
            element = color;
            rgb[2] = Integer.parseInt(element);
        }

        return rgb;
    }

    public double getTextSize(String textSize) {
        String cut = textSize.substring(0, textSize.length() - 2);
        double size = Double.parseDouble(cut);
        return size;
    }

    public ProductData makeProductFormCurrentPage(String nameSelector,
                                                  String regularPriceSelector,
                                                  String campaignPriceSelector) {

        ProductData productData = new ProductData();

        productData.name = wd.findElement(By.cssSelector(nameSelector))
                .getAttribute("textContent");
        productData.regularPrice = wd.findElement(By.cssSelector(regularPriceSelector))
                .getAttribute("textContent");
        productData.campaignPrice = wd.findElement(By.cssSelector(campaignPriceSelector))
                .getAttribute("textContent");


        String textDecorationLineRP = wd.findElement(By.cssSelector(regularPriceSelector))
                .getCssValue("text-decoration-line");
        if (textDecorationLineRP.equals("line-through")) {
            productData.isCrossedRegularPrice = true;
        } else {
            productData.isCrossedRegularPrice = false;
        }

        String textColorRegularPrice = wd.findElement(By.cssSelector(regularPriceSelector))
                .getCssValue("color");
        int[] textColorRP = getRGB(textColorRegularPrice);
        if (textColorRP[0] == textColorRP[1] && textColorRP[0] == textColorRP[2]) {
            productData.isGrayColorRegularPrice = true;
        } else {
            productData.isGrayColorRegularPrice = false;
        }


        String textDecorationСP = wd.findElement(By.cssSelector(campaignPriceSelector))
                .getCssValue("font-weight");
        int textDecoration = Integer.parseInt(textDecorationСP);
        if (textDecoration >= 700) {
            productData.isBoldСampaignPrice = true;
        } else {
            productData.isBoldСampaignPrice = false;
        }


        String textColorСampaignPrice = wd.findElement(By.cssSelector(campaignPriceSelector))
                .getCssValue("color");
        int[] textColorCP = getRGB(textColorСampaignPrice);
        if (textColorCP[1] == 0 && textColorCP[2] == 0) {
            productData.isRedColorСampaignPrice = true;
        } else {
            productData.isRedColorСampaignPrice = false;
        }

        String textSizeRegularPrice = wd.findElement(By.cssSelector(regularPriceSelector))
                .getCssValue("font-size");
        String textSizeСampaignPrice = wd.findElement(By.cssSelector(campaignPriceSelector))
                .getCssValue("font-size");

        double textSizeRP = getTextSize(textSizeRegularPrice);
        double textSizeCP = getTextSize(textSizeСampaignPrice);
        if (textSizeCP > textSizeRP) {
            productData.isTextSizeСampaignPriceBigger = true;
        } else {
            productData.isTextSizeСampaignPriceBigger = false;
        }

        return productData;
    }

    public void compareProductData(ProductData mainPage, ProductData productPage) {
        // Выводим результат сравнения на консоль
        System.out.println("На главной странице и на странице товара:");
        System.out.println(compareStringData(mainPage.name, productPage.name)
                + " название товара");
        System.out.println(compareStringData(mainPage.regularPrice, productPage.regularPrice)
                + " обычная цена");
        System.out.println(compareStringData(mainPage.campaignPrice, productPage.campaignPrice)
                + " акционная цена");
        System.out.println(compareBooleanData(mainPage.isCrossedRegularPrice, productPage.isCrossedRegularPrice)
                + " стиль обычной цены - зачеркнутый");
        System.out.println(compareBooleanData(mainPage.isGrayColorRegularPrice, productPage.isGrayColorRegularPrice)
                + " цвет текста обычной цены - серый");
        System.out.println(compareBooleanData(mainPage.isBoldСampaignPrice, productPage.isBoldСampaignPrice)
                + " стиль акционной цены - полужирный");
        System.out.println(compareBooleanData(mainPage.isRedColorСampaignPrice, productPage.isRedColorСampaignPrice)
                + " цвет текста акционной цены - красный");
        System.out.println(compareBooleanData(mainPage.isTextSizeСampaignPriceBigger, productPage.isTextSizeСampaignPriceBigger)
                + " шрифт текста цен: акционная цена крупнее, чем обычная");
    }

    public String compareStringData(String mainPage, String productPage) {
        if (mainPage.equals(productPage)) {
            return "совпадает";
        } else {
            return "не совпадает";
        }
    }

    public String compareBooleanData(boolean mainPage, boolean productPage) {
        if (mainPage == productPage) {
            return "совпадает";
        } else {
            return "не совпадает";
        }
    }

    public void NewCreateUser(){
        wd.findElement(By.linkText("New customers click here")).click();
        //Form
        wd.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Ivan");
        wd.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Petrov");
        wd.findElement(By.cssSelector("input[name='address1']")).sendKeys("WWW");
        wd.findElement(By.cssSelector("input[name='postcode']")).sendKeys("12345");
        wd.findElement(By.cssSelector("input[name='city")).sendKeys("Moscow");

        //Zone
        fillSelect("select[name='country_code']", "United States");
        fillSelect("select[name='zone_code']", "Alaska");

        //Unique email
        String email = generateUniqueNumber() + "@gmail.com";
        wd.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
        wd.findElement(By.cssSelector("input[name='phone']")).sendKeys("+71234567890");
        wd.findElement(By.cssSelector("input[name='password']")).sendKeys("password");
        wd.findElement(By.cssSelector("input[name='confirmed_password']")).sendKeys("password");
        wd.findElement(By.cssSelector("button[name='create_account']")).click();

        //Logout
        wd.findElement(By.linkText("Logout")).click();

        //Login

        wd.findElement(By.cssSelector("input[name='email']")).sendKeys(email);
        wd.findElement(By.cssSelector("input[name='password']")).sendKeys("password");
        wd.findElement(By.cssSelector("button[name='login']")).click();

        //Logout

        wd.findElement(By.linkText("Logout")).click();

    }

    public void fillSelect(String locator, String selectedItem){
        WebElement selectElement = wd.findElement(By.cssSelector(locator));
        Select select = new Select(selectElement);
        List options = select.getOptions();
        select.selectByVisibleText(selectedItem);
    }

    public String generateUniqueNumber(){
        Date date = new Date();
        long millis = date.getTime();
        return String.valueOf(millis);
    }

    public void CreateNewProduct(){

        wd.findElement(By.linkText("Catalog")).click();
        wd.findElement(By.linkText("Add New Product")).click();

        // General
        wd.findElement(By.cssSelector("label input[value='1']")).click(); // Enabled
        fillInput("input[name='name[en]']","Unique Duck"); //  Name
        fillInput("input[name='code']", "ud001"); //  Cod Product
        putCheckbox("input[name='categories[]'][data-name='Root']"); //  check-box Root
        fullSelect("select[name='default_category_id']", "Root"); // Root
        putCheckbox("input[name='product_groups[]'][value='1-3']");//  check-box Unisex
        fillInput("input[name='quantity']", "10");
        fullSelect("select[name='quantity_unit_id']", "pcs");
        fullSelect("select[name='delivery_status_id']", "3-5 days");
        fullSelect("select[name='sold_out_status_id']", "Sold out");
        attachFile("input[name='new_images[]']", "img\\duck-u.jpg");
        // Date
        wd.findElement(By.cssSelector("input[name='date_valid_from']")).sendKeys("2018-04-03");
        wd.findElement(By.cssSelector("input[name='date_valid_to']")).sendKeys("2018-04-29");

        //Information
        wd.findElement(By.linkText("Information")).click();
        pause(2000);
        fullSelect("select[name='manufacturer_id']", "ACME Corp.");
        fillInput("input[name='short_description[en]']", "Unique Duck for You. With Love.");
        fillTextarea("textarea[name='description[en]']");


        //Prices
        wd.findElement(By.linkText("Prices")).click();
        pause(2000);
        fillInput("input[name='purchase_price']", "1");
        fullSelect("select[name='purchase_price_currency_code']", "US Dollars");
        fillInput("input[name='prices[USD]']", "1");

        // Save
        wd.findElement(By.cssSelector("button[name='save']")).click();

        // Search Product
        wd.findElement(By.linkText("Unique Duck")).click();

    }

    public void putCheckbox(String locator) {
        WebElement checkbox = wd.findElement(By.cssSelector(locator));
        if (checkbox.isSelected()) {
            return;
        } else {
            checkbox.click();
        }
    }

    public void fillInput(String locator, String text) {
        WebElement element = wd.findElement(By.cssSelector(locator));
        element.clear();
        element.sendKeys(text);

    }

    public void fullSelect(String locator, String selectedItem) {
        WebElement selectElement = wd.findElement(By.cssSelector(locator));
        Select select = new Select(selectElement);
        select.selectByVisibleText(selectedItem);
    }


    public void pause(Integer milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fillTextarea(String locator) {
        WebElement element = wd.findElement(By.cssSelector(locator));
        element.clear();
        String text = "Unique Duck - for You. The Best of ducks. With B))";
        element.sendKeys(text);
    }

    public void attachFile(String locator, String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            wd.findElement(By.cssSelector(locator)).sendKeys(file.getAbsolutePath());
            System.out.println("Файл " + file.getAbsolutePath() + " прикреплен");
        } else {
            System.out.println("Файл " + file.getAbsolutePath() + " не существует");
        }
    }
}
