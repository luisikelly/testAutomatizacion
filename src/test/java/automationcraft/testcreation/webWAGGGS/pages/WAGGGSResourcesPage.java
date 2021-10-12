package automationcraft.testcreation.webWAGGGS.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import automationcraft.testcreation.webWAGGGS.bases.SeleniumBase;

public class WAGGGSResourcesPage extends SeleniumBase {

    public WAGGGSResourcesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    String resource = "";
    /***
     * Locators
     */

    By searchBox = By.name("search");
    By searchBtn = By.xpath("//*[@class='ion-search']");
    By titleResource = By.xpath("//*[@class='resource-list-title']");

    /***
     *  Keyword Driven
     */

    /***
     * Preisonar boton buscar
     */

    public void search() {
        click(searchBtn);
        waitUrlContains("resource-listing/?search=");
    }

    /**
     *  Ingresar texto al campo de busqueda
     * @param arg0 Texto a buscar
     */
    public void setSearchText(String arg0) {
        setText(searchBox,arg0);
        Assert.assertEquals(arg0,getAttributeValue(searchBox));
    }


}
