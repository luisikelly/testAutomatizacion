package webDomestika.pages;

import webDomestika.bases.SeleniumBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DomestikaHomePage extends SeleniumBase {

    public DomestikaHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    final static String categoria ="Cursos online de Diseño Web y App";

    By btnCourses = By.xpath("//a[@id='courses-nav-dropdown']");
    By lateral = By.xpath("//*[@data-track-category='Cursos']");
    By btnGiftCard = By.xpath("//button[@data-track-category='Landing Gift Card']");
    By tituloGiftCrad = By.xpath("//h3[contains(text(),'Tarjeta regalo de Domestika')]");
    By tituloBusqueda = By.xpath("//h1[contains(text(),"+ categoria +")]");
    By campoBusqueda = By.xpath("//*[@placeholder='Buscar cursos']");
    By btnBuscar = By.xpath("//*[@class='ais-SearchBox-submit']");
    By carrito = By.xpath("//a[@data-track-label='/cart']");
    By titleCart = By.xpath("//*[@class='h2 cart__title t-cart-title']");
    By removeCart = By.xpath("//*[contains(@id,'remove-cart-item')][1]");
    By removeMessage = By.xpath("//*[@class='flash-alert flash-alert--success js-flash-alert']");
    By courseFromHome = By.xpath("//*[@class='a-text--small a-text--bold js-amplitude-track']");
    By courseTitle = By.xpath("//*[@class='course-header-new__title']");
    By addToCart = By.xpath("//button[contains(@id,'add-to-cart')]");
    By btnBuy = By.xpath("//*[@class='a-button js-amplitude-track']");
    By domestikaLogo = By.xpath("//a[contains(text(),'DOMESTIKA')]");
    By emailBox = By.id("user_email");
    By passwordBox = By.id("user_password");
    By btnLogin = By.xpath("//*[@class='a-button ']");
    By btnGoToLogin = By.xpath("//a[@class='login']");
    By credentialBox = By.xpath("//*[@class='credentials-box']");
    By alertErrorCredential = By.xpath("//div[contains(@class,'alert')]");
    By languageButton = By.id("languageSelectionDropdownBtn");
    By dropdownMenuLanguage = By.xpath("//div[contains(@class,'dropdown-menu show')]");
    By btnClosePopUp = By.xpath("//button[@class='close']");


    public void search(){
        WebElement search = findElement(btnBuscar);
        search.click();
        waitElementVisible(tituloBusqueda);
    }
    public String setTextSearch(String text){
        setText(campoBusqueda,text);
        return getAttributeValue(campoBusqueda);
    }

    public void selectCategory(String cat){
        List<WebElement> categories = findElements(lateral);
        for (WebElement category: categories) {
            if (category.getText().equals(cat)){
                category.click();
                break;
            }
        }
    }

    public void selectCourses() {
        WebElement btn = findElement(btnCourses);
        btn.click();
    }

    public void addGiftCard(){
        WebElement btnGC = findElement(btnGiftCard);
        Assert.assertEquals("Regala 1 curso",btnGC.getText());
        btnGC.click();
    }

    public void goToCart(){
        WebElement cart = findElement(carrito);
        cart.click();
        waitUrlContains("/cart");
        Assert.assertTrue(findElement(titleCart).getText().contains("Carrito"));
    }

    public String removeFromCart(){
        WebElement remove = findElement(removeCart);
        remove.click();
        waitElementVisible(removeMessage);
        return findElement(removeMessage).getText();
    }

    public void selectCourseFromHome(int i){
        List<WebElement> courses= findElements(courseFromHome);
        i--;
        courses.get(i).click();
        waitElementVisible(courseTitle);
    }
    public void setAddToCart() {
        Assert.assertTrue(getUrl().contains("/course"));
        List<WebElement> buttons = findElements(addToCart);
        buttons.get(2).click();
        waitUrlContains("/cart/interstitial/course/");
        Assert.assertTrue(findElement(btnBuy).isEnabled());
    }

    public void addToCartFromHomeAndGoToHome(int i){
        List<WebElement> buttons = findElements(addToCart);
        buttons.get(i).click();
        waitUrlContains("/cart");
        findElement(domestikaLogo).click();
    }
    public void clickLogin() {
        WebElement login = findElement(btnGoToLogin);
        login.click();
        waitElementVisible(credentialBox);
    }

    public void setTextLogin(String string, String type) {
        switch (type){
            case "email": setText(emailBox,string);
                break;
            case "password": setText(passwordBox,string);
                break;
        }
    }

    public void login() {
        WebElement login = findElement(btnLogin);
        login.click();
    }


    public void loginErrorCredentials() {
        WebElement message = findElement(alertErrorCredential).findElement(By.tagName("b"));
        Assert.assertEquals("El email o la contraseña no son correctos.",message.getText());
    }

    public void clickLanguage() {
        WebElement language = findElement(languageButton);
        language.click();
        waitForElementAndClick(btnClosePopUp);
        language.click();
        waitElementVisible(dropdownMenuLanguage);
    }

    public void changeLanguage(String newLanguage) {
        List<WebElement> dropdownLanguage = findElement(dropdownMenuLanguage).findElements(By.tagName("a"));
        for (WebElement l:dropdownLanguage) {
            if(l.getText().equals(newLanguage)){
                l.click();
            }
        }
        waitUrlContains(getUrlLanguage(newLanguage));

    }


    public String getUrlLanguage(String newLanguage){
        String language ="";
        switch (newLanguage){
            case "Español": language = "es";
                break;
            case "English": language = "en";
                break;
            case "Português": language = "pt";
                break;
            case "Deutsch": language = "de";
                break;
            case "Français": language = "fr";
                break;
            case "Italiano": language = "it";
                break;

        }
        return language;
    }

}
