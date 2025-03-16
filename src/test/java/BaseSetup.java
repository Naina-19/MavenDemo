import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import java.io.*;
import java.util.Properties;
@Getter
@Setter
public class BaseSetup {
    private static Logger log= Logger.getLogger("BaseSetup.class");
    private WebDriver webDriver=null;
    private static Properties objRepo=null;
    private static DriverManagerType browser= null;
    private static final int count=0;
    @Before
    @SneakyThrows
    public void inIt()  {
        if(webDriver==null){
            Class<?>chromeClass= Class.forName(browser.browserClass());
            webDriver = (WebDriver) chromeClass.newInstance();
        }
        log.info("....before of parent class called....");
    }
    @BeforeClass
    public static void setUpForAllTest() throws IOException {
        PropertyConfigurator.configure("log4j.properties");
        log.info("before class");
        objRepo=loadObjectRepository();
        browser=DriverManagerType.valueOf(objRepo.get("browser").toString().toUpperCase());
        WebDriverManager.getInstance(browser).setup();
    }
    private static Properties loadObjectRepository() throws IOException {
        objRepo= new Properties();
        objRepo.load(new FileInputStream(new File("OR.properties")));
        return objRepo;
    }
    public Properties getObjRepo(){
        return objRepo;
    }
    @After
    public void cleanUp(){
        webDriver.close();
    }
    @AfterClass
    public static void cleanUpForBase(){
        objRepo=null;
        log.info("Number"+count);
    }

}
