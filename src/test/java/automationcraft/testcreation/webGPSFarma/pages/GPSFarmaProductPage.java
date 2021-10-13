package automationcraft.testcreation.webGPSFarma.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GPSFarmaProductPage extends SeleniumBase {
    public GPSFarmaProductPage(WebDriver driver) {
        super(driver);
        waitElementVisible(title);
    }

    
    /**
     * Locators
     */

    By btnAdd = By.id("product-addtocart-button");
    By alert = By.xpath("//*[@role='alert']");
    By title = By.xpath("//span[@data-ui-id='page-title-wrapper']");

    /**
     * Keyword Driven
     */

    public String getTitle(){
        return findElement(title).getText();
    }

    public void addToCart() {
        click(btnAdd);
        waitElementVisible(alert);
    }

    public void validateAddToCart(String producto) {
        WebElement message = findElement(alert);
        Assert.assertEquals("Agregaste "+producto+" a tu Carrito.",message.getText());
    }
}
