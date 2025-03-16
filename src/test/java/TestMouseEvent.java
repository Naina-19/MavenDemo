import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.dynamic.scaffold.TypeWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestMouseEvent {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
}
@Test
public void testMouseHoverAction(){
    d.get("https://www.orangehrm.com/");
    d.manage().window().maximize();
    d.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    Actions act= new Actions(d);
    WebElement we=d.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/a"));
    act.moveToElement(we).perform();
    d.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
    WebElement we2=d.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/div/div/div/div/ul/li[4]"));
    act.moveToElement(we2).perform();
    d.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
    //WebElement we3=d.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[1]/div/div/div/div/ul/li[4]/div/div/h6[3]/a"));
   // act.moveToElement(we3).perform();
    }
    @Test
    public void testToolTipoption(){
        d.get("https://www.w3schools.com/css/css_tooltip.asp");
        d.manage().window().maximize();
        WebElement Toolbox= d.findElement(By.xpath("//div[@class='w3-row w3-center']//div[1]//div[1]"));
        Actions ac= new Actions(d);
        ac.moveToElement(Toolbox).perform();
        String tooltiptext=d.findElement(By.xpath("//*[@id=\"main\"]/div[3]/div[1]/div/span")).getText();
        Assert.assertEquals("Tooltip text",tooltiptext);

    }
}
