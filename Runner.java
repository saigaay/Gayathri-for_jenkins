package runner_class;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src/test/java/features",
	    glue = {"stepDefinitions"},
	    tags = "@CRM_counting_dashlets",
	    plugin = {"html: test-reports"},
	    strict = true
	    	)
public class Runner {
	
	
}
