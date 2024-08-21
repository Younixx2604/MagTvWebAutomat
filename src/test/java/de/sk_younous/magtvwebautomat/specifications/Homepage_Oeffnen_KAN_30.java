package de.sk_younous.magtvwebautomat.specifications;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;
//import static org.junit.jupiter.api.Assertions.assertTrue;

public class Homepage_Oeffnen_KAN_30 {



    @Given("der Benutzer hat einen Webbrowser geöffnet")
    public void der_benutzer_hat_einen_webbrowser_geöffnet() {


        ChromeOptions options = new ChromeOptions();
        // Optionen hinzufügen, um das Suchmaschinen-Pop-up zu umgehen
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        //Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;
        Configuration.browserSize = "1480x800";
        // Initialisieren des WebDriver mit den Optionen
        //WebDriverRunner.setWebDriver(new ChromeDriver(options));




    }
    @When("der Benutzer die URL {string} öffnet")
    public void der_benutzer_die_url_öffnet(String string) {
        open(string);
    }

    @Then("der URL der göffnete Seite sollte {string} enthalten")
    public void der_titel_der_göffnete_seite_sollte_enthalten(String string) throws InterruptedException {


        String actulesURL =  WebDriverRunner.getWebDriver().getCurrentUrl();
        Thread.sleep(3000);

        //assertTrue(actulesURL.contains(string));

        //throw new io.cucumber.java.PendingException();
    }


}
