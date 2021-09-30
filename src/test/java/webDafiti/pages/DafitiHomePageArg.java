package webDafiti.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDafiti.bases.SeleniumBase;

import java.util.List;
import java.util.Locale;

public class DafitiHomePageArg extends SeleniumBase {

    public DafitiHomePageArg(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Locators
    By search = By.name("q");
    By btnSearch = By.xpath("//*[contains(@class,'searchButton')]");
    By categories = By.xpath("//a[contains(@class,'segment')]");
    By sections = By.xpath("//a[contains(@class,'sectionName')]");
    By titleCatalog = By.xpath("//div[contains(@class,'titleCatalog')]");
    By cart = By.id("cart-head");
    By items = By.xpath("//div[@class='itm-product-main-info']");
    By btnAdd = By.xpath("//button[contains(@class,'itm-addToCart')]");
    By removeCart = By.xpath("//a[contains(@class,'removeProductCart')]");




    //Keyword Driven

    /***
     * Ingresa texto al campo de busqueda
     * @param item Item a buscar
     */
    public void setTextSearch(String item){
        WebElement searchBox = findElement(search);
        searchBox.sendKeys(item);
        Assert.assertEquals(item, getAttributeValue(search));

    }

    /***
     *  Search: Presiona el boton de busqueda
     */
    public void search(){
        WebElement buttonSearch = findElement(btnSearch);
        buttonSearch.click();
        waitUrlContains("?q=");
    }


    public void selectCategory(String cat) {
        List<WebElement> catgoriesList = findElements(categories);
        WebElement categorySelected = null;
        for (WebElement category: catgoriesList) {
            if (category.getText().equals(cat.toUpperCase())){
                categorySelected = category;
                break;
            }
        }
        Assert.assertEquals(cat.toUpperCase(), categorySelected.getText());
        moveToElement(categorySelected);
    }

    public void selectSection(String s){
        List<WebElement> sectionList = findElements(sections);
        for (WebElement section: sectionList) {
            if (section.getText().equals(s.toUpperCase())){
                section.click();
                break;
            }
        }
    }


    public void addCart(int pos) {
        List<WebElement> itemsList = findElements(items);
        WebElement item = itemsList.get(pos);
        WebElement add = findElement(btnAdd);
        moveToElement(item);
        add.click();
    }

    public void goToCart() {
        WebElement cartButton = findElement(cart);
        cartButton.click();
        waitUrlContains("cart");
    }

    public void removeCart(int pos){
        List<WebElement> removeButtons = findElements(removeCart);
        WebElement remove = removeButtons.get(pos);
        remove.click();
    }
}
