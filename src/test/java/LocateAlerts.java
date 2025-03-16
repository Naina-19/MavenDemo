import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class LocateAlerts {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void testSimpleAlert(){
        d.get("https://demoqa.com/alerts");
        d.manage().window().maximize();
        d.findElement(By.id("alertButton")).click();
        Alert simpleAlert= d.switchTo().alert();
        simpleAlert.accept();

    }
    @Test
    public void testPromptAlert(){
        d.get("https://demoqa.com/alerts");
        d.manage().window().maximize();
       WebElement element= d.findElement(By.id("promtButton"));
       // element.click();
        ((JavascriptExecutor) d).executeScript("arguments[0].click()",element);
        Alert promptalert= d.switchTo().alert();
        String alertText= promptalert.getText();
        System.out.println("Alert Text is "+alertText);
        promptalert.sendKeys("Test User");
        promptalert.accept();
    }
    @Test
    public void testConfirmationAlert(){
        d.get("https://demoqa.com/alerts");
        d.manage().window().maximize();
        WebElement element= d.findElement(By.id("confirmButton"));
        ((JavascriptExecutor) d).executeScript("arguments[0].click()",element);
        Alert confirmationalert= d.switchTo().alert();
        String alertText= confirmationalert.getText();
        System.out.println("Alert Text is "+alertText);
        confirmationalert.accept();
    }
    @Test
    public void testLoginWithoutuserNameandPassword(){
        d.get("https://www.rediff.com");
        d.manage().window().maximize();
        d.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        d.findElement(By.xpath("//input[@title='Sign in']")).click();
        Alert alert=d.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertEquals("Please enter a valid user name",alert.getText());
    }
    @Test
    public void testLoginWithUsernameWithoutPassword(){
        d.get("https://www.rediff.com");
        d.manage().window().maximize();
        d.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        WebElement uname= d.findElement(By.id("login1"));
        uname.sendKeys("Naina");
        d.findElement(By.xpath("//input[@title='Sign in']")).click();
        Alert alert= d.switchTo().alert();
        String alertText= alert.getText();
        System.out.println("Alert Text is "+alertText);
        Assert.assertEquals("Please enter your password",alert.getText());
        alert.accept();
    }
    @Test
    public void testLoginWithoutUsernameWithPassword(){
        d.get("https://www.rediff.com");
        d.manage().window().maximize();
        d.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
        WebElement uname= d.findElement(By.id("password"));
        uname.sendKeys("Nalini@00");
        d.findElement(By.xpath("//input[@title='Sign in']")).click();
        Alert alert= d.switchTo().alert();
        String alertText= alert.getText();
        System.out.println("Alert Text is "+alertText);
        Assert.assertEquals("Please enter a valid user name",alert.getText());
        alert.accept();
    }
    /*@Test
    public void testUploadFile(){
        d.get("https://html.com/input-type-file");
        d.findElement(By.name("fileupload")).sendKeys("file:///C:/Users/singh/OneDrive/Desktop/worksheet%20Science.pdf");
    }*/
@Test
    @SneakyThrows
    public void testHttpBasicAuthenticationWithCredentials(){
    d.get("https://the-internet.herokuapp.com/basic_auth");
    d.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    Assert.assertEquals("Congratulations! You must have the proper credentials.",d.findElement(By.tagName("p")).getText());

}
@Test
    public void testEnterTextUsingJSExecutor(){
    d.get("https://www.facebook.com");
    JavascriptExecutor js=(JavascriptExecutor) d;
   // d.findElement(By.cssSelector("button[data-cooiebanner=accept_button")).click();
    js.executeScript("document.getElementById('email').value=\"n.singhal@gmail.com\"");

}

}

