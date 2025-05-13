package com.bankapp.business.constants;

public class Messages {

    public static class Customer {

        public static final String CUSTOMER_NOT_FOUND = "Customer not found with id: %d";

        public static final String INDIVIDUAL_CUSTOMER_NOT_FOUND = "Individual customer not found with id: %d";
        public static final String INDIVIDUAL_CUSTOMER_ALREADY_EXISTS= "Identity number already exists: %s";
        public static final String INDIVIDUAL_CUSTOMER_CREATED = "Individual customer created successfully";
        public static final String EMAIL_ALREADY_EXISTS = "Email already exists: %s";


        public static final String CORPORATE_CUSTOMER_NOT_FOUND = "Corporate customer not found with id: %d";
        public static final String TAX_NUMBER_ALREADY_EXISTS = "Tax number already exists: %s";
        public static final String CORPORATE_CUSTOMER_CREATED = "Corporate customer created successfully";
    }

    public static class Credit {

        public static final String CREDIT_TYPE_NOT_FOUND = "Credit type not found with id: %d";
        public static final String APPLICATION_NOT_FOUND = "Application not found with id: %d";
        public static final String INVALID_CREDIT_TYPE_FOR_CUSTOMER = "Invalid credit type for customer";
        public static final String AMOUNT_OUT_OF_RANGE = "Credit amount is out of allowed range";
        public static final String TERM_OUT_OF_RANGE = "Credit term is out of allowed range";
        public static final String APPLICATION_CANNOT_BE_CANCELLED = "Credit application cannot be cancelled";
    }
}