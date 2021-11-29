package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.LoginPage.*;

public class CartPage extends BasePage {

    public static final By CART_BUTTON = By.xpath("//a[@class='shopping_cart_link']");
    public static final String PRODUCT_PRICE_IN_CART = "//div[div[div[a[div[@class='inventory_item_name'][text()='%s']]]]]//div[@class='inventory_item_price']";
    public static final By CHECKOUT_BUTTON = By.xpath("//button[@id='checkout']");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(USERNAME_INPUT).sendKeys("standard_user");
        driver.findElement(PASSWORD_INPUT).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
        driver.findElement(CART_BUTTON).click();
    }

    public void moveToCart() {
        driver.findElement(CART_BUTTON).click();

    }

    public String getNameProductInCart() {
        return driver.findElement(By.xpath("//div[@class='inventory_item_name']")).getText();

    }

    public boolean productIsVisibleInCart() {
        return driver.findElement(By.xpath("//div[@class='cart_quantity']")).isDisplayed();
    }

    public double getItemPriceInCart(String nameProduct) {

        return Double.parseDouble(driver.findElement(By.xpath(String.format(PRODUCT_PRICE_IN_CART, nameProduct)))
                                 .getText().substring(1).trim());
    }

    public void clickCheckoutButton(){
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
