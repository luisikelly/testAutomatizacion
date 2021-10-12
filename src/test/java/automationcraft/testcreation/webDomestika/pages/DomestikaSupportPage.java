package automationcraft.testcreation.webDomestika.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import automationcraft.testcreation.webDomestika.bases.SeleniumBase;

public class DomestikaSupportPage extends SeleniumBase {
    public DomestikaSupportPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By searchBox =  By.id("query");

    public void setSearchText(String string) {
        setText(searchBox,string);
        Assert.assertEquals(string,getAttributeValue(searchBox));
    }

    public void pressEnterSearchBox(Keys enter) {
        setKeys(Keys.ENTER,searchBox);
    }


}
