package de.codecentric.domain;

import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Day {

    private String shortName;
    private List<Timeslot> timeslots;

    @JsonCreator
    public Day(@JsonProperty("shortName") String shortName, @JsonProperty("timeslots") List<Timeslot> timeslots) {
        this.shortName = shortName;
        this.timeslots = timeslots;
    }

    public String getShortName() {
        return shortName;
    }

    public List<Timeslot> getTimeslots() {
        return timeslots;
    }

    public String getShortNameWithoutDots() {
        return shortName.replace(".", "");
    }

    @Override
    public String toString() {
        return "Day [shortName=" + shortName + ", timeslots=" + timeslots + "]";
    }

}
