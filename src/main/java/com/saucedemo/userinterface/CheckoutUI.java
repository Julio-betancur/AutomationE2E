package com.saucedemo.userinterface;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutUI extends PageObject {
    public static final Target INPUT_FIRST_NAME =
            Target.the("Textfield to enter the first name")
                    .located(By.id("first-name"));

    public static final Target INPUT_LAST_NAME =
            Target.the("Textfield to enter the last name")
                    .located(By.id("last-name"));

    public static final Target INPUT_ZIP_CODE =
            Target.the("Textfield to enter the zip code")
                    .located(By.id("postal-code"));

    public static final Target BTN_CONTINUE =
            Target.the("Button to continue to overview page")
                    .located(By.id("continue"));

    public static final Target TXT_ITEM_TOTAL =
            Target.the("Text with the item total without taxes")
                    .locatedBy("//*[@class='summary_subtotal_label']");

    public static final Target BTN_FINISH =
            Target.the("Button to finish the purchase")
                    .located(By.id("finish"));

    public static final Target TXT_FINAL_MESSAGE =
            Target.the("Text with the final message that confirm the purchase")
                    .locatedBy("//*[@class='complete-header']");
}
