package automationcraft.testcreation.webWAGGGS.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class WAGGGSGuiasArgentinasPage extends SeleniumBase {
    public WAGGGSGuiasArgentinasPage(WebDriver driver) {
        super(driver);
    }

    
    /**
     * Locators
     */

    By communties = By.xpath("//a[contains(@href,'comunidades-guias')]");
    By provinces = By.className("rich-text");
    /**
     * Keyword Driven
      */
    public void goToCommunities() {
        click(communties);
        waitUrlContains("comunidades-guias");
    }

    public void selectProvince(String string) {
        List<WebElement> provinceList = findElement(provinces).findElements(By.tagName("a"));
        for (WebElement prov:provinceList) {
            if (prov.getText().equals(string)){
                prov.click();
                break;
            }
        }
        waitUrlContains("maps");
    }
}
