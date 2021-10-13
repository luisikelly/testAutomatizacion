package automationcraft.testcreation.webGPSFarma.pages;

import automationcraft.engine.database.MongoDBManage;
import automationcraft.engine.database.models.LocationData;
import automationcraft.engine.selenium.SeleniumBase;
import org.bson.Document;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GPSFarmaHomePage  extends SeleniumBase {
    public GPSFarmaHomePage(WebDriver driver) {
        super(driver);
    }


    MongoDBManage manageDB;
    LocationData locationData;
    /**
     * Locators
     */

    By searchBox = By.name("q");
    By menu = By.xpath("//a[contains(@class,'level-top')]");
    By location = By.xpath("//*[@class='open-drugstore-modal']");
    By region = By.xpath("//select[@id='select_region']");
    By city = By.xpath("//select[@id='select_city']");
    By btnContinue = By.xpath("//*[@class='button']");
    By categories = By.xpath("//*[contains(@class,'level1')]/a/span");//*[contains(@class,'level1')]");
    By sorter = By.id("sorter");
    By products = By.className("product-item-link");
    By popupLocation = By.xpath("//*[@class='modal-geolocation']");//div[@class='modal-inner-wrap'][2]");



    /**
     * Keyword Driven
     */

    public void goToHome(String url){
        goToUrl(url);
        waitElementVisible(region);
    }
    public void selectProvince(String string) {
        locationData = new LocationData();
        selectByVisibleText(region,string);
        locationData.setProvince(string);
        //Assert.assertEquals(string,getAttributeValue(region));
    }


    public void selectCity(String string) {
        selectByVisibleText(city,string);
        locationData.setCity(string);
       // Assert.assertEquals(string,getAttributeValue(city));
    }

    public void submitLocation() {
        click(btnContinue);
        manageDB = new MongoDBManage("testGPSFarma");
        manageDB.insertObject("location",locationData,LocationData.class);
    }

    public void moveTo(String string) {
        List<WebElement> menuItems = findElements(menu);
        WebElement menuItem = null;
        for (WebElement item:menuItems) {
            if(item.getText().equals(string.toUpperCase())){
                moveToElement(item);
                //menuItem = item;
                break;
            }
        }
        //moveToElement(menuItem);
    }

    public void selectCategory(String string) {
        List<WebElement> categoriesList = findElements(categories);
        for (WebElement category:categoriesList) {
            if(category.getText().equals(string.toUpperCase())){
                category.click();
                break;
            }
        }
        waitUrlContains("/categorias");
    }

    public void selectMenu(String string) {
        List<WebElement> menuItems = findElements(menu);
        for (WebElement item:menuItems) {
            if(item.getText().equals(string)){
               item.click();
                break;
            }
        }
    }

    public void setTextSearch(String string) {
        setText(searchBox,string);
        Assert.assertEquals(string,getAttributeValue(searchBox));
    }

    public void search() {
        setKeys(Keys.ENTER,searchBox);
        waitUrlContains("result/?q=");
    }

    public void orderBy(String string) {
        selectByVisibleText(sorter,string);
        manageDB = new MongoDBManage("testGPSFarma");
        Document filter = new Document("filter",string);
        List<Document> result = manageDB.getDocuments(filter,"orderFilters");
        waitUrlContains(result.get(0).getString("url"));
    }


    public void validateOrderBy(String arg0) {
        manageDB = new MongoDBManage("testGPSFarma");
        Document filter = new Document("filter",arg0);
        List<Document> result = manageDB.getDocuments(filter,"orderFilters");
        String urlResult = result.get(0).getString("url");
        Assert.assertTrue(getUrl().contains(urlResult));
    }


    public void selectProduct(String prod) {
        waitElementClickable(products);
        List<WebElement> offers = findElements(products);
        for (WebElement product:offers) {
            if (product.getText().equals(prod)){
                product.click();
                break;
            }
        }
    }

    public void validateLocation() {
        WebElement loc = findElement(location);
        String prov = manageDB.getLastDocument("location").getString("province");
        String city = manageDB.getLastDocument("location").getString("city");
        System.out.println(prov+" - "+city);
        Assert.assertTrue(loc.getText().contains(prov+" - "+city));
    }
}
