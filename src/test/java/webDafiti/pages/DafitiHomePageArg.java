package webDafiti.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;
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
    By cart = By.id("cart-head");
    By items = By.xpath("//div[@class='itm-product-main-info']");
    By btnAdd = By.xpath("//button[contains(@class,'btn-add-cart')]");
    By itemTitle = By.xpath("//*[@class='itm-title']");
    By cartBox = By.xpath("//*[contains(@class,'cartBox')]");
    By titleCatalog = By.xpath("//*[contains(@class,'titleCatalog mts mbl')]");
    By checkboxes = By.xpath("//a[contains(@data-label,'size')]");
    By btnApplyFilter = By.xpath("//*[contains(@class,'applyFilterButton')]");
    By newsLetterBox = By.id("newsletter-email");
    By buttonsNewsletter = By.name("subscription");
    By messageNewsletterBox = By.xpath("//*[contains(@class,'sel-message-error')]");
    By login = By.id("LoginInfoTag");
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
        waitElementVisible(titleCatalog);
    }

    public void selectProduct(String prod){
        List<WebElement> itemsList = findElements(items);
        WebElement item = null;
        for (WebElement product:itemsList) {
            if(product.findElement(itemTitle).getText().equals(prod)){
                item = product;
                break;
            }
        }
        moveToElement(item);
       // waitElementClickable(btnAdd);
    }

    public void addCart() {
        WebElement add = findElement(btnAdd);
        add.click();
        waitElementVisible(cartBox);
    }
    public void cartBoxDisplayed(){
        WebElement cart = findElement(cartBox);
        Assert.assertTrue(cart.isDisplayed());
    }

    public void goToCart() {
        WebElement cartButton = findElement(cart);
        cartButton.click();
        waitUrlContains("cart");
    }

    public void filterBySize(String size){
        List<WebElement> checkbox = findElements(checkboxes);
        for (WebElement option:checkbox) {
            if(option.getAttribute("data-value").equals(size)){
                option.click();
                break;
            }
        }

    }

    public void applyFilterSize() {
        List<WebElement> btnsApply = findElements(btnApplyFilter);
        WebElement btnApply = btnsApply.get(0);
        btnApply.click();
        waitUrlContains("size=");
    }

    public void setTextNewletter(String email) {
        WebElement emailBox = findElement(newsLetterBox);
        emailBox.sendKeys(email);
    }

    public void clickBtnNewsletter(String type) {
        List<WebElement> buttons = findElements(buttonsNewsletter);
        switch (type){
            case "Soy Mujer":
                for (WebElement b: buttons) {
                    if(b.getAttribute("value").equals("female")){
                        b.click();
                        break;
                    }
                }
                break;
            case "Soy Hombre":
                for (WebElement b: buttons) {
                    if(b.getAttribute("value").equals("male")){
                        b.click();
                        break;
                    }
                }
                break;
        }
    }

    public void getMessageNewsletter(String m) {
        WebElement message = findElement(messageNewsletterBox);
        Assert.assertEquals(m,message.getText());
    }

    public void goToLogin() {
        WebElement loginBtn = findElement(login);
        loginBtn.click();
        waitUrlContains("login");
    }
}
