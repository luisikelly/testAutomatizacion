package webDomestika.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/webDomestika/features"},
        glue = {"webDomestika.steps","webDomestika.bases"},
        plugin ={"pretty"},
        tags = "@test")
public class DomestikaRunner {
}
