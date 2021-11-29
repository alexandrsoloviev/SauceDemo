package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{



    public static final By USERNAME_INPUT = By.xpath("//input[@id='user-name']");
    public  static final By PASSWORD_INPUT = By.xpath("//input[@id='password']");
    public  static final By LOGIN_BUTTON = By.id("login-button");
    public  static final By ERROR_MESSAGE = By.cssSelector(".error-message-container ");
    public static final By CONTENT_IS_VISIBLE = By.xpath("//a[@class='shopping_cart_link']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get("https://www.saucedemo.com/");

    }

    public void login(String userName, String password){
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

    }

    public void contentIsVisible(){
        driver.findElement(CONTENT_IS_VISIBLE);
    }




    public String getErrorMessage(){
        return driver.findElement(ERROR_MESSAGE).getText();

    }
}
