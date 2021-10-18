package automationcraft.testcreation.webFarmaonline.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FarmaonlineHomePage extends SeleniumBase {
    public FarmaonlineHomePage(WebDriver driver) {
        super(driver);
    }


        private String searchText;
    /**
     * Locators
     */
    By btnPoint = By.xpath("//a[contains(@href,'puntos-de-retiro')][1]");
    By searchBox = By.xpath("//input[contains(@class,'fulltext-search-box')]");
    By cart = By.xpath("//div[@class='wrapperMinicart']");
    By categories = By.xpath("//div[@class='categorias']");
    By menuCategories = By.xpath("//nav[@id='menu']");
    By locMenu = By.xpath("//div[@class='col-left']/a");
    By btnAdd = By.xpath("//div[contains(@class,'btnAddToCart')]");
    By btnAll = By.xpath("//a[contains(text(),'Ver Todos')][1]");
    By cartBox = By.xpath("//div[contains(@class,'js--minicart')]");
    By count = By.xpath("//*[contains(@class,'minicartHeader__amount')]");
    By btnRemove = By.xpath("//*[@class='minicart__item-remove']");
    By btnAdded = By.xpath("//div[contains(@class,'btnAddToCart added')]");

    /**
     * Keyword driven
     */


    /**
     *
     * @param string
     */
    public void setTextSearch(String string) {
        setText(searchBox,string);
        Assert.assertEquals(string,getAttributeValue(searchBox));
        searchText = string;
    }

    public void search() {
        setKeys(Keys.ENTER,searchBox);
        waitUrlContains(searchText.toLowerCase());
    }

    public void addToCart(int pos) {
        List<WebElement> btnProducts = findElements(btnAdd);
        btnProducts.get(pos).click();
        waitElementVisible(btnAdded);
    }

    public void goToShoppingCart() {
        click(cart);
        waitElementVisible(cartBox);
    }

    public void removeFromShoppingCart() {
        click(btnRemove);
    }

    public void selectCategory(String string) {
        List<WebElement> categories = findElement(menuCategories).findElements(By.tagName("a"));
        for (WebElement c:categories) {
            if(c.getText().equals(string)){
                c.click();
                break;
            }
        }
    }

    public void validateAddToCart() {
    }

    public void validateRemove() {
    }

    public void moveToCategory() {
        WebElement cat = findElement(categories);
        moveToElement(cat);
    }

    public void goToSection(String string) {
        List<WebElement> menu = findElements(locMenu);;
        for (WebElement btn:menu) {
            System.out.println(btn.getText());
            if(btn.getText().equals(string.toUpperCase())){
                btn.click();
                break;
            }
        }
        waitUrlContains(string.toLowerCase());
    }

    public void clickVerTodos() {
        click(btnAll);
        waitUrlContains("busca?fq");
    }
}
