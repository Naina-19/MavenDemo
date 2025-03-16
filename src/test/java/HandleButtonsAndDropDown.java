import Util.JSExecutorUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class HandleButtonsAndDropDown {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
}
@Test
public void testCheckBox(){
        d.get("file:///C:/Users/singh/OneDrive/Desktop/login.html");
        WebElement checkBox= d.findElement(By.xpath("/html/body/div[2]/form/div/input[2]"));
        if(!checkBox.isSelected()){
            checkBox.click();
        }
    }
    @Test
    public void testRadioButton(){
       d.get("file:///C:/Users/singh/OneDrive/Desktop/login.html");
       WebElement radioButton=d.findElement(By.xpath("/html/body/div[2]/form/div/input[1]"));
       if(!radioButton.isEnabled()){
           System.out.println("Java radio button is disabled");
       }
       WebElement radioButton2=d.findElement(By.xpath("/html/body/div[2]/form/div/input[7]"));
       if(!radioButton2.isSelected()){
           radioButton2.click();
       }
    }
    @Test
    public void testDropDown() throws InterruptedException {
        d.get("https://opensource-demo.orangehrmlive.com/");
        d.manage().window().maximize();

        // Log in to OrangeHRM
        d.findElement(By.name("username")).sendKeys("Admin");
        d.findElement(By.name("password")).sendKeys("admin123");
        d.findElement(By.cssSelector("button[type='submit']")).click();

        // Wait for page load
        Thread.sleep(3000);

        // Navigate to the Admin module
        d.findElement(By.xpath("//span[text()='Admin']")).click();
        Thread.sleep(2000);

        // Locate the dropdown (Example: User Role in Admin panel)
        WebElement dropdownElement = d.findElement(By.xpath("//label[text()='User Role']/following::div[1]"));

        // Click dropdown to reveal options
        dropdownElement.click();
        Thread.sleep(1000);

        // Select "Admin" from dropdown
        WebElement adminOption = d.findElement(By.xpath("//span[text()='Admin']"));
        adminOption.click();

        // Close the browser after some delay
        Thread.sleep(3000);
        d.quit();
    }
}
