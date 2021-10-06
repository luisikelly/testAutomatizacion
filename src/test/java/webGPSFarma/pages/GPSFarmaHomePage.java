package webGPSFarma.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import webGPSFarma.bases.SeleniumBase;

import java.util.List;
import java.util.Locale;

public class GPSFarmaHomePage extends SeleniumBase {
    public GPSFarmaHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    /**
     * Locators
     */
        By province = By.id("select_region");
        By city = By.id("select_city");
        By btnContinue = By.xpath("//button[@class='button']");
        By location = By.className("open-drugstore-modal");
        By searchBox = By.id("search");
        By menuCategories = By.xpath("//*[contains(@class,'level0')]");
        By submenuCategories = By.xpath("//ul[contains(@class,'level0 submenu')][1]");
        By productItem = By.className("product-item-link");
        By btnAdd = By.xpath("//button[@type='submit']");
        By countProducts = By.xpath("//*[contains(@class,'counter-number')]");
        By addCartMessage = By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']");
        By cart = By.xpath("//a[@class='action showcart']");
        By titleCart = By.xpath("//span[@data-bind=\"i18n: 'My Cart'\"]");
        By productCart = By.xpath("//div[@class='product']");
        By btnRemoveCart = By.xpath("//a[@title='Eliminar artículo']");
        By acceptRemoveCart = By.xpath("//*[@class='action-primary action-accept']");
        By sorter = By.id("sorter");

    /**
     * Keyword Driven
     */



    public void selectCity(String c) {
       selectByVisibleText(city,c);
    }

    public void sendLocation() {
        click(btnContinue);
        waitElementClickable(location);
    }

    public void selectProvince(String prov) {
        selectByVisibleText(province,prov);
    }

    public void confirmLocation(String prov, String city) {
        List<WebElement> loc = findElement(location).findElements(By.tagName("span"));
        Assert.assertEquals(prov +" -",loc.get(0).getText());
        Assert.assertEquals(city +" -", loc.get(1).getText());
    }

    public void setSearchText(String text) {
        setText(searchBox,text);
        Assert.assertEquals(text,getAttributeValue(searchBox));
    }

    public void search() {
        setKeys(Keys.ENTER,searchBox);
        waitUrlContains("/result/?q=");
    }

    public void selectCategory(String string) {
        List<WebElement> menu = findElements(menuCategories);
        WebElement categories = menu.get(0);
       moveToElement(categories);
        List<WebElement> submenu = findElement(submenuCategories).findElements(By.tagName("a"));
        for (WebElement cat: submenu) {
            if(cat.getAttribute("href").contains(string.toLowerCase())){
                cat.click();
                break;
            }
        }
        waitUrlContains("categorias/"+string.toLowerCase());
    }

    public void addToCartFromHome(String pName) {
        List<WebElement> listItems = findElements(productItem);
        for (WebElement item: listItems) {
            WebElement add = item.findElement(btnAdd);
            if (item.getAttribute("title").equals(pName)){
                add.click();
                break;
            }
        }
    }

    public void confirmAddToCart(String prod) {
       //TODO Falta implementar
    }

    public void goToCart() {
        click(cart);
        waitElementVisible(titleCart);
    }

    public void removeFromCart(String product) {
        List<WebElement> porducts = findElements(productCart);
        for (WebElement prod:porducts) {
           // if (prod.findElement(productName).getText().equals(product)){
           //     prod.findElement(btnRemoveCart).click();
           //     break;
            //}
        }
    }

    public void acceptRemove() {
        click(acceptRemoveCart);
        // Falta algun wait
    }

    public void selectProduct(String arg0) {
        List<WebElement> listItems = findElements(productItem);
        for (WebElement item: listItems) {
            WebElement add = item.findElement(btnAdd);
            if (item.getAttribute("title").equals(arg0)){
                item.click();
                break;
            }
        }
    }

    public void orderBy(String string) {
        selectByVisibleText(sorter,string);
       if(!string.equals("Nombre del Producto")){
           waitUrlContains("?product_list_order");
       }
    }

    public void selectSection(String string) {
        String urlCategory="";
        switch (string){
            case "Skincare": urlCategory = string.toLowerCase();
                break;
            case "CATEGORÍAS": urlCategory = "categorias";
                break;
            case "OFERTAS": urlCategory = "ofertas";
                break;
            case "Cosmética Natural": urlCategory = "cosmetica-natural";
                break;
            case "Hogar": urlCategory = "hogar";
                break;
            case "Bebés y Mamás": urlCategory = "cuidado-del-bebe";
                break;
            case "Nutrición": urlCategory = "menu-electro";
                break;
            case "DADAgóndola": urlCategory = "dadagondola";
                break;
        }
        By elementName = By.xpath("//span[contains(text(),"+string+")]");
        List<WebElement> menu = findElements(menuCategories);
        for (WebElement elementMenu:menu) {
            if (elementMenu.findElement(By.tagName("a")).getAttribute("href").contains(urlCategory)){
                elementMenu.click();
                break;
            }
        }
    }
}
