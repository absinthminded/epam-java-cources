package com.epam.university.java.core.task041;

import java.util.Collection;

public class Task041Impl implements Task041 {
    @Override
    public Entity create(Collection<Entity> collection, String value) {
        if (collection == null || value == null) {
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public Entity read(Collection<Entity> collection, Entity entity) {
        checkParams(collection, entity);
        return null;
    }

    @Override
    public void update(Collection<Entity> collection, Entity entity, String value) {
        checkParams(collection, entity);
        if (value == null) {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public void delete(Collection<Entity> collection, Entity entity) {
        checkParams(collection, entity);

    }

    /**
     * Function to validate parameters.
     * @param collection to check.
     * @param entity to check.
     */
    public void checkParams(Collection<Entity> collection, Entity entity) {
        if (collection == null || entity == null) {
            throw new IllegalArgumentException();
        }
    }
}
