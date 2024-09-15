package de.sk_younous.magtvwebautomat.specifications;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Film_Navigation_KAN_46 {


    @Given("die Homepage {string} ist geöffnet")
    public void die_magenta_tv_homepage_ist_geöffnet(String string) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        options.addArguments("--start-maximized");
        //options.addArguments("--headless");
        //Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;
        open(string);
    }
    @Given("man Coockies schliesst")
    public void man_den_coockies_banner_schliesst() {
        $(By.id("OVERLAY-ACCEPT")).shouldBe(Condition.visible, Duration.ofMillis(3000)).click();
    }
    @When("man klickt {string} an")
    public void man_klickt_an(String string) {
        $(By.id("MENU-TEXT-4")).click();
    }
    @Then("{string} wird geöffnet")
    public void wird_geöffnet(String string) throws InterruptedException {
        String actulesURL =  WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals(actulesURL,string);
        Thread.sleep(5000);
        closeWebDriver();
    }

}
