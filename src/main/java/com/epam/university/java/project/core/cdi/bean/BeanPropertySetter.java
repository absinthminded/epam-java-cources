package com.epam.university.java.project.core.cdi.bean;

import java.lang.reflect.Field;

public interface BeanPropertySetter {

    void setValue(Object bean, Field field, BeanPropertyDefinition property)
            throws IllegalAccessException;

    void setReference(Object bean, Field field, BeanPropertyDefinition property)
            throws IllegalAccessException;

    void setComplexData(Object bean, Field field, BeanPropertyDefinition property)
            throws IllegalAccessException;
}