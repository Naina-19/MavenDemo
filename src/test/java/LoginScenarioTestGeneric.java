import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginScenarioTestGeneric extends BaseSetup
{
   // private final Logger log = Logger.getLogger("LoginScenarioTestGeneric.class");
    private Logger log= Logger.getLogger(Log.class.getName());
    private WebDriver d;
    private Properties p;
    @Before
    public void setUp(){
        d=getWebDriver();
        p=getObjRepo();
        log.info("Child class before called");}

    @Test
    @SneakyThrows
    public void testSuccessfulLogin() {
        log.info("....String test successfull login.....");
        d.get(p.get("url").toString());
        WebElement uName= d.findElement(By.xpath(p.get("username").toString()));
        uName.sendKeys(p.get("uname_val").toString());
        Thread.sleep(2000);
       // d.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        WebElement uPassword= d.findElement(By.xpath(p.get("password").toString()));   //*[@id="password"]
        uName.sendKeys(p.get("upass_val").toString());
        WebElement loginButton= d.findElement(By.xpath(p.get("login_btn").toString()));
        loginButton.click();
        WebElement element= d.findElement(By.xpath(p.get("error_message").toString()));
        //String xpath = p.get("product_label").toString();
       // WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
        //WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        Assert.assertEquals("Epic sadface: Password is required",element.getText());
        log.info(".....Ending testsuccessful login executed.....");
    }


}
