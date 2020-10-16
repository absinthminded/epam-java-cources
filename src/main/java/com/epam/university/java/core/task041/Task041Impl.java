package com.epam.university.java.core.task041;

import java.util.Collection;

public class Task041Impl implements Task041 {
    @Override
    public Entity create(Collection<Entity> collection, String value) {
        if (collection == null || value == null) {
            throw new IllegalArgumentException();
        }
        Entity newEntity = new EntityImpl(collection.size(), value);
        collection.add(newEntity);
        return newEntity;
    }

    @Override
    public Entity read(Collection<Entity> collection, Entity entity) {
        checkParams(collection, entity);
        return collection.contains(entity) ? entity : null;
    }

    @Override
    public void update(Collection<Entity> collection, Entity entity, String value) {
        checkParams(collection, entity);
        if (value == null || !collection.contains(entity)) {
            throw new IllegalArgumentException();
        }
        collection.remove(entity);
        collection.add(new EntityImpl(entity.getId(), value));
    }

    @Override
    public void delete(Collection<Entity> collection, Entity entity) {
        checkParams(collection, entity);
        collection.remove(entity);
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
