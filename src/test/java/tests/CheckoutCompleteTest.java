package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class CheckoutCompleteTest extends BaseTest {

    @Test
    public void open(){
        checkoutCompleteTest.open();
        checkoutCompleteTest.titleIsVisible("Checkout: Complete!");
    }

    @Test
    public void purchaseWasSuccessful(){
        checkoutCompleteTest.open();
        checkoutCompleteTest.clickBackHomeButton();
        checkoutCompleteTest.titleIsVisible("Products");
    }

}

