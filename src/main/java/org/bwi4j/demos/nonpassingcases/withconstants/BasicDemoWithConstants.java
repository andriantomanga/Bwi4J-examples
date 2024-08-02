package org.bwi4j.demos.nonpassingcases.withconstants;

import java.util.List;

import static org.bwi4j.demos.nonpassingcases.withconstants.BasicDemoWithConstants.Day.SATURDAY;
import static org.bwi4j.demos.nonpassingcases.withconstants.BasicDemoWithConstants.Day.SUNDAY;

public class BasicDemoWithConstants {
    private final static List<Day> BAD_DAYS = List.of(SATURDAY, SUNDAY);

    public static boolean isGoodDay(Day givenDay) {
        return BAD_DAYS.contains(givenDay);
    }

    public enum Day {
        MONDDAY, TUESDAY, WEDNESDAY, THIRSDAY, FRIDAY, SATURDAY, SUNDAY;
    }
}
