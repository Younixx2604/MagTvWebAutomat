package de.sk_younous.magtvwebautomat.specifications;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class LoginButtonAnklicken_KAN_T32 {


    @Given("die MagentaTV Homepage  {string} ist geöffnet")
    public void die_magenta_tv_homepage_ist_geöffnet(String string) {
        // Write code here that turns the phrase above into concrete actions

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        //Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;
        open(string);
    }

    @Given("man den Coockies Banner schliesst")
    public void man_den_coockies_banner_schliesst() {
        $(By.id("OVERLAY-ACCEPT")).shouldBe(Condition.visible, Duration.ofMillis(3000)).click();
    }

    @When("der Benutzer den roten Login Button anklickt")
    public void der_benutzer_den_roten_login_button_anklickt() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // $(By.id("MENU-LOGIN")).shouldBe(Condition.visible).click();
        $(By.id("MENU-LOGIN")).shouldBe(Condition.visible);
        $(By.id("MENU-LOGIN")).click();
    }

    @Then("sollte der URL der Login-Seite  {string} enthalten")
    public void sollte_der_url_der_login_seite_enthalten(String string) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String aktuellesURL = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertTrue(aktuellesURL.contains(string));

        closeWebDriver();
    }


}
