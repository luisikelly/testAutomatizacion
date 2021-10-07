package webWAGGGS.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/webWAGGGS/features"},
        glue = {"webWAGGGS.steps","webWAGGGS.bases"},
        plugin ={"pretty"},
        tags = "@test")
public class WAGGGSRunner {
}
