import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DropDownHAndlin {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void testDropDownOnJobserve(){
        d.get("https://jobserve.com/");
        String location=d.findElement(By.xpath("//*[@id=\"txtLoc\"]")).getText();
        WebElement distance=d.findElement(By.id("selRad"));
        Select distanceselection= new Select(distance);
        distanceselection.selectByVisibleText("Within 15 kms");

        Select adAge= new Select(d.findElement(By.id("selAge")));
        adAge.selectByIndex(3);

        Select jobtype= new Select(d.findElement(By.id("selJType")));
        jobtype.selectByValue("2");

        d.findElement(By.id("txtKey")).sendKeys("Selenium,Sponsorship");
        d.findElement(By.id("btnSearch")).click();
        String text= d.findElement(By.xpath("//h4[@class='cutout2 cct2 jobshead']")).getText();
        System.out.println(text);
        Assert.assertTrue(text.contains("jobs for Selenium,Sponsorship"));
    }
    @Test
    public void testSortInAscendingDropDown(){
        d.get("file:///C:/Users/singh/OneDrive/Desktop/login.html");
        WebElement cars=d.findElement(By.id("cars"));
        Select s= new Select(cars);
        List<WebElement> options=s.getOptions();
        List<String> toBesortedCarList= new ArrayList<>();
        List<String> originalcarList= new ArrayList<>();
        for(WebElement e: options){
            toBesortedCarList.add(e.getText());
            originalcarList.add(e.getText());
        }
        System.out.println("unsorted car list "+ originalcarList);
        Collections.sort(toBesortedCarList);

        System.out.println("Sorted car list: "+ toBesortedCarList);
        System.out.println(toBesortedCarList.equals(originalcarList));

        }
        @Test
    public void testDynamicDropDown() throws InterruptedException {
        d.get("https://www.makemytrip.com/");
        d.manage().window().maximize();
            JavascriptExecutor js=(JavascriptExecutor) d;
        Thread.sleep(2000);
        d.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/span")).click();
        d.findElement(By.xpath("//span[normalize-space()='From']")).click();
            WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(5));
            WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));
            fromInput.sendKeys("Munich");
            WebElement myOption= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']//span[contains(text(),'Munich')]")));
            myOption.click();
    }
    @Test
            public void testVeritas() throws InterruptedException {
    d.get("https://veritasgroup.in/");
    d.manage().window().maximize();
        Thread.sleep(2000);
       // d.findElement(By.xpath())
        d.close();

}}



