package com.saucedemo.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductDetailUI extends PageObject {
    public static final Target TXT_PRODUCT_NAME =
            Target.the("Text with the product name")
                    .locatedBy("//div[contains(@class, 'inventory_details_name')]");

    public static final Target TXT_PRODUCT_PRICE =
            Target.the("Text with the product price")
                    .locatedBy("//div[contains(@class, 'inventory_details_price')]");

    public static final Target BTN_ADD_TO_CART =
            Target.the("Button to add the product to the cart")
                    .located(By.id("add-to-cart"));

    public static final Target BTN_BACK_TO_PRODUCTS =
            Target.the("Button to return to the products page")
                    .located(By.id("back-to-products"));
}
