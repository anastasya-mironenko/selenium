package appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class HelperAdmin extends HelperBase {

    public HelperAdmin(WebDriver wd){super(wd);}

    public void goToAdmin(){
        wd.get("http://localhost:8080/litecart/admin/login.php?redirect_url=%2Flitecart%2Fadmin%2F");
    }

    public void login(String username, String password) {
        type(By.name("username"), username);
        type(By.name("password"), password);
        wd.findElement(By.name("login")).click();
    }

    public void ClickAppearence(){

        wd.findElement(By.linkText("Appearence")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Template']")));
    }

    public void ClickTemplate(){

        wd.findElement(By.linkText("Template")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Template']")));

    }

    public void ClickLogotype(){
        wd.findElement(By.linkText("Logotype")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Logotype']")));
    }

    public void ClickCatalog(){
        wd.findElement(By.linkText("Catalog")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Catalog']")));
    }

    public void ClickCatalog2(){
        wd.findElement(By.xpath("//li[@id='doc-catalog']//span[.='Catalog']")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Catalog']")));
    }

    public void ClickProductGroups(){
        wd.findElement(By.linkText("Product Groups")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Product Groups']")));
    }

    public void ClickOptionGroups(){
        wd.findElement(By.linkText("Option Groups")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Option Groups']")));
    }

    public void ClickManufacturers(){
        wd.findElement(By.linkText("Manufacturers")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Manufacturers']")));
    }

    public void ClickSuppliers(){
        wd.findElement(By.linkText("Suppliers")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Suppliers']")));
    }

    public void ClickDeliveryStatuses(){
        wd.findElement(By.linkText("Delivery Statuses")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Delivery Statuses']")));
    }

    public void ClickSoldOutStatuses(){
        wd.findElement(By.linkText("Sold Out Statuses")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Sold Out Statuses']")));
    }

    public void ClickQuantityUnits(){
        wd.findElement(By.linkText("Quantity Units")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Quantity Units']")));
    }

    public void ClickCSVImportExport(){
        wd.findElement(By.linkText("CSV Import/Export")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='CSV Import/Export']")));
    }

    public void ClickCountries(){
        wd.findElement(By.linkText("Countries")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Countries']")));
    }

    public void ClickCurrencies(){
        wd.findElement(By.linkText("Currencies")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Currencies']")));
    }

    public void ClickCustomers(){
        wd.findElement(By.linkText("Customers")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Customers']")));
    }

    public void ClickCustomers2(){
        wd.findElement(By.xpath("//li[@id='doc-customers']//span[.='Customers']")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Customers']")));
    }

    public void ClickCSVImportExport2(){
        wd.findElement(By.linkText("CSV Import/Export")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='CSV Import/Export']")));
    }

    public void ClickNewsletter(){
        wd.findElement(By.linkText("Newsletter")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Newsletter']")));
    }

    public void ClickGeoZones(){
        wd.findElement(By.linkText("Geo Zones")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Geo Zones']")));
    }

    public void ClickLanguages(){
        wd.findElement(By.linkText("Languages")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Languages']")));
    }

    public void ClickLanguages2(){
        wd.findElement(By.xpath("//li[@id='doc-languages']//span[.='Languages']")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Languages']")));
    }

    public void ClickStorageEncoding(){
        wd.findElement(By.linkText("Storage Encoding")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Storage Encoding']")));
    }

    public void ClickModules(){
        wd.findElement(By.linkText("Modules")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Job Modules']")));
    }
    public void ClickBackgroundJobs(){
        wd.findElement(By.linkText("Background Jobs")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Job Modules']")));
    }

    public void ClickCustomer(){
        wd.findElement(By.linkText("Customer")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Customer Modules']")));
    }

    public void ClickShipping(){
        wd.findElement(By.linkText("Shipping")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Shipping Modules']")));
    }

    public void ClickPayment(){
        wd.findElement(By.linkText("Payment")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Payment Modules']")));
    }

    public void ClickOrderTotal(){
        wd.findElement(By.linkText("Order Total")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Order Total Modules']")));
    }

    public void ClickOrderSuccess(){
        wd.findElement(By.linkText("Order Success")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Order Success Modules']")));
    }

    public void ClickOrderAction(){
        wd.findElement(By.linkText("Order Action")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Order Action Modules']")));
    }

    public void ClickOrders(){
        wd.findElement(By.linkText("Orders")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Orders']")));
    }

    public void ClickOrders2(){
        wd.findElement(By.xpath("//li[@id='doc-orders']//span[.='Orders']")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Orders']")));
    }

    public void ClickOrderStatuses(){
        wd.findElement(By.linkText("Order Statuses")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Order Statuses']")));
    }

    public void ClickPages(){
        wd.findElement(By.linkText("Pages")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Pages']")));
    }

    public void ClickReports(){
        wd.findElement(By.linkText("Reports")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Monthly Sales']")));
    }

    public void CLickMonthlySales(){
        wd.findElement(By.linkText("Monthly Sales")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Monthly Sales']")));
    }

    public void ClickMostSoldProducts(){
        wd.findElement(By.linkText("Most Sold Products")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Most Sold Products']")));
    }

    public void ClickMostShoppingCustomers(){
        wd.findElement(By.linkText("Most Shopping Customers")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Most Shopping Customers']")));
    }

    public void ClickSettings(){
        wd.findElement(By.linkText("Settings")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Settings']")));
    }

    public void ClickStoreInfo(){
        wd.findElement(By.linkText("Store Info")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Settings']")));
    }

    public void ClickDefaults(){
        wd.findElement(By.linkText("Defaults")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Settings']")));
    }

    public void ClickGeneral(){
        wd.findElement(By.linkText("General")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Settings']")));
    }

    public void ClickListings(){
        wd.findElement(By.linkText("Listings")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Settings']")));
    }

    public void ClickImages(){
        wd.findElement(By.linkText("Images")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Settings']")));
    }

    public void ClickCheckout(){
        wd.findElement(By.linkText("Checkout")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Settings']")));
    }

    public void ClickAdvanced(){
        wd.findElement(By.linkText("Advanced")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Settings']")));
    }

    public void ClickSecurity(){
        wd.findElement(By.linkText("Security")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Settings']")));
    }

    public void ClickSlides(){
        wd.findElement(By.linkText("Slides")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Slides']")));
    }

    public void ClickTax(){
        wd.findElement(By.linkText("Tax")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Tax Classes']")));
    }

    public void ClickTaxClasses(){
        wd.findElement(By.linkText("Tax Classes")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Tax Classes']")));
    }

    public void ClickTaxRates(){
        wd.findElement(By.linkText("Tax Rates")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Tax Rates']")));
    }

    public void ClickTranslations(){
        wd.findElement(By.linkText("Translations")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Search Translations']")));
    }

    public void ClickSearchTranslations(){
        wd.findElement(By.linkText("Search Translations")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Search Translations']")));
    }

    public void ClickScanFiles(){
        wd.findElement(By.linkText("Scan Files")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Scan Files For Translations']")));
    }

    public void ClickCSVImportExport3() {
        wd.findElement(By.linkText("CSV Import/Export")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='CSV Import/Export']")));
    }

    public void ClickUsers(){
        wd.findElement(By.linkText("Users")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='Users']")));
    }

    public void ClickvQmods(){
        wd.findElement(By.linkText("vQmods")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='vQmods']")));
    }

    public void ClickvQmods2(){
        wd.findElement(By.xpath("//li[@id='doc-vqmods']//span[.='vQmods']")).click();
        assertTrue(isElementPresent(By.xpath("//td[@id='content']//h1[normalize-space(.)='vQmods']")));
    }
}
