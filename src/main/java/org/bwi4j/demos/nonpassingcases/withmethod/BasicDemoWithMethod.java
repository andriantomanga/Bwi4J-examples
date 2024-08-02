package org.bwi4j.demos.nonpassingcases.withmethod;

public class BasicDemoWithMethod {
    private final String validField;

    public BasicDemoWithMethod(String validField) {
        this.validField = validField;
    }

    public String getValidField() {
        return validField;
    }

    public String getBadFieldValue() {
        return new StringBuilder(validField).reverse().toString();
    }
}
