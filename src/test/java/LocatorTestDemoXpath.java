import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LocatorTestDemoXpath extends BaseSetup {
    private Logger log = Logger.getLogger(Log.class.getName());
    private WebDriver d;
    private Properties p;
    @Before
    public void setUp() {
        d = getWebDriver();
        p = getObjRepo();
        log.info("Child class before called");}
    @Test
    public void testLocatorUsingRelXPath(){
        d.get("https://www.amazon.com/");
        d.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("t-shirts");
        d.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
    }
    @Test
    public void testLocatorUsingOrOption(){
        d.get("https://www.amazon.com/");
        d.findElement(By.xpath("//input[@type=\"text\" or @id=\"twotabsearchtextbox\"]")).sendKeys("t-shirts");
        d.findElement(By.xpath("//input[@id=\"nav-search-submit-button\" or @value=\"Go\"]")).click();
}
@Test
public void testLocatorUsingAndOption(){
    d.get("https://www.amazon.com/");
    d.findElement(By.xpath("//input[@type=\"text\" and @id=\"twotabsearchtextbox\"]")).sendKeys("t-shirts");
    d.findElement(By.xpath("//input[@id=\"nav-search-submit-button\" and @value=\"Go\"]")).click();
}
@Test
    public void testLocatorUsingContains(){
        d.get("https://www.amazon.com/");
        d.findElement(By.xpath("//input[contains(@id,'searchtext')]")).sendKeys("t-shirts");
        d.findElement(By.xpath("//input[contains(@value,'Go')]")).click();
    }
@Test
    public void testLocatorUsingStartswith(){
    d.get("https://www.amazon.com/");
    d.findElement(By.xpath("//input[starts-with(@id,'twotab')]")).sendKeys("t-shirts");
    d.findElement(By.xpath("//input[starts-with(@value,'Go')]")).click();
    }
    @Test
    public void testLocatorChainedOption(){
        d.get("https://www.amazon.com/");
        d.findElement(By.xpath("//form[@id=\"nav-search-bar-form\"]//input[@id=\"twotabsearchtextbox\"]")).sendKeys("t-shirts");
        d.findElement(By.xpath("//form[@id=\"nav-search-bar-form\"]//input[@id=\"nav-search-submit-button\"]")).click();
    }

    }

