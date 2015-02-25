package de.codecentric.domain;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Location {

    private String shortName;
    private String description;

    @JsonCreator
    public Location(@JsonProperty("shortName") String shortName, @JsonProperty("description") String description) {
        this.shortName = shortName;
        this.description = description;
    }

    public String getShortName() {
        return shortName;
    }

    public String getDescription() {
        return description;
    }
}
