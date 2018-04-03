package tests;

import org.testng.annotations.Test;

public class Basket extends TestBase {

    @Test
    public void TestBasket(){

        app.getHelperAdmin().UpdateBasket();
    }
}
