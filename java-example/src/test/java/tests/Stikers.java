
package tests;
import org.testng.annotations.Test;

public class Stikers extends TestBase {

    @Test
    public void Stikers() {
        app.getHelperAdmin().goToSite();
        app.getHelperAdmin().CheckStiker();

    }
}
