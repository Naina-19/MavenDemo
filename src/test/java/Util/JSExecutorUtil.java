package Util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecutorUtil {
    public static void flash(WebElement webElement, WebDriver driver){
        String bgcolor= webElement.getCssValue("backgroundcolor");
        System.out.println("color=="+bgcolor);

        for(int i=0;i<1000;i++){
            changeColor("#000000",webElement,driver);
            changeColor(bgcolor, webElement,driver);
        }
    }
    private static void changeColor(String color, WebElement webElement, WebDriver driver) {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.backgroundColor='"+color+"'",webElement);
        try {
            Thread.sleep(100);
        }catch (InterruptedException ex){}
        }
    public static void drawBorder(WebElement webElement,WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='5px solid red'", webElement);
    }
    public static String getTitle(WebDriver driver){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString();
    }
    public static void scrollTillEndOfPage(WebDriver driver){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

}



