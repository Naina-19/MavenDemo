import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class UsingDatePicker {
    WebDriver d;
    @Before
    public void init(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
    }
    @Test
    public void testDatePicker() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
        String expecteddate = "10-January-2026";
        String[] dateArray = expecteddate.split("-");
        String eMonth = dateArray[1];
        String eDate = dateArray[0];
        String eYear = dateArray[2];
        d.get("https://mui.com/x/react-date-pickers/");
        d.manage().window().maximize();

        d.findElement(By.xpath("//*[@id=\"main-content\"]/div[10]/div/div/div[1]/div[2]/div/div[1]/div")).click();
        String currentElement = d.findElement(By.xpath("//*[@id=\":r3:-grid-0-label\"]")).getText();
        //System.out.println("My current date is:="+ currentElement);
        String[] currentdateArray = currentElement.split(" ");
        String currentMonth = currentdateArray[0];
        System.out.println("My month is: " + currentMonth);
        String currentyear = currentdateArray[1];
        System.out.println("My year is : " + currentyear);
        while (!eMonth.equals(currentMonth) || (!eYear.equals(currentyear))) {
            d.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/div[2]/div[1]/button[2]")).click();
            currentElement = d.findElement(By.xpath("//*[@id=\":r3:-grid-0-label\"]")).getText();
            System.out.println("My current date is:=" + currentElement);
            currentdateArray = currentElement.split(" ");
            currentMonth = currentdateArray[0];
            System.out.println("My month is: " + currentMonth);
            currentyear = currentdateArray[1];
            System.out.println("My year is : " + currentyear);
        }
       // List<WebElement> dates = d.findElements((By.xpath("//button[@role='gridcell']")));
        List<WebElement> dates = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy((By.xpath("/html/body/div[2]/div[2]/div/div/div/div[1]/div[2]/div[2]/div/div[2]/div[7]/div/button"))));
        System.out.println("Dates are= " + dates.size());
        Thread.sleep(2000);
        for (WebElement e : dates) {
            if (e.getText().trim().equals(eDate)) {
                Thread.sleep(2000);
               // d.navigate().refresh();
                e.click();
                break;
            }
        }
        /*@Test
                public void testDatePicker1(){
            WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(10));
            String expecteddate = "10-January-2026";
            String[] dateArray = expecteddate.split("-");
            String eMonth = dateArray[1];
            String eDate = dateArray[0];
            String eYear = dateArray[2];

            d.get("https://mui.com/x/react-date-pickers/");

            // Click the date picker input field
            WebElement datePicker = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class,'MuiInputBase-input')]")));
            datePicker.click();

            // Get current month and year
            WebElement currentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'MuiPickersCalendarHeader-label')]")));
            String[] currentdateArray = currentElement.getText().split(" ");
            String currentMonth = currentdateArray[0];
            String currentyear = currentdateArray[1];

            // Navigate to expected month and year
            while (!eMonth.equals(currentMonth) || !eYear.equals(currentyear)) {
                WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Next month']")));
                nextButton.click();
                currentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'MuiPickersCalendarHeader-label')]")));
                currentdateArray = currentElement.getText().split(" ");
                currentMonth = currentdateArray[0];
                currentyear = currentdateArray[1];
            }

            // Select the correct date
            List<WebElement> dates = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@role='gridcell']")));
            for (WebElement e : dates) {
                if (e.getText().trim().equals(eDate)) {
                    e.click();
                    break;
                }
            }

            // Close browser
            d.quit();*/
        }
    }


