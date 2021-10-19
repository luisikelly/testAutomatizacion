package webDafiti.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDafiti.bases.SeleniumBase;

import java.util.List;

/***
 * @author Luisina.Kelly
 * @version 1
 */

public class DafitiHomePage extends SeleniumBase {
    public DafitiHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    final static String arg = ".ar";
    final static String cl = ".cl";
    final static String br = ".br";
    final static String co = ".co";

    //Locators
    By countries = By.className("footer");

    //Keyword Driven

    /***
     * Seleccionar país de operación
     * @param countryName Nombre del país
     */

    public void selectCountry(String countryName){
        List<WebElement> countriesList = findElement(countries).findElements(By.tagName("a"));
        for (WebElement country: countriesList) {
            if(country.getText().equals(countryName)) {
                country.click();
                break;
            }
        }
        waitUrlContains(arg);
    }

}
