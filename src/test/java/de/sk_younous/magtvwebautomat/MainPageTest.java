package de.sk_younous.magtvwebautomat;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import org.testng.annotations.*;
import org.testng.annotations.Test;


public class MainPageTest {
    MainPage mainPage = new MainPage();

    @BeforeTest
    public static void setUpAll() {
        Configuration.browserSize = "1480x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeMethod
    public void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://web.magentatv.de/");

        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if($(By.id("OVERLAY-ACCEPT")).exists())
            $(By.id("OVERLAY-ACCEPT")).click();
    }



    @Test(priority = 1)
    public void loginButtonExists() {

        try {
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        assertTrue(mainPage.loginButton.exists());
    }

    

    @Test (priority = 2)                         //loginButton anklicken -> LoginSeite öffne
    public void loginButtonClick()
    {

        try {                                   //warten bis neue Seite / login lädt
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        mainPage.loginButton.click();


        String expectedUrl = "https://accounts.login.idm.telekom.com";
        String actualUrl = WebDriverRunner.getWebDriver().getCurrentUrl();

        assertTrue(actualUrl.contains(expectedUrl));
    }

/*
    @Test (priority = 3)                        //mit falschen Login daten
    public void Neglogin()
    {

        mainPage.loginButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }



        //customerNr -- firefox
        //$(By.id("customerNr")).sendKeys("test123");
        //$(By.id("next")).click();

        //chrome
        $(By.id("username")).sendKeys("test123");
        $(By.id("pw_submit")).click();


        //$("info-box").

        String erwartet = "Benutzername ist nicht korrekt.";
        String actual =  $(byXpath("//div[contains(@class, 'info-box')]/div")).getText();
        System.out.println(actual);

        assertEquals(erwartet,actual);

    } // comment to test github 1

*/

}





