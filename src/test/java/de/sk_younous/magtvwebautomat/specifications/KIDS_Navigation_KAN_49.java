package de.sk_younous.magtvwebautomat.specifications;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class KIDS_Navigation_KAN_49 {


    @Given("{string} ist geöffnet")
    public void die_magenta_tv_homepage_ist_geöffnet(String string) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        //Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;
        open(string);
    }
    @Given("Coockies schliesst")
    public void man_den_coockies_banner_schliesst() {
        $(By.id("OVERLAY-ACCEPT")).shouldBe(Condition.visible, Duration.ofMillis(3000)).click();
    }

    @When("man {string} clickt")
    public void man_auf_klickt_an(String string) {
        $(By.id("MENU-TEXT-7")).click();
    }

    @Then("{string} Seite wird geöffnet")
    public void wird_geöffnet(String string) throws InterruptedException {
        String actulesURL =  WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(string,actulesURL);
        Thread.sleep(5000);
        closeWebDriver();
    }

}


