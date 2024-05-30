package com.saucedemo.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.Arrays;
import java.util.List;

import static com.saucedemo.userinterface.InventoryUI.LBL_INVENTORY_TITLE;
import static com.saucedemo.userinterface.InventoryUI.getProductButton;
import static com.saucedemo.userinterface.ProductDetailUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProducts implements Task {
    private final String products;

    public AddProducts(String products) {
        this.products = products;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<String> productsList = Arrays.stream(products.split(",")).toList();

        for (String product : productsList) {
            addProductToCart(actor,product);
        }
    }

    private void addProductToCart(Actor actor, String product) {
        Target productButton = getProductButton(product);
        actor.attemptsTo(
                Click.on(productButton),
                WaitUntil.the(TXT_PRODUCT_NAME, isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(TXT_PRODUCT_NAME).text().isEqualTo(product)
        );
        String price = TXT_PRODUCT_PRICE.resolveFor(actor).getText();
        actor.remember(product, price);
        actor.attemptsTo(
                Click.on(BTN_ADD_TO_CART),
                WaitUntil.the(BTN_ADD_TO_CART, isNotPresent()).forNoMoreThan(10).seconds(),
                Click.on(BTN_BACK_TO_PRODUCTS),
                WaitUntil.the(LBL_INVENTORY_TITLE, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    public static AddProducts toCart(String products) {
        return Instrumented.instanceOf(AddProducts.class).withProperties(products);
    }
}
