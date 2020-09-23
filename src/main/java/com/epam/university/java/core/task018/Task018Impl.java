package com.epam.university.java.core.task018;


import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class Task018Impl implements Task018 {
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        if (toCheck == null || annotationToFind == null) {
            throw new IllegalArgumentException();
        }
        Class clazz = toCheck.getClass();

        if (clazz.isAnnotationPresent(annotationToFind)) {
            return true;
        }

        Package packageA = clazz.getPackage();
        for (Annotation anno : packageA.getAnnotations()) {
            if (anno.annotationType() == annotationToFind) {
                return true;
            }
        }

        Constructor<?>[] constructors = clazz.getConstructors();

        for (Constructor<?> constructor : constructors) {
            for (Annotation anno : constructor.getDeclaredAnnotations()) {
                if (anno.annotationType() == annotationToFind) {
                    return true;
                }
            }
        }

        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            for (Annotation anno : method.getDeclaredAnnotations()) {
                if (anno.annotationType() == annotationToFind) {
                    return true;
                }
            }
        }

        for (Method method : methods) {
            Annotation[][] annos = method.getParameterAnnotations();
            for (Annotation[] annotArr : annos) {
                for (Annotation anno : annotArr) {
                    if (anno.annotationType().equals(annotationToFind)) {
                        return true;
                    }
                }
            }

        }

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(BasicAnnotation.class)) {
                return true;
            }
        }

        return false;
    }
}
