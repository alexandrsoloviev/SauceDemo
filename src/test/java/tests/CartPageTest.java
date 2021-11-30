package tests;

import org.testng.annotations.Test;

public class CartPageTest extends BaseTest{

    @Test
    public void openCart(){
        cartPage.open();
        cartPage.titleIsVisible("Your Cart");
    }


}
