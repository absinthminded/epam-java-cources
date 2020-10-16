package com.epam.university.java.core.task041;

import java.util.Objects;

public class EntityImpl implements Entity {
    private int id;
    private String value;

    public EntityImpl(int id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getValue() {

        return value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EntityImpl)) {
            return false;
        }
        EntityImpl entity = (EntityImpl) obj;
        return Objects.equals(getValue(), entity.getValue());
    }
}
