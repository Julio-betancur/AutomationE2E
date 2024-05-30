package com.saucedemo.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Arrays;
import java.util.List;

import static com.saucedemo.questions.CartProductNames.displayed;
import static com.saucedemo.userinterface.CartUI.LBL_ITEM_NAMES;
import static com.saucedemo.userinterface.InventoryUI.BTN_CART;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerifyProducts implements Task {
    private final List<String> expectedProductNames;

    public VerifyProducts(String productNames) {
        this.expectedProductNames = Arrays.stream(productNames.split(",")).toList();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CART),
                WaitUntil.the(LBL_ITEM_NAMES, isVisible()).forNoMoreThan(10).seconds()
        );
        List<String> actualProductNames = displayed().answeredBy(actor);

        actor.attemptsTo(
                Ensure.that(actualProductNames).containsExactlyElementsFrom(expectedProductNames)
        );
    }

    public static VerifyProducts inCart(String productNames){
        return Instrumented.instanceOf(VerifyProducts.class).withProperties(productNames);
    }
}
