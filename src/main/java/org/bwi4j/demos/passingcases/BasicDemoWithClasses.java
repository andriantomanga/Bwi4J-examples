package org.bwi4j.demos.passingcases;

import org.bwi4j.annotation.BwiIgnore;

public class BasicDemoWithClasses {
    public static class ValidClass {
        private String validField;
        public void validMethod() {}
    }

    @BwiIgnore
    public static class BadClassButIgnored {
        private String validField;
        private int forbiddenField;
        public void validMethod() {}
    }
}
