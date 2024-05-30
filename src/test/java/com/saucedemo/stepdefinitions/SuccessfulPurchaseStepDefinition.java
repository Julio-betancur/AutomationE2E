package com.saucedemo.stepdefinitions;

import com.saucedemo.model.SuccessfulPurchaseDataTable;
import com.saucedemo.tasks.*;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.Map;

public class SuccessfulPurchaseStepDefinition {

    @DataTableType
    public SuccessfulPurchaseDataTable convert(Map<String, String> table) {
        return new ObjectMapper().convertValue(table, SuccessfulPurchaseDataTable.class);
    }

    private Actor actor;

    @Before(order = 0)
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
        this.actor = OnStage.theActorCalled("User");
    }
    @Given("the user is on the SauceDemo login page")
    public void theUserIsOnTheSauceDemoLoginPage() {
        actor.wasAbleTo(
                NavigateTo.saucedemoPage()
        );
    }
    @Given("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials(SuccessfulPurchaseDataTable data) {
        actor.attemptsTo(
                Login.withCredentials(data.getUsername(), data.getPassword())
        );
    }
    @When("the user adds two products to the cart")
    public void theUserAddsTwoProductsToTheCart(SuccessfulPurchaseDataTable data) {
        actor.attemptsTo(
                AddProducts.toCart(data.getProducts())
        );
    }
    @When("the user checks the cart")
    public void theUserChecksTheCart(SuccessfulPurchaseDataTable data) {
        actor.attemptsTo(
                VerifyProducts.inCart(data.getProducts())
        );
    }
    @When("the user completes the purchase")
    public void theUserCompletesThePurchase(SuccessfulPurchaseDataTable data) {
        actor.attemptsTo(
                CompleteCheckout.withInformation(data)
        );
    }
    @Then("the user should see the confirmation message {string}")
    public void theUserShouldSeeTheConfirmationMessage(String message) {
        actor.attemptsTo(
                ValidateOrder.isComplete(message)
        );
    }
}
