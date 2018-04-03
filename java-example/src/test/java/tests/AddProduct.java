package tests;

import org.testng.annotations.Test;

public class AddProduct extends TestBase {

    @Test
    public void TestAddProduct(){
        app.getHelperAdmin().goToAdmin();
        app.getHelperAdmin().login("admin", "admin");
        app.getHelperAdmin().CreateNewProduct();
    }
}
