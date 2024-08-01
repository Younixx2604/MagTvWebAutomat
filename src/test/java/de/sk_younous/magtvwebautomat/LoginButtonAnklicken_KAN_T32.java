package de.sk_younous.magtvwebautomat;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.conditions.webdriver.CurrentFrameUrl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class LoginButtonAnklicken_KAN_T32 {


    @Given("die MagentaTV Homepage  {string} ist geöffnet")
    public void die_magenta_tv_homepage_ist_geöffnet(String string) {
        // Write code here that turns the phrase above into concrete actions
        open(string);
    }
    @Given("der Login Button wurde auf der Homepage gefunden")
    public void der_login_button_wurde_auf_der_homepage_gefunden() {

        if($(By.id("MENU-LOGIN")).exists()) {
            $(By.id("OVERLAY-ACCEPT")).shouldBe(Condition.visible);
            assertTrue($(By.id("MENU-LOGIN")).isDisplayed());
        }
    }
    @Given("man den Coockies Banner schliesst")
    public void man_den_coockies_banner_schliesst() {
                       if($(By.id("OVERLAY-ACCEPT")).exists())
                           $(By.id("OVERLAY-ACCEPT")).shouldBe(Condition.visible).click();
    }

    @When("der Benutzer den roten Login Button anklickt")
    public void der_benutzer_den_roten_login_button_anklickt() {
        $(By.id("MENU-LOGIN")).click();
    }
    @Then("sollte der URL der Login-Seite  {string} enthalten")
    public void sollte_der_url_der_login_seite_enthalten(String string) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String aktuellesURL =  WebDriverRunner.getWebDriver().getCurrentUrl();
        assertTrue(aktuellesURL.contains(string));
    }


}
