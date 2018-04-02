package tests;

import org.testng.annotations.Test;

public class GeoZone extends TestBase {

    @Test
    public void TestGeoZone(){
        app.getHelperAdmin().goToAdmin();
        app.getHelperAdmin().login("admin","admin");
        app.getHelperAdmin().CheckCountries();
    }
}
