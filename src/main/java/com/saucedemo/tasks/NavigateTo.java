package com.saucedemo.tasks;

import com.saucedemo.userinterface.LoginUI;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.saucedemo.userinterface.LoginUI.INPUT_USERNAME;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class NavigateTo implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn().the(LoginUI.class),
                WaitUntil.the(INPUT_USERNAME, isVisible()).forNoMoreThan(10).seconds()
        );

    }

    public static NavigateTo saucedemoPage() {
        return Instrumented.instanceOf(NavigateTo.class).withProperties();
    }
}
