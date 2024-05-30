package com.saucedemo.userinterface;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@DefaultUrl("page:sauce.url")
public class LoginUI extends PageObject {
    public static final Target INPUT_USERNAME =
            Target.the("Textfield to enter the username")
                    .located(By.id("user-name"));

    public static final Target INPUT_PASSWORD =
            Target.the("Textfield to enter the password")
                    .located(By.id("password"));

    public static final Target BTN_LOGIN =
            Target.the("Button to login")
                    .located(By.id("login-button"));
}
