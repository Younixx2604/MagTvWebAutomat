package de.sk_younous.magtvwebautomat;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomepageStarten {



    @Given("der Benutzer hat einen Webbrowser geöffnet")
    public void der_benutzer_hat_einen_webbrowser_geöffnet() {


        //open("http://google.com");
        //throw new io.cucumber.java.PendingException();
    }
    @When("der Benutzer die URL {string} öffnet")
    public void der_benutzer_die_url_öffnet(String string) {

        open(string);

        //throw new io.cucumber.java.PendingException();
    }
    @Then("der URL der göffnete Seite sollte {string} enthalten")
    public void der_titel_der_göffnete_seite_sollte_enthalten(String string) throws InterruptedException {


       String actulesURL =  WebDriverRunner.getWebDriver().getCurrentUrl();
        Thread.sleep(3000);

        assertTrue(actulesURL.contains(string));
        //throw new io.cucumber.java.PendingException();
    }


}
