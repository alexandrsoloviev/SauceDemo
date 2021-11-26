import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CriticalPath extends BaseTest {

    @Test
    public void criticalPath() {

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement((By.cssSelector("#login-button"))).click();

        String nameItemCatalog = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bolt T-Shirt')]")).getText();
        String priceItemCatalog = driver.findElement(By.xpath("(//div[@class='inventory_item_price'][normalize-space()='$15.99'])[1]")).getText();
        driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).click();

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        String nameItemCart = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
        String priceItemCart = driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText();

        assertEquals(nameItemCatalog, nameItemCart);
        assertEquals(priceItemCatalog, priceItemCart);


    }
}
