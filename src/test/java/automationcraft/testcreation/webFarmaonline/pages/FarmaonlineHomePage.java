package automationcraft.testcreation.webFarmaonline.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FarmaonlineHomePage extends SeleniumBase {
    public FarmaonlineHomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Locators
     */
    By btnPoint = By.xpath("//a[contains(@href,'puntos-de-retiro')][1]");
    By searchBox = By.xpath("//input[contains(@class,'fulltext-search-box')]");
    By cart = By.xpath("//div[@class='wrapperMinicart']");
    By categories = By.xpath("//div[@class='categorias']");
    By menuCategories = By.xpath("//nav[@id='menu']");
    By menu = By.xpath("//div[@class='col-left'][2]");
    By btnAdd = By.xpath("//div[contains(@class,'btnAddToCart')]");
    By btnAll = By.xpath("//a[contains(text(),'Ver Todos')][1]");
    By cartBox = By.xpath("//div[contains(@class,'js--minicart')]");
    By count = By.xpath("//*[contains(@class,'minicartHeader__amount')]");
    By btnRemove = By.xpath("//*[@class='minicart__item-remove']");


    /**
     * Keyword driven
     */


    /**
     *
     * @param string
     */
    public void setTextSearch(String string) {
    }

    public void search() {
    }

    public void addToCart(int pos) {
    }

    public void goToShoppingCart() {
    }

    public void removeFromShoppingCart() {
    }

    public void selectCategory(String string) {
    }

    public void validateAddToCart() {
    }

    public void validateRemove() {
    }

    public void moveTo(String string) {
    }
}
