package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertTrue;

public class BasePage {

    WebDriver driver;
    public static final String TITLE_IS_VISIBLE = "//span[@class='title'][text()='%s']";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void titleIsVisible(String titleText) {
        assertTrue(driver.findElement(By.xpath(String.format(TITLE_IS_VISIBLE, titleText))).isDisplayed());

    }
}
