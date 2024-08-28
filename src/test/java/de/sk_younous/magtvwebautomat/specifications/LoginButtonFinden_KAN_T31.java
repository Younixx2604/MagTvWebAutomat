package de.sk_younous.magtvwebautomat.specifications;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;


public class LoginButtonFinden_KAN_T31 {


        @Given("der Benutzer die MagentaTv Homepage {string} öffnet")
        public void der_benutzer_die_url_öffnet(String string) {

            ChromeOptions options = new ChromeOptions();    // Optionen hinzufügen, um das Suchmaschinen-Pop-up zu umgehen
            options.addArguments("--disable-search-engine-choice-screen");
            options.addArguments("--start-maximized"); //--start-fullscreen //options.addArguments("--headless");
            //options.addArguments("--headless");
            //options.addArguments("--start-fullscreen");
            //Configuration.browser = "chrome";
            Configuration.browserCapabilities = options;
            WebDriverRunner.setWebDriver(new ChromeDriver(options));
            open(string);
        }
        @Given("man schliesst Coockies")
        public void man_schliesst_cookies() {
            //if($(By.id("OVERLAY-ACCEPT")).exists())
                $(By.id("OVERLAY-ACCEPT")).shouldBe(Condition.visible, Duration.ofMillis(3000)).click();
        }

        @Then("sollte ein roter Login Button sichtbar sein")
        public void der_login_button_sichtbar()
        {
            $(By.id("MENU-LOGIN")).shouldBe(Condition.visible);
            assertTrue($(By.id("MENU-LOGIN")).isDisplayed());
        }

        @And("der Login Button sollte klickbar sein")
        public void der_login_button_sollte_funktionnieren()
            {
                $(By.id("MENU-LOGIN")).click();

                closeWebDriver();
            }

}

