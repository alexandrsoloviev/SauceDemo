package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class CheckoutStepTwoTest extends BaseTest {

    @Test
    public void openCheckoutTwoPage() {

        checkoutStepTwoPage.open();
        checkoutStepTwoPage.titleIsVisible("Checkout: Overview");
    }

    @Test
    public void checkTotal(){
        checkoutStepTwoPage.open();
        assertEquals(checkoutStepTwoPage.getTotalActual(),checkoutStepTwoPage.getTotalExpected());
    }

}
