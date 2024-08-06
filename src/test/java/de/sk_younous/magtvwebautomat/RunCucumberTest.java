package de.sk_younous.magtvwebautomat;//package de.sk_younous.magtvwebautomat;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"de.sk_younous.magtvwebautomat.specifications"},
        plugin = {"pretty", "html:target/cucumber-reports"}
        //,
        //monochrome = true
)
public class RunCucumberTest {
}
