package tests;

import org.testng.annotations.Test;

public class Countries extends TestBase {

    @Test
    public void TestCountries(){
        app.getHelperAdmin().goToAdmin();
        app.getHelperAdmin().login("admin","admin");
        app.getHelperAdmin().CheckCountriesLinks();
    }
}
