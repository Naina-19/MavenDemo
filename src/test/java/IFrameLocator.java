import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameLocator {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void testLocateiFrame(){
        d.get("https://demoqa.com/frames");
        System.out.println(d.findElement(By.tagName("iframe")).getSize());
        d.switchTo().frame("frame1");
        String sampleHeading=d.findElement(By.id("sampleHeading")).getText();
        System.out.println(sampleHeading);
    }
    @Test
    public void testNestediFrame() {
        d.get("https://demoqa.com/nestedframes");
        WebElement frame1 = d.findElement(By.id("frame1"));
        d.switchTo().frame(frame1);
        WebElement frame1Element= d.findElement(By.tagName("body"));
        d.switchTo().frame(0);
        d.close();
    }
    @Test
    public void testBackToBase(){
        d.get("https://demoqa.com/nestedframes");
        WebElement frame1 = d.findElement(By.id("frame1"));
        d.switchTo().frame(frame1);
        WebElement frame1Element= d.findElement(By.tagName("body"));
        d.switchTo().frame(0);


    }

}
