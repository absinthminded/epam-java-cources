package com.epam.university.java.project.core.cdi.bean;

import java.util.HashMap;
import java.util.Map;

public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> bdRegistry = new HashMap<>();
    private final BeanDefinitionToClassRepository bdToClassRepository;

    public BeanDefinitionRegistryImpl(BeanDefinitionToClassRepository repository) {
        this.bdToClassRepository = repository;
    }

    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        bdRegistry.put(definition.getId(), definition);
        Class<?> beanClass = null;
        Class<?> beanInterface = null;
        try {
            beanClass = Class.forName(definition.getClassName());
            if (beanClass.getInterfaces().length > 0) {
                beanInterface = beanClass.getInterfaces()[0];
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        bdToClassRepository.putBean(beanClass, definition.getId());
        if (beanInterface != null) {
            bdToClassRepository.putBean(beanInterface, definition.getId());
        }
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return bdRegistry.get(beanId);
    }
}
