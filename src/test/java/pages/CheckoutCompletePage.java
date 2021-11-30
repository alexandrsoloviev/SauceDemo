package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.CartPage.CART_BUTTON;
import static pages.CartPage.CHECKOUT_BUTTON;
import static pages.CheckoutStepOnePage.*;
import static pages.CheckoutStepOnePage.CONTINUE_BUTTON;
import static pages.LoginPage.*;

public class CheckoutCompletePage extends BasePage{

    public static final By FINISH_BUTTON = By.xpath("//button[@id='finish']");
    public static final By BACK_HOME_BUTTON = By.xpath("//button[@id='back-to-products']");

    public CheckoutCompletePage(WebDriver driver) {
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
        driver.findElement(FIRST_NAME_INPUT).sendKeys("first");
        driver.findElement(SECOND_NAME_INPUT).sendKeys("secondName");
        driver.findElement(ZIP_POSTAL_CODE_INPUT).sendKeys("1111");
        driver.findElement(CONTINUE_BUTTON).click();
        driver.findElement(FINISH_BUTTON).click();
    }

    public void clickBackHomeButton(){
        driver.findElement(BACK_HOME_BUTTON).click();
    }
}
