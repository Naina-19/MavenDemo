import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddToAndRemoveFromBasket {

        private WebDriver d;
        @Before
        public void myDriver() {
            WebDriverManager.chromedriver().setup();
            d = new ChromeDriver();
        }
        @Test
        public void testAddAndRemoveBasket() {
            d.get("https://www.saucedemo.com");
            WebElement uName = d.findElement(By.xpath("//*[@id=\"user-name\"]"));
            uName.sendKeys("standard_user");
            WebElement uPassword = d.findElement(By.xpath("//*[@id=\"password\"]"));
            uPassword.sendKeys("secret_sauce");
            WebElement loginButton = d.findElement(By.xpath("//*[@id=\"login-button\"]"));
            loginButton.click();
            d.get("https://www.saucedemo.com/inventory.html");
            WebElement addToCart1 = d.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]"));
            addToCart1.click();
            WebElement addToCart2 = d.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]"));
            addToCart2.click();
            WebElement addToCart3 = d.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]"));
            addToCart3.click();
            WebElement addToCart4 = d.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]"));
            addToCart4.click();
            WebElement removeItem1 = d.findElement(By.xpath("//*[@id=\"remove-sauce-labs-backpack\"]"));
            removeItem1.click();
            WebElement itemCountInBasket = d.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a"));
            System.out.println(itemCountInBasket.getText());
            Assert.assertEquals("3", itemCountInBasket.getText());
        }
        @After
        public void cleanUp(){
            d.quit();
        }
    }

