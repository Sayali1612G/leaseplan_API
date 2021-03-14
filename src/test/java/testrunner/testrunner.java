package testrunner;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty", "junit:target/cucumber.xml"},
        monochrome = true,
        features = "src/test/resources/features",
        tags = "@Leaseplan",
        glue = "stepdefinations"
)

public class testrunner {

}
