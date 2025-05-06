package com.bankapp.business.constants;

public class Messages {

    public static class Customer {

        public static final String INDIVIDUAL_CUSTOMER_NOT_FOUND = "Individual customer not found with id: %d";
        public static final String INDIVIDUAL_CUSTOMER_ALREADY_EXISTS= "Identity number already exists: %s";
        public static final String INDIVIDUAL_CUSTOMER_CREATED = "Individual customer created successfully";
        public static final String EMAIL_ALREADY_EXISTS = "Email already exists: %s";


        public static final String CORPORATE_CUSTOMER_NOT_FOUND = "Corporate customer not found with id: %d";
        public static final String TAX_NUMBER_ALREADY_EXISTS = "Tax number already exists: %s";
        public static final String CORPORATE_CUSTOMER_CREATED = "Corporate customer created successfully";
    }
}