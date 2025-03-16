import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class XPathAxes extends BaseSetup {
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
    public void testLocatorXpathAxes() {
        d.get("https://money.rediff.com/index.html");
        d.manage().window().maximize();
        String text = d.findElement(By.xpath("//a[contains(text(),'Vodafone Idea L')]/self::a")).getText();
        System.out.println(text);
    }
    @Test
            public void testLocatorXpathAxes1(){
        d.get("https://money.rediff.com/index.html");
        d.manage().window().maximize();
        String text1=d.findElement(By.xpath("//a[contains(text(),'Vodafone Idea L')]/parent::li")).getText();
        System.out.println(text1);
    }

}
