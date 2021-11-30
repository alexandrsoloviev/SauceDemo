package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static pages.CartPage.*;
import static pages.CheckoutStepOnePage.*;
import static pages.LoginPage.*;


public class CheckoutStepTwoPage extends BasePage{

    public static final String ITEM_TOTAL = "//div[@class='summary_subtotal_label']";
    public static final String TOTAL = "//div[@class='summary_total_label']";
    public static final By FINISH_BUTTON = By.xpath("//button[@id='finish']");


    public CheckoutStepTwoPage(WebDriver driver) {
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
    }

    public void clickFinishButton(){
        driver.findElement(FINISH_BUTTON).click();
    }

    public double getTotalExpected(){
       double itemTotal = Double.parseDouble( driver.findElement(By.xpath(ITEM_TOTAL)).getText().substring(13).trim());
       double total = itemTotal*8/100;
       return Math.round((total+itemTotal) * 100.0) / 100.0;
    }

    public double getTotalActual(){
        return Double.parseDouble(driver.findElement(By.xpath(TOTAL)).getText().substring(8).trim());
    }


}
