package automationcraft.testcreation.webDomestika.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class DomestikaSupportPage extends SeleniumBase {
    public DomestikaSupportPage(WebDriver driver) {
        super(driver);
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
