package de.sk_younous.magtvwebautomat.specifications;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class LoginButtonFinden_KAN_T31 {


        @When("der Benutzer die MagentaTv Homepage {string} öffnet")
        public void der_benutzer_die_url_öffnet(String string) {

            /*
            ChromeOptions options = new ChromeOptions();
            // Optionen hinzufügen, um das Suchmaschinen-Pop-up zu umgehen
            options.addArguments("--disable-search-engine-choice-screen"); // Deaktiviert Infoleisten
            Configuration.browser = "chrome";
            Configuration.browserCapabilities = options;
            // Initialisieren des WebDriver mit den Optionen
            WebDriverRunner.setWebDriver(new ChromeDriver(options));

            */
            open(string);

        }


        @Then("sollte ein roter Login Button sichtbar sein")
        public void der_login_button_sichtbar()
        {
        try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

               ///assertTrue($(By.id("MENU-LOGIN")).isDisplayed());
            $(By.id("MENU-LOGIN")).shouldBe(Condition.visible);

        }

            @And("der Login Button sollte klickbar sein")
            public void der_login_button_sollte_funktionnieren()
            {

                if($(By.id("OVERLAY-ACCEPT")).exists())
                    $(By.id("OVERLAY-ACCEPT")).click();
                $(By.id("MENU-LOGIN")).click();

            }

}

