package de.codecentric.domain;

public enum SessionType {
    openspace("Openspace"), session("Session"), openspaceanywhere("Openspace Anywhere");

    private String label;

    private SessionType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static SessionType getTypeForString(String typeString) {
        for (SessionType type : SessionType.values()) {
            if (type.toString().equals(typeString)) {
                return type;
            }
        }

        throw new RuntimeException(String.format("no enum for [%s] found", typeString));
    }
}
