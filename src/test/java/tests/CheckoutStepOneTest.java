package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class CheckoutStepOneTest extends BaseTest {


    @Test
    public void openCheckoutPage(){
        checkoutStepOnePage.open();
        checkoutStepOnePage.titleIsVisible("Checkout: Your Information");
    }

    @Test
    public void validDataInputInCheckoutForm(){
        checkoutStepOnePage.open();
        checkoutStepOnePage.inputCheckoutData("first","second","11111");
        checkoutStepOnePage.titleIsVisible("Checkout: Overview");
    }

    @Test
    public void userFirstNameShouldBeRequired(){
        checkoutStepOnePage.open();
        checkoutStepOnePage.inputCheckoutData("","second","11111");
        assertEquals(checkoutStepOnePage.getErrorMessage(),"Error: First Name is required");
    }

    @Test
    public void userSecondNameShouldBeRequired(){
        checkoutStepOnePage.open();
        checkoutStepOnePage.inputCheckoutData("first","","11111");
        assertEquals(checkoutStepOnePage.getErrorMessage(),"Error: Last Name is required");
    }

    @Test
    public void userZipPostalCodeShouldBeRequired(){
        checkoutStepOnePage.open();
        checkoutStepOnePage.inputCheckoutData("first","second","");
        assertEquals(checkoutStepOnePage.getErrorMessage(),"Error: Postal Code is required");
    }




}
