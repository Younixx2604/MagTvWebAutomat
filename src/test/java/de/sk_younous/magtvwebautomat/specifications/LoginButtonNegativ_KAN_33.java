package de.sk_younous.magtvwebautomat.specifications;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class LoginButtonNegativ_KAN_33 {




    @Given("die MagentaTV Homepage {string} ist geöffnet")
    public void die_magenta_tv_homepage_ist_geöffnet(String string) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        //Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;

        open(string);
    }

    @Given("man die Coockies schliesst")
    public void man_den_coockies_banner_schliesst() {
        $(By.id("OVERLAY-ACCEPT")).shouldBe(Condition.visible).click();
    }

    @Given("der Login Button wurde angeklickt und die Login-Seite geöffnet")
    public void der_login_button_wurde_angeklickt_und_die_login_seite_geöffnet() {
        $(By.id("MENU-LOGIN")).shouldBe(Condition.visible);
        $(By.id("MENU-LOGIN")).click();
    }

    @When("der Benutzer die Kundennummer {string} eingibt")
    public void der_benutzer_die_kundennummer_eingibt(String string) {
        $(By.id("username")).sendKeys("test123");
    }

    @When("der Benutzer auf {string} klickt")
    public void der_benutzer_auf_klickt(String string) {
        $(By.id("pw_submit")).click();
    }

    @Then("sollte eine Fehlermeldung {string} angezeigt werden")
    public void sollte_eine_fehlermeldung_angezeigt_werden(String string) throws InterruptedException {
        String actual = $(byXpath("//div[contains(@class, 'info-box')]/div")).getText();
        //"Die von Ihnen eingegebene Kundennummer wurde nicht gefunden."
        System.out.println(actual);
        assertEquals(actual, string);
        Thread.sleep(2000);
        closeWebDriver();
    }



}
