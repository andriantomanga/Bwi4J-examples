package org.bwi4j.demos.nonpassingcases.withfield;

public class BasicDemoWithField {
    private final int validField;
    private final String forbiddenField;

    public BasicDemoWithField(int validField, String forbiddenField) {
        this.validField = validField;
        this.forbiddenField = forbiddenField;
    }

    @Override
    public String toString() {
        return "BasicDemoWithField{" +
                "validField=" + validField +
                ", forbiddenField='" + forbiddenField + '\'' +
                '}';
    }
}
