import Util.JSExecutorUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecutorTest {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void testFlashUsingExecutor(){
        d.get("https://www.orangehrm.com");
        WebElement element= d.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div[2]/ul/li[2]/a/button"));
      //  JSExecutorUtil.flash(element,d);
       JSExecutorUtil.drawBorder(element,d);
    }
    @Test
    public void testCaptureTitleOfThepage(){
        d.get(("https://www.orangehrm.com"));
        System.out.println(d.getTitle());
        System.out.println(JSExecutorUtil.getTitle(d));
    }
    @Test
    public void testScrollTillTheEndOfPage(){
        d.get("https://www.orangehrm.com");
        JSExecutorUtil.scrollTillEndOfPage(d);

    }

}
