import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import tests.TestBase;

import static org.openqa.selenium.OutputType.*;

public class ClickAdmin extends TestBase{
    
    @Test
    public void ClickAdmin() {
        app.getHelperAdmin().goToAdmin();
        app.getHelperAdmin().login("admin","admin");

        app.getHelperAdmin().ClickAppearence();
        app.getHelperAdmin().ClickTemplate();
        app.getHelperAdmin().ClickLogotype();
        app.getHelperAdmin().ClickCatalog();
        app.getHelperAdmin().ClickCatalog2();
        app.getHelperAdmin().ClickProductGroups();
        app.getHelperAdmin().ClickOptionGroups();
        app.getHelperAdmin().ClickManufacturers();
        app.getHelperAdmin().ClickSuppliers();
        app.getHelperAdmin().ClickDeliveryStatuses();
        app.getHelperAdmin().ClickSoldOutStatuses();
        app.getHelperAdmin().ClickQuantityUnits();
        app.getHelperAdmin().ClickCSVImportExport();
        app.getHelperAdmin().ClickCountries();
        app.getHelperAdmin().ClickCurrencies();
        app.getHelperAdmin().ClickCustomers();
        app.getHelperAdmin().ClickCustomers2();
        app.getHelperAdmin().ClickCSVImportExport2();
        app.getHelperAdmin().ClickNewsletter();
        app.getHelperAdmin().ClickGeoZones();
        app.getHelperAdmin().ClickLanguages();
        app.getHelperAdmin().ClickLanguages2();
        app.getHelperAdmin().ClickStorageEncoding();
        app.getHelperAdmin().ClickModules();
        app.getHelperAdmin().ClickBackgroundJobs();
        app.getHelperAdmin().ClickCustomer();
        app.getHelperAdmin().ClickShipping();
        app.getHelperAdmin().ClickPayment();
        app.getHelperAdmin().ClickOrderTotal();
        app.getHelperAdmin().ClickOrderSuccess();
        app.getHelperAdmin().ClickOrderAction();
        app.getHelperAdmin().ClickOrders();
        app.getHelperAdmin().ClickOrders2();
        app.getHelperAdmin().ClickOrderStatuses();
        app.getHelperAdmin().ClickPages();
        app.getHelperAdmin().ClickReports();
        app.getHelperAdmin().CLickMonthlySales();
        app.getHelperAdmin().ClickMostSoldProducts();
        app.getHelperAdmin().ClickMostShoppingCustomers();
        app.getHelperAdmin().ClickSettings();
        app.getHelperAdmin().ClickStoreInfo();
        app.getHelperAdmin().ClickDefaults();
        app.getHelperAdmin().ClickGeneral();
        app.getHelperAdmin().ClickListings();
        app.getHelperAdmin().ClickImages();
        app.getHelperAdmin().ClickCheckout();
        app.getHelperAdmin().ClickAdvanced();
        app.getHelperAdmin().ClickSecurity();
        app.getHelperAdmin().ClickSlides();
        app.getHelperAdmin().ClickTax();
        app.getHelperAdmin().ClickTaxClasses();
        app.getHelperAdmin().ClickTaxRates();
        app.getHelperAdmin().ClickTranslations();
        app.getHelperAdmin().ClickSearchTranslations();
        app.getHelperAdmin().ClickScanFiles();
        app.getHelperAdmin().ClickCSVImportExport3();
        app.getHelperAdmin().ClickUsers();
        app.getHelperAdmin().ClickvQmods();
        app.getHelperAdmin().ClickvQmods2();
    }
}
