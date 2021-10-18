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
    By btnRemove = By.xpath("//*[@class='minicart__item-remove']");
    By btnAdded = By.xpath("//div[contains(@class,'btnAddToCart added')]");
    By btnAddOfffer = By.xpath("//div[@class='product-item_btnAddToCart']");
    By amountProducts = By.xpath("//span[contains(@class,'minicartHeader__amount')]");
    By itemCart = By.xpath("//div[@class='minicart__item']");
    By closePopupNewsletter = By.xpath("//a[contains(text(),'×')]");
    By emailNewsletter = By.xpath("//input[@id='emailP']");
    By submitNewsletter = By.xpath("//button[@id='btn-submit']");
    By popupNewsletter = By.xpath("//div[@id='newsletterPopup']");
    By fieldsetNewsletterInvalid = By.xpath("//fieldset[@class='invalid']");
    By withdrawalPoint = By.xpath("//a[contains(text(),'Puntos de Retiro')]");

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
        waitInvisibilityOf(itemCart);
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

    public String getNumberOfProductsInTheCart() {
        WebElement count = findElement(amountProducts);
        return count.getText();
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

    public void addToCartFromHome() {
        List<WebElement> btnsAdd = findElements(btnAddOfffer);
        btnsAdd.get(0).click();
    }
    public void closePopupNewsletter(){
        click(closePopupNewsletter);
    }

    public void setEmailNewsletter(String arg0) {
        setText(emailNewsletter,arg0);
        Assert.assertEquals(arg0,getAttributeValue(emailNewsletter));
    }

    public void confirmSuscription() {
        click(submitNewsletter);
        waitInvisibilityOf(popupNewsletter);
    }

    public boolean emailInvalid() {
        if(findElement(fieldsetNewsletterInvalid) != null){
            return true;
        }else{
            return false;
        }
    }

    public void clickWithdrawalPoint() {
        click(withdrawalPoint);
        waitUrlContains("puntos-de-retiro");
    }
}
