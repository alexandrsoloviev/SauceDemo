package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;
import static pages.CartPage.CART_BUTTON;
import static pages.CartPage.CHECKOUT_BUTTON;
import static pages.InventoryPage.ADD_PRODUCT_BUTTON;
import static pages.LoginPage.*;

public class CheckoutStepOnePage extends BasePage{

    public static final By FIRST_NAME_INPUT = By.xpath("//input[@id='first-name']");
    public static final By SECOND_NAME_INPUT = By.xpath("//input[@id='last-name']");
    public static final By ZIP_POSTAL_CODE_INPUT = By.xpath("//input[@id='postal-code']");
    public static final By CONTINUE_BUTTON = By.xpath("//input[@id='continue']");
    public static final By ERROR_MESSAGE_IN_CHECKOUT = By.cssSelector(".error-message-container ");

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(USERNAME_INPUT).sendKeys("standard_user");
        driver.findElement(PASSWORD_INPUT).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        driver.findElement(CART_BUTTON).click();
        driver.findElement(CHECKOUT_BUTTON).click();


    }



    public void inputCheckoutData(String firstName, String secondName, String zipPostalCode){
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(SECOND_NAME_INPUT).sendKeys(secondName);
        driver.findElement(ZIP_POSTAL_CODE_INPUT).sendKeys(zipPostalCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE_IN_CHECKOUT).getText();
    }


}
