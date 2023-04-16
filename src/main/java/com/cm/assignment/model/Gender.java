package com.cm.assignment.model;

public enum Gender {
    MALE("male"),
    FEMALE("female");

    private final String columnName;

    Gender(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }
}
