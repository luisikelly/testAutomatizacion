package webDafiti.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/webDafiti/features"},
        glue = {"webDafiti.steps","webDafiti.bases"},
        plugin ={"pretty"},
        tags = "@removeCart")
public class DafitiRunner {
}
