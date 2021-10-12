package automationcraft.testcreation.webWAGGGS.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import automationcraft.testcreation.webWAGGGS.bases.SeleniumBase;

import java.util.List;

public class WAGGGSNewsPage extends SeleniumBase {
    public WAGGGSNewsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    /**
     * Loctors
     *
     */
    By checkbox = By.xpath("//*[@class='checkbox']");

    /**
     * Keyword Driven
     */
    /***
     * Seleccionar filtro de busqueda de noticias por una Region
     * @param string Region seleccionada
     */
    public void selectRegionFilter(String string) {
        List<WebElement> region = findElements(checkbox);
        for (WebElement checkboxRegion:region) {
            if(checkboxRegion.getText().equals(string)){
                checkboxRegion.click();
                break;
            }
        }
        waitUrlContains("region=");
    }
}
