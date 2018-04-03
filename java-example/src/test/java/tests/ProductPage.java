package tests;

import org.testng.annotations.Test;

public class ProductPage extends TestBase {

    @Test
    public void TestProductPage(){

        app.getHelperAdmin().goToSite();
        app.getHelperAdmin().CheckProductPage();

    }
}
