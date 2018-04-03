package tests;

import org.testng.annotations.Test;

public class CreateUser extends TestBase {

    @Test
    public void TestCreateUser(){
        app.getHelperAdmin().goToSite();
        app.getHelperAdmin().NewCreateUser();
    }
}
