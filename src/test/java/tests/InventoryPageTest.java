package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class InventoryPageTest extends BaseTest {

    @Test
    public void openInventoryPage(){
        inventoryPage.open();
    }

    @Test
    public void addProductToCart(){
        inventoryPage.open();
        inventoryPage.addToCart("Sauce Labs Backpack");
        cartPage.moveToCart();
        cartPage.productIsVisibleInCart();
    }






}
