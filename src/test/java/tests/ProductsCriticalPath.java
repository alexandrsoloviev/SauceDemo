package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsCriticalPath extends BaseTest {

    @Test(description = "Test")
    public void criticalPath() {
        loginPage.open();
        loginPage.login("standard_user","secret_sauce");
        inventoryPage.titleIsVisible("Products");
        inventoryPage.addToCart("Sauce Labs Bike Light");
        cartPage.moveToCart();
        assertTrue(cartPage.productIsVisibleInCart());
        cartPage.clickCheckoutButton();
        checkoutStepOnePage.titleIsVisible("Checkout: Your Information");
        checkoutStepOnePage.inputCheckoutData("name","secondName","11111");
        checkoutStepTwoPage.titleIsVisible("Checkout: Overview");
        assertEquals(checkoutStepTwoPage.getTotalActual(),checkoutStepTwoPage.getTotalExpected());
        checkoutStepTwoPage.clickFinishButton();
        checkoutCompleteTest.titleIsVisible("Checkout: Complete!");
        checkoutCompleteTest.clickBackHomeButton();
        checkoutCompleteTest.titleIsVisible("Products");

    }
}
