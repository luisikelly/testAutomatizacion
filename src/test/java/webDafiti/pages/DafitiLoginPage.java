package webDafiti.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDafiti.bases.SeleniumBase;

public class DafitiLoginPage extends SeleniumBase {
    public DafitiLoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //Locators
        By emailBox = By.id("LoginForm_email");
        By passwordBox = By.id("LoginForm_password");
        By messageErrorEmail = By.xpath("//label[@class='error'][1]");
        By messageErrorPassword = By.xpath("//label[@class='error'][1]");
        By btnIngresar = By.id("loginButton");

    //Keyword Driven

    public void setText(String text, String type) {
        switch (type){
            case "email": setText(emailBox,text);
                break;
            case "password": setText(passwordBox,text);
            break;
        }


    }

    public void clickIngresar() {
        WebElement ingresar = findElement(btnIngresar);
        ingresar.click();
    }


    public void validateMessageError(String string, String string2) {
        WebElement messageError = null;
        switch (string2){
            case "email": messageError = findElement(messageErrorEmail);
                break;
            case "password": messageError = findElement(messageErrorPassword);
                break;
        }
        Assert.assertEquals(string,messageError.getText());
    }
}
