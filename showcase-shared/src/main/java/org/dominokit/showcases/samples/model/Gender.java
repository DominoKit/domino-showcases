package org.dominokit.showcases.samples.model;

public enum Gender {
    female("Female"), male("Male");

    private String label;

    Gender(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
