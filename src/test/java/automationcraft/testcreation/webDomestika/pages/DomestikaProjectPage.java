package automationcraft.testcreation.webDomestika.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DomestikaProjectPage extends SeleniumBase {
    public DomestikaProjectPage(WebDriver driver) {
        super(driver);
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
