package webDomestika.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import webGPSFarma.bases.SeleniumBase;

public class GPSFarmaProductPage extends SeleniumBase {

    public GPSFarmaProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     * Locators
     */
        By addBtn = By.id("product-addtocart-button");
        By message = By.xpath("//*[@class='messages'][1]");
        By textMessage = By.xpath("//*[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");



    /**
     * Keyword Driven
     */

    public void addToCart() {
        click(addBtn);
        waitElementVisible(message);
    }

    public void confirmAddToCart(String product){
        Assert.assertEquals("Agregaste "+product+" a tu Carrito.",getText(textMessage));
    }

}
