package webDafiti.bases;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AppHook {
    //contiene las configuraciones basicas de los Test a ejecutar

    //atributos
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @Before(order =0)
    public static void initialiseBrowser() {
        WebDriverManager.chromedriver().setup();
    }

    @Before(order = 1)
    public void setupBrowser() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,15);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @After
    public void cleanup() {
        if (driver != null) driver.close();
    }

    public static WebDriver getDriver(){
        return driver;
    }
    public static WebDriverWait getWait(){return wait;}

}
