import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LocatorTestDemo extends BaseSetup {
    private Logger log = Logger.getLogger(Log.class.getName());
    private WebDriver d;
    private Properties p;
    @Before
    public void setUp() {
        d = getWebDriver();
        p = getObjRepo();
        log.info("Child class before called");
    }
    @Test
    public void testLocatorUsingLinktext() {
        d.get("https://www.bbc.com/");
        d.manage().window().maximize();
         d.findElement(By.linkText("Sport")).click();
        //d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //d.findElement(By.partialLinkText("Remembrance rests"));
    }
    @Test
    public void testLocatorUsingRelativePath(){
        d.get("https://www.facebook.com");
        WebElement userNameElement= d.findElement(By.cssSelector("input#email"));
        userNameElement.sendKeys("abc@gmail.com");
    }
    @Test
    public void testLocatorUsingClass(){
        d.get("https://www.facebook.com");
        d.findElement(By.cssSelector(".inputtext")).sendKeys("abc@gmail.com");
    }
    @Test
    public void testLocatorUsingattribute(){
        d.get("https://www.facebook.com");
        d.findElement(By.cssSelector("input[name=email]")).sendKeys("abc@gmail.com");
    }
    @Test
    public void testLocatorUsingClassandattribute(){
        d.get("https://www.facebook.com");
        d.findElement(By.cssSelector("input.inputtext[name=email]")).sendKeys("abc@gmail.com");

}}

