package tests;
import org.testng.annotations.Test;

public class ClickAdmin extends TestBase {

    @Test
    public void ClickAdmin() {
        app.getHelperAdmin().goToAdmin();
        app.getHelperAdmin().login("admin", "admin");
        app.getHelperAdmin().ClickMenu();
    }
}
