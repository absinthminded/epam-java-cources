package com.epam.university.java.core.task041;

public class EntityImpl implements Entity {
    private int id;
    private String value;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getValue() {

        return value;
    }
}
