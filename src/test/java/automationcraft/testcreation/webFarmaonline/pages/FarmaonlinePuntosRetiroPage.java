package automationcraft.testcreation.webFarmaonline.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FarmaonlinePuntosRetiroPage extends SeleniumBase {
    public FarmaonlinePuntosRetiroPage(WebDriver driver) {
        super(driver);
    }
/**
 * Locators
 */
    By searchBox = By.xpath("//input[@id='searchInput']");
    By resultSearch = By.xpath("//p[contains(text(),'Resultado de tu búsqueda:')]");


/**
 * Keyword driven
 */

}
