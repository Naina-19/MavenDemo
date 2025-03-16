import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//import static com.sun.org.apache.xpath.internal.compiler.Token.contains;

public class ShadowDomeDemo {
    WebDriver d;
    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        d = new ChromeDriver();
    }
    /*@Test
    public void testShadowDom() throws NullPointerException{
        d.get("https://shop.polymer-project.org/");
        WebElement shadowHost= d.findElement(By.tagName("shop-app"));
        JavascriptExecutor je=(JavascriptExecutor) d;
       // WebElement shadowDom=(WebElement) je.executeScript("return arguments[0].shadowRoot", shadowHost);
        WebElement shadowRoot = (WebElement)je.executeScript("return arguments[0].shadowRoot", shadowHost);
        WebElement ironPages = shadowRoot.findElement(By.tagName("iron-pages"));
        System.out.println("Iron Pages found: " + ironPages.isDisplayed());

       //WebElement ironPages= shadowRoot.findElement(By.tagName("iron-pages"));
        //WebElement shadowHome= ironPages.findElement(By.name("home"));
        //WebElement shadowDom2= (WebElement) je.executeScript("return argument[0].shadowRoot",shadowHome);
       // WebElement div= shadowDom2.findElement(By.className("announcer"));
       // WebElement element= div.findElement(By.tagName("shop-button"));
    }*/
    @Test
    public void testFindByElement(){
        d.get("https://facebook.com");
        WebElement MyHost= d.findElement(By.xpath("//input[@type=\"text\"]"));
        System.out.println("Number of div=="+ MyHost.findElement(By.xpath("//div")));
        //System.out.println(MyHost.findElement(By.xpath(".//div")));
    }
    @Test
    public void testWindowHandles(){
        d.get("file:///C:/users/singh/OneDrive/Desktop/Naina/My file.html");
        d.findElement(By.linkText("visit BBC!")).click();
        d.findElement(By.linkText("Visit Google!")).click();
        d.findElement(By.linkText("Visit MakeMy Trip!")).click();
        Set<String> windowHandles= d.getWindowHandles();
        for(String id:windowHandles){
            System.out.println("ID: "+id);
            String title= d.switchTo().window(id).getTitle();
            if(title.contains("BBC"))
                break;}
        Map<String,String> m= new HashMap();
        for(String id:windowHandles){
            System.out.println("Id : "+id);
            String title= d.switchTo().window(id).getTitle();
            m.put(title,id);
        }
        for(Map.Entry<String,String> e: m.entrySet()){
            if(e.getKey().contains("BBC")){
               d.switchTo().window(e.getValue());
                System.out.println("Switching to BBC");
                break;
            }
        }

    }

}
