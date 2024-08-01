package de.sk_younous.magtvwebautomat;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class LoginButtonFinden_KAN_T31 {


        @When("der Benutzer die MagentaTv Homepage {string} öffnet")
        public void der_benutzer_die_url_öffnet(String string) {
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

               assertTrue($(By.id("MENU-LOGIN")).isDisplayed());
        }

            @And("der Login Button sollte klickbar sein")
            public void der_login_button_sollte_funktionnieren()
            {

                if($(By.id("OVERLAY-ACCEPT")).exists())
                    $(By.id("OVERLAY-ACCEPT")).click();
                $(By.id("MENU-LOGIN")).click();

            }

}

