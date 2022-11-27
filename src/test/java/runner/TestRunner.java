package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "json:target/report/Cucumber.json",
        },
        features = {"src/test/java/feature/"},
        glue = {"/stepDefinition"},
        tags = "@API",
        dryRun = false,
        stepNotifications = true)

public class TestRunner {
}
