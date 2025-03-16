import com.github.dockerjava.api.model.SELContext;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitMechanism {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void testImplicitWait(){
        d.get("https://www.google.com/");
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        d.findElement(By.xpath("//*[@id=\"APjFqb\"]")).click();
       // d.findElement(By.name("q")).sendKeys("Automation");
       // d.findElement(By.name("q")).sendKeys(Keys.RETURN);
    }
    @Test
    public void testExplicitWait(){
        d.get("https://www.google.com/");
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        d.findElement(By.xpath("//*[@id=\"APjFqb\"]")).click();
        d.findElement(By.name("q")).sendKeys("Automation");
         d.findElement(By.name("q")).sendKeys(Keys.RETURN);

        //WebDriverWait wait= new WebDriverWait(d,60 );
       // WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

    }
}


