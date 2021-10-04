package webWAGGGS.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import webWAGGGS.bases.SeleniumBase;

import java.util.List;

public class WAGGGSHomePage extends SeleniumBase {



    public WAGGGSHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /***
     * Locators
     */
    By searchIcon = By.xpath("//i[@class='icon ion-search']");
    By searchBox = By.name("q");
    By btnIr = By.xpath("//button[contains(@class,'btn-primary rebrand-submit')]");
    By principalBarButtons = By.className("navigation-primary");
    By actualLanguage = By.xpath("//*[@class='header-tools header-tools--lang']");
    By language = By.xpath("//*[@class='header-tools-list-item']");
    By languageList = By.xpath("//*[@class='header-tools-list']");

    public void clickSearchIcon() {
        click(searchIcon);
        waitElementVisible(searchBox);
    }

    public void setTextSearch(String string) {
        setText(searchBox,string);
        Assert.assertEquals(string,getAttributeValue(searchBox));
    }

    public void search() {
        click(btnIr);
        waitUrlContains("search");
    }

    public void goToPage(String page) {
        List<WebElement> buttons = findElement(principalBarButtons).findElements(By.tagName("a"));
        for (WebElement b:buttons) {
            if (b.getText().equals(page)){
                b.click();
            }
        }
    }

    public void selectLanguage(String string) {
        List<WebElement> languages = findElement(language).findElements(By.tagName("a"));
        for (WebElement l:languages) {
            if (l.getText().equals(string)){
                l.click();
            }
        }
    }

    public void clickLanguage() {
        WebElement language = findElement(actualLanguage);
        moveToElement(language);
        waitElementVisible(languageList);
    }
}

