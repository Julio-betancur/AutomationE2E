package com.saucedemo.model;

import lombok.Data;

@Data
public class SuccessfulPurchaseDataTable {
    private String username;
    private String password;
    private String products;
    private String firstName;
    private String lastName;
    private String zipCode;
}
