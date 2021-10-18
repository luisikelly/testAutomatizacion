package automationcraft.testcreation.webFarmaonline.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FarmaonlinePuntosRetiroPage extends SeleniumBase {
    public FarmaonlinePuntosRetiroPage(WebDriver driver) {
        super(driver);
    }
/**
 * Locators
 */
    By searchBox = By.xpath("//input[@id='searchInput']");
    By resultSearch = By.xpath("//p[contains(text(),'Resultado de tu búsqueda:')]");

    public void setTextSearch(String arg0) {
        setText(searchBox,arg0);
        Assert.assertEquals(arg0,getAttributeValue(searchBox));
    }

    public void search() {
        setKeys(Keys.ENTER,searchBox);
    }

    public boolean validateSearch() {
        WebElement result = findElement(resultSearch);
        if(result != null){
            return true;
        }else {
            return false;
        }
    }


/**
 * Keyword driven
 */

}
