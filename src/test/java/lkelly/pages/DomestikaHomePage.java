package lkelly.pages;

import lkelly.bases.SeleniumBase;
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
    By courses = By.xpath("//ul[@class='nav nav--lateral'][1]");
    By categorias = By.xpath("//ul[@class='nav nav--lateral'][2]");
    By btnGiftCard = By.xpath("//button[@data-track-category='Landing Gift Card']");
    By tituloGiftCrad = By.xpath("//h3[contains(text(),'Tarjeta regalo de Domestika')]");
    By tituloBusqueda = By.xpath("//h1[contains(text(),"+ categoria +")]");
    By campoBusqueda = By.xpath("//header/nav[@id='js-mainnav']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/input[1]");
    By btnBuscar = By.xpath("//button[@class='ais-SearchBox-submit']");




    public void search(){
        WebElement search = findElement(btnBuscar);
        search.click();
    }
    public void setTextSearch(String text){
        setText(campoBusqueda,text);
    }

    public void selectCategory(String cat){
        List<WebElement> categories = findElements(categorias);
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

    public void selectCourse(String cat) {
        List<WebElement> coursesList = findElements(courses);
        for (WebElement c: coursesList) {
            if (c.getText().equals(cat)){
                c.click();
                break;
            }
        }

    }
}
