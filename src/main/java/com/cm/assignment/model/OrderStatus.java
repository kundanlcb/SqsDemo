package com.cm.assignment.model;

public enum OrderStatus {
    CREATED("created"),
    CONFIRMED("confirmed"),
    CANCELLED("cancelled"),
    DISPATCHED("dispatched"),

    REFUNDED("refunded");

    private final String columnName;

    OrderStatus(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }
}
