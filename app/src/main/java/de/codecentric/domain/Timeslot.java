package de.codecentric.domain;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Timeslot {

    private String start;
    private String end;

    @JsonCreator
    public Timeslot(@JsonProperty("start") String start, @JsonProperty("end") String end) {
        this(start);
        this.end = end;
    }

    public Timeslot(String start) {
        this.start = start;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    @Override
    public String toString() {
        String endToConcatenate = end != null ? " - " + end : "";
        return start + endToConcatenate;
    }
}
