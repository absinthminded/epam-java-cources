package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.Map;

public class BeanDefinitionToClassRepositoryImpl implements BeanDefinitionToClassRepository {
    private final Map<Class<?>, String> bdToClassRepository = new HashMap<>();

    @Override
    public String getBeanId(Class<?> clazz) {
        return bdToClassRepository.get(clazz);
    }

    @Override
    public void putBean(Class<?> clazz, String beanId) {
        bdToClassRepository.put(clazz, beanId);
    }
}
