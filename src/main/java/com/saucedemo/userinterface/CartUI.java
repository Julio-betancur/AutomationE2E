package com.saucedemo.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartUI extends PageObject {
    public static final Target LBL_ITEM_NAMES =
            Target.the("Item names")
                    .locatedBy("//div[@class='inventory_item_name']");

    public static final Target BTN_CHECKOUT =
            Target.the("Button to checkout the purchase")
                    .located(By.id("checkout"));

}
