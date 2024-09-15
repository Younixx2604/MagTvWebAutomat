package de.sk_younous.magtvwebautomat;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {


    public SelenideElement loginButton= $(By.id("MENU-LOGIN"));
    public SelenideElement cookiesAkzeptieren= $(By.id("OVERLAY-ACCEPT"));
}
