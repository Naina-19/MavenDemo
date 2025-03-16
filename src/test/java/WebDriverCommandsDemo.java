import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WebDriverCommandsDemo {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void testGetCommands(){
        d.get("https://www.makemytrip.com");
        System.out.println("Current Title is :"+ d.getTitle());
        System.out.println("Current Url is "+ d.getCurrentUrl());
        //System.out.println("Page source is "+d.getPageSource());
        //System.out.println("Window handle is "+ d.getWindowHandle());
        d.close();
    }
@Test
    public void testCloseAndQuitMethod() {
    d.get("https://www.google.com");
    d.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[2]")).click();
    d.close();
    //d.quit();
}
    @Test
            public void testWindowHandles(){
        d.get("https://www.google.com");
        d.findElement(By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[3]/center[1]/input[2]")).click();
       // d.findElement(By.xpath("//body/div[@id='content']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[4]/img[1]")).click();
        Set<String> WindowHandles= d.getWindowHandles();
        System.out.println("Total tabs opened " +WindowHandles.size());
        String parentWindowHandle= d.getWindowHandle();
        Iterator<String> iterator= WindowHandles.iterator();
        while(iterator.hasNext()){
            String reference_childwindow= iterator.next();
            d.switchTo().window(reference_childwindow);
            System.out.println("The title of page is "+d.getTitle());
        d.close();
        }
    }
    @Test
    public void testNavigate(){
        d.get("https://www.bbc.com");
        String firstUrl= d.getCurrentUrl();
        System.out.println("The first url is: "+firstUrl);
        d.navigate().to("https://www.facebook.com");
        d.navigate().to("https://www.makemytrip.com");
        String lastUrl= d.getCurrentUrl();
        System.out.println("The last url is =="+lastUrl);
    }
}
