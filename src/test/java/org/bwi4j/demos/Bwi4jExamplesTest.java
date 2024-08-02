package org.bwi4j.demos;

import org.bwi4j.BwiRule;
import org.bwi4j.exception.BwiException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Bwi4jExamplesTest {
    @Test
    void should_test_the_passing_cases_for_classes() throws BwiException {
        // Given:
        BwiRule rule = BwiRule.elements()
                .inThesePackages("org.bwi4j.demos.passingcases")
                .mustNotContainTheseTerms("Forbidden", "bad");

        // When + Then:
        rule.check();
    }

    @Test
    void should_test_the_non_passing_case_for_classes() {
        // Given:
        BwiRule rule = BwiRule.elements()
                .inThesePackages("org.bwi4j.demos.nonpassingcases.withclass")
                .mustNotContainTheseTerms("Forbidden", "bad");

        // When:
        BwiException thrownException = assertThrows(BwiException.class, rule::check);

        // Then:
        var expectedMessage = "Class name contains blacklisted term: BasicDemoWithBadClass";
        var actualMessage = thrownException.getMessage();

        assertTrue(actualMessage.contains(expectedMessage),
                "Exception message should contain: " + expectedMessage + " but was: " + actualMessage);
    }

    @Test
    void should_test_the_non_passing_case_for_fields() {
        // Given:
        BwiRule rule = BwiRule.elements()
                .inThesePackages("org.bwi4j.demos.nonpassingcases.withfield")
                .mustNotContainTheseTerms("Forbidden", "bad");

        // When:
        BwiException thrownException = assertThrows(BwiException.class, rule::check);

        // Then:
        var expectedMessage = "Field name contains blacklisted term: forbiddenField";
        var actualMessage = thrownException.getMessage();

        assertTrue(actualMessage.contains(expectedMessage),
                "Exception message should contain: " + expectedMessage + " but was: " + actualMessage);
    }

    @Test
    void should_test_the_non_passing_case_for_static_fields() {
        // Given:
        BwiRule rule = BwiRule.elements()
                .inThesePackages("org.bwi4j.demos.nonpassingcases.withconstants")
                .mustNotContainTheseTerms("Forbidden", "bad");

        // When:
        BwiException thrownException = assertThrows(BwiException.class, rule::check);

        // Then:
        var expectedMessage = "Field name contains blacklisted term: BAD_DAYS";
        var actualMessage = thrownException.getMessage();

        assertTrue(actualMessage.contains(expectedMessage),
                "Exception message should contain: " + expectedMessage + " but was: " + actualMessage);
    }

    @Test
    void should_test_the_non_passing_case_for_methods() {
        // Given:
        BwiRule rule = BwiRule.elements()
                .inThesePackages("org.bwi4j.demos.nonpassingcases.withmethod")
                .mustNotContainTheseTerms("Forbidden", "bad");

        // When:
        BwiException thrownException = assertThrows(BwiException.class, rule::check);

        // Then:
        var expectedMessage = "Method name contains blacklisted term: getBadFieldValue";
        var actualMessage = thrownException.getMessage();

        assertTrue(actualMessage.contains(expectedMessage),
                "Exception message should contain: " + expectedMessage + " but was: " + actualMessage);
    }
}
