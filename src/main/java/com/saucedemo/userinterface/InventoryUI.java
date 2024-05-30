package com.saucedemo.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class InventoryUI extends PageObject {
    public static Target getProductButton(String productName) {
        return Target.the("Button to open a product")
                .locatedBy("//img[@alt='" + productName + "']");
    }

    public static final Target LBL_INVENTORY_TITLE =
            Target.the("Label with the inventory page title")
                    .locatedBy("//*[@class='title']");

    public static final Target BTN_CART =
            Target.the("Button to open the cart")
                    .locatedBy("//*[@class='shopping_cart_link']");

}
