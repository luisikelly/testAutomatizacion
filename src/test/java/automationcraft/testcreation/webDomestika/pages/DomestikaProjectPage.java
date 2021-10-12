package automationcraft.testcreation.webDomestika.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import automationcraft.testcreation.webDomestika.bases.SeleniumBase;

import java.util.List;

public class DomestikaProjectPage extends SeleniumBase {
    public DomestikaProjectPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By filters = By.xpath("//ul[@class='nav nav-pills'][1]");

    public void filterProjects(String filter) {
        List<WebElement> filterList = findElement(filters).findElements(By.tagName("a"));
        for (WebElement f:filterList) {
            if(f.getText().equals(filter)){
                f.click();
                break;
            }
        }
        waitUrlContains("projects/");
    }
}
