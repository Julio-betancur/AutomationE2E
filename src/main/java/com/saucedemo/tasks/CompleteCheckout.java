package com.saucedemo.tasks;

import com.saucedemo.exceptions.PriceFormatException;
import com.saucedemo.model.SuccessfulPurchaseDataTable;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Arrays;
import java.util.List;

import static com.saucedemo.userinterface.CartUI.BTN_CHECKOUT;
import static com.saucedemo.userinterface.CheckoutUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CompleteCheckout implements Task {

    private final SuccessfulPurchaseDataTable data;

    public CompleteCheckout(SuccessfulPurchaseDataTable data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CHECKOUT),
                WaitUntil.the(INPUT_FIRST_NAME, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(data.getFirstName()).into(INPUT_FIRST_NAME),
                Enter.theValue(data.getLastName()).into(INPUT_LAST_NAME),
                Enter.theValue(data.getZipCode()).into(INPUT_ZIP_CODE),
                Click.on(BTN_CONTINUE),
                WaitUntil.the(TXT_ITEM_TOTAL, isVisible()).forNoMoreThan(10).seconds()
        );
        verifyItemTotal(actor);
        actor.attemptsTo(
                Click.on(BTN_FINISH)
        );
    }

    private void verifyItemTotal(Actor actor) {
        List<String> productsList = Arrays.stream(data.getProducts().split(",")).toList();
        double actualItemsTotal = extractPrice(TXT_ITEM_TOTAL.resolveFor(actor).getText());
        double expectedItemsTotal = 0;

        for (String product : productsList) {
            double productPrice = extractPrice(actor.recall(product));
            expectedItemsTotal += productPrice;
        }
        actor.attemptsTo(
                Ensure.that(actualItemsTotal).isEqualTo(expectedItemsTotal)
        );
    }

    private static double extractPrice(String price) {
        try {
            String formattedPrice = price.replaceAll("[^\\d.]", "");
            return Double.parseDouble(formattedPrice);
        } catch (NumberFormatException e) {
            throw new PriceFormatException("Error while converting the price " + price, e);
        }

    }

    public static CompleteCheckout withInformation(SuccessfulPurchaseDataTable data) {
        return Instrumented.instanceOf(CompleteCheckout.class).withProperties(data);
    }
}
