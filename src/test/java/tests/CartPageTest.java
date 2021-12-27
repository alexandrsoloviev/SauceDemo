package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CartPageTest extends BaseTest {

    @Test
    public void openCart(){
        cartPage.open();
        cartPage.titleIsVisible("Your Cart");
    }


}
