package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginPageTest extends BaseTest {


    @Test
    public void validUserData(){
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        loginPage.contentIsVisible();
    }

    @Test
    public void userNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void passNameShouldBeRequired() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void userDataShouldBeRequired() {
        loginPage.open();
        loginPage.login("wqdqd", "qwdqwdqwd");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void lockedUserShouldBeRequired() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
    }


}
