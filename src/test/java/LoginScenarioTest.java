
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LoginScenarioTest {
   private WebDriver d;
   @Before
   public void myDriver(){
       WebDriverManager.chromedriver().setup();
       d= new ChromeDriver();
   }
   @Test
    public void testSuccessfullyLogin(){

       d.get("https://www.saucedemo.com");
        WebElement uName= d.findElement(By.xpath("//*[@id=\"user-name\"]"));
        uName.sendKeys("standard_user");
        WebElement uPassword= d.findElement(By.xpath("//*[@id=\"password\"]")) ;
        uPassword.sendKeys("secret_sauce");
        WebElement loginButton = d.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();
        WebElement element=d.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));
       // System.out.println(element.isDisplayed());
        Assert.assertTrue(element.isDisplayed());
    }
    @Test
    public void testFailedLogin(){

        d.get("https://www.saucedemo.com");
        WebElement uName= d.findElement(By.xpath("//*[@id=\"user-name\"]"));
        uName.sendKeys("standard_user");
        WebElement uPassword= d.findElement(By.xpath("//*[@id=\"password\"]")) ;
        uPassword.sendKeys("random password");
        WebElement loginButton = d.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();
        WebElement element=d.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]"));
        //System.out.println(element.isDisplayed());
       // System.out.println(element.getText());
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", element.getText());
   }
   @Test
   public void testSuccessfulLoginUsingURL(){
       d.get("https://www.saucedemo.com");
       WebElement uName= d.findElement(By.xpath("//*[@id=\"user-name\"]"));
       uName.sendKeys("standard_user");
       WebElement uPassword= d.findElement(By.xpath("//*[@id=\"password\"]")) ;
       uPassword.sendKeys("secret_sauce");
       WebElement loginButton = d.findElement(By.xpath("//*[@id=\"login-button\"]"));
       loginButton.click();
       String url1= d.getCurrentUrl();
       Assert.assertEquals("https://www.saucedemo.com/inventory.html",url1);
   }

   @Test
   public void testLoginFailedIfPasswordEmpty(){
       d.get("https://www.saucedemo.com");
       WebElement uName= d.findElement(By.xpath("//*[@id=\"user-name\"]"));
       uName.sendKeys("standard_user");
       WebElement uPassword= d.findElement(By.xpath("//*[@id=\"password\"]")) ;
       uPassword.sendKeys("");
       WebElement loginButton = d.findElement(By.xpath("//*[@id=\"login-button\"]"));
       loginButton.click();
       WebElement element=d.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
       WebElement errorElement = d.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]"));
       String actualError = errorElement.getText();
       String expectedError="Epic sadface: Password is required";
       Assert.assertEquals(expectedError, actualError);
    }
    @Test
    public void testLoginFailedIfUsernameEmpty() {
        d.get("https://www.saucedemo.com");
        WebElement uName = d.findElement(By.xpath("//*[@id=\"user-name\"]"));
        uName.sendKeys("");
        WebElement uPassword = d.findElement(By.xpath("//*[@id=\"password\"]"));
        uPassword.sendKeys("secret_sauce");
        WebElement loginButton = d.findElement(By.xpath("//*[@id=\"login-button\"]"));
        loginButton.click();
        //WebElement element=d.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        WebElement errorElement = d.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
        String actualError = errorElement.getText();
        String expectedError = "Epic sadface: Username is required";
        Assert.assertEquals(expectedError, actualError);
    }
    /*@After
    public void cleanUp(){
       d.quit();
    }*/
}