package com.saucedemo.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.saucedemo.userinterface.InventoryUI.LBL_INVENTORY_TITLE;
import static com.saucedemo.userinterface.LoginUI.*;
import static com.saucedemo.userinterface.ProductDetailUI.TXT_PRODUCT_NAME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username).into(INPUT_USERNAME),
                Enter.theValue(password).into(INPUT_PASSWORD),
                Click.on(BTN_LOGIN),
                WaitUntil.the(LBL_INVENTORY_TITLE, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static Login withCredentials(String username,String password){
        return Instrumented.instanceOf(Login.class).withProperties(username,password);
    }
}
