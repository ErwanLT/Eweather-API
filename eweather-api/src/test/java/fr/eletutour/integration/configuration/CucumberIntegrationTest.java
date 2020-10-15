package fr.eletutour.integration.configuration;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import fr.eletutour.integration.steps.SpringIntegrationTest;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
                 glue = "fr.eletutour.integration")
public class CucumberIntegrationTest extends SpringIntegrationTest {
}