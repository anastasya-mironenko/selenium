package tests;

import org.testng.annotations.Test;

public class Logs extends TestBase {

    @Test
    public void TestLogs(){
        app.getHelperAdmin().goToAdmin();
        app.getHelperAdmin().login("admin","admin");
        app.getHelperAdmin().goToCatalog();
        app.getHelperAdmin().clickCatalogWithLogs();
    }
}
