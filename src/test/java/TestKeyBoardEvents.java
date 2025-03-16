import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.fenum.qual.SwingTextOrientation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestKeyBoardEvents {
    private WebDriver d;
    @Before
    public void myDriver() {
        WebDriverManager.chromedriver().setup();
        d = new ChromeDriver();
    }
    @Test
    public void testShiftKeyEvent() throws InterruptedException {
        d.manage().window().maximize();
        Thread.sleep(2000);
        WebElement element=d.findElement(By.xpath("//*[@id=\"email\"]"));
        Actions actions= new Actions(d);
        actions.keyDown(element, Keys.SHIFT);
        actions.sendKeys("naina");
        actions.keyUp(Keys.SHIFT);
        actions.build().perform();

    }
    @Test
    public void testShortCutCandV() throws InterruptedException {
        d.get("https://www.facebook.com/");
        d.manage().window().maximize();
        Thread.sleep(1000);
        WebElement element = d.findElement(By.xpath("//*[@id=\"email\"]"));
        Actions actions = new Actions(d);
        actions.keyDown(element, Keys.SHIFT).sendKeys("naina").keyUp(Keys.SHIFT).perform();

        //Select the entered text
        actions.keyDown(element,Keys.CONTROL).sendKeys("a").keyUp(element,Keys.CONTROL).perform();

        //copy the text
        actions.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

        //go to the next password textbox
        actions.keyDown(Keys.TAB).perform();

        //paste the entered text here
        WebElement elementnext= d.findElement(By.xpath("//*[@id=\"pass\"]"));
        actions.keyDown(elementnext,Keys.CONTROL).sendKeys("v").keyUp(element,Keys.CONTROL).perform();
    }
    @Test
    public void testRightClick(){
        d.get("https://www.facebook.com/");
        d.manage().window().maximize();
        WebElement username= d.findElement(By.xpath("//*[@id=\"email\"]"));
        Actions actions= new Actions(d);
        actions.contextClick(username).perform();
    }
    @Test
    public void testDragAndDrop() {
        d.get("https://sortablejs.github.io/Sortable/#simple-list");
        d.manage().window().maximize();
        Actions action = new Actions(d);
        WebElement from = d.findElement(By.xpath("//*[@id=\"example2-left\"]/div[1]"));
        WebElement to = d.findElement(By.xpath("//*[@id=\"example2-right\"]/div[1]"));
        action.dragAndDrop(from, to).perform();
    }
}
