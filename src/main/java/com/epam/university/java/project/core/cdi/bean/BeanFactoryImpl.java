package com.epam.university.java.project.core.cdi.bean;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BeanFactoryImpl implements BeanFactory {
    private final BeanDefinitionToClassRepository bdToClassRepository;
    private final BeanDefinitionRegistry bdRegistry;
    private final Map<Class<?>, Object> singletons = new HashMap<>();
    private final BeanPropertySetter beanPropertySetter = new BeanPropertySetterImpl(this);

    public BeanFactoryImpl(BeanDefinitionToClassRepository repository,
                           BeanDefinitionRegistry registry) {
        this.bdToClassRepository = repository;
        this.bdRegistry = registry;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> beanClass) {
        String beanId = bdToClassRepository.getBeanId(beanClass);
        return (T) getBean(beanId);
    }


    @Override
    public Object getBean(String beanName) {
        BeanDefinition beanDefinition = bdRegistry.getBeanDefinition(beanName);
        Class<?> beanClass = null;

        try {
            beanClass = Class.forName(beanDefinition.getClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (singletons.containsKey(beanClass)) {
            return singletons.get(beanClass);
        }

        Object bean = null;
        try {
            bean = Objects.requireNonNull(beanClass).getConstructor().newInstance();
            Collection<BeanPropertyDefinition> properties = beanDefinition.getProperties();
            if (properties != null && properties.size() > 0) {
                for (BeanPropertyDefinition property : properties) {
                    Field field = beanClass.getDeclaredField(property.getName());
                    if (property.getRef() != null) {
                        beanPropertySetter.setReference(bean, field, property);
                    } else if (property.getData() == null) {
                        beanPropertySetter.setValue(bean, field, property);
                    } else if (property.getData() != null) {
                        beanPropertySetter.setComplexData(bean, field, property);
                    }
                }
            }
            if (beanDefinition.getPostConstruct() != null) {
                beanClass.getMethod(beanDefinition.getPostConstruct()).invoke(bean);
            }
            if (beanDefinition.getScope() != null
                    && beanDefinition.getScope().equals("singleton")) {
                singletons.put(beanClass, bean);
            }
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
        }
        return bean;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return (T) getBean(beanName);
    }
}
