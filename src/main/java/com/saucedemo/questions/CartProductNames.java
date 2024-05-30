package com.saucedemo.questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;

import static com.saucedemo.userinterface.CartUI.LBL_ITEM_NAMES;

public class CartProductNames implements Question<List<String>> {
    @Override
    public List<String> answeredBy(Actor actor) {
        return LBL_ITEM_NAMES.resolveAllFor(actor).stream()
                .map(WebElementFacade::getText).toList();
    }

    public static CartProductNames displayed(){
        return Instrumented.instanceOf(CartProductNames.class).withProperties();
    }
}
