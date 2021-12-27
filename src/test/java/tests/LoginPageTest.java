package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class LoginPageTest extends BaseTest {

    @DataProvider(name = "Входящие данные для задачки iTechArt")
    public Object[][] inputForITechTask() {
        return new Object[][]{
                {"","",""},
                {5, "Art"},
                {15, "iTechArt"},
                {6, "iTech"},

        };
    }


    @Test(groups = "xxx")
    public void validUserData() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        loginPage.contentIsVisible();
    }

    @Test
    public void negativLoginTest() {

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
