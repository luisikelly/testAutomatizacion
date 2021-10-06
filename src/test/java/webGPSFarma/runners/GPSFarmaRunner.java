package webGPSFarma.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/webGPSFarma/features"},
        glue = {"webGPSFarma.steps","webGPSFarma.bases"},
        plugin ={"pretty"},
        tags = "@test")
public class GPSFarmaRunner {
}
