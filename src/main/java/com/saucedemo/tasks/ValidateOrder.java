package com.saucedemo.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.saucedemo.userinterface.CheckoutUI.TXT_FINAL_MESSAGE;

public class ValidateOrder implements Task {
    private final String finalMessage;

    public ValidateOrder(String finalMessage) {
        this.finalMessage = finalMessage;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(TXT_FINAL_MESSAGE).text().isEqualTo(finalMessage)
        );
    }

    public static ValidateOrder isComplete(String finalMessage){
        return Instrumented.instanceOf(ValidateOrder.class).withProperties(finalMessage);
    }
}
