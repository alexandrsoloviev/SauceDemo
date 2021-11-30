package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static pages.LoginPage.*;

public class InventoryPage extends BasePage {

    public static final String ADD_PRODUCT_BUTTON = "//div[div[div[a[div[@class='inventory_item_name'][text()='%s']]]]]//button[@class='btn btn_primary btn_small btn_inventory']";

    public static final String PRODUCT_PRICE_IN_CATALOG = "//div[div[div[a[div[@class='inventory_item_name'][text()='%s']]]]]//div[@class='inventory_item_price']";



    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(USERNAME_INPUT).sendKeys("standard_user");
        driver.findElement(PASSWORD_INPUT).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();

    }



    public void addToCart(String nameProduct) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_BUTTON, nameProduct))).click();
    }


    public double getItemPriceInCatalog(String nameProduct){

        return Double.parseDouble( driver.findElement(By.xpath(String.format(PRODUCT_PRICE_IN_CATALOG,nameProduct))).getText().substring(1).trim());

    }


}
