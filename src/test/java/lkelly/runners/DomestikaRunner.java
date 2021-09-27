package lkelly.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/lkelly/features"},
        glue = {"lkelly.steps","lkelly.bases"},
        plugin ={"pretty"},
        tags = "@compras")
public class DomestikaRunner {
}
