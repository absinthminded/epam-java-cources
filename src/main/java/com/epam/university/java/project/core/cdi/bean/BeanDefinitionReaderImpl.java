package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Collection;

public class BeanDefinitionReaderImpl implements BeanDefinitionReader {
    private final BeanDefinitionRegistry bdRegistry;
    private final BeanDefinitionToClassRepository bdToClassRepository;

    public BeanDefinitionReaderImpl(BeanDefinitionRegistry registry,
                                    BeanDefinitionToClassRepository repository) {
        this.bdRegistry = registry;
        this.bdToClassRepository = repository;
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        File resourceFile = resource.getFile();
        BeanDefinitionsList definitionsList = null;
        int numberOfDefinitions = 0;

        try {
            JAXBContext context = JAXBContext.newInstance(BeanDefinitionsList.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            definitionsList = (BeanDefinitionsList) unmarshaller.unmarshal(resourceFile);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        if (definitionsList != null) {
            for (BeanDefinition definition : definitionsList.getBdList()) {
                bdRegistry.addBeanDefinition(definition);
                numberOfDefinitions++;
            }
        }
        return numberOfDefinitions;
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        int numberOfDefinitions = 0;
        for (Resource resource : resources) {
            numberOfDefinitions += loadBeanDefinitions(resource);
        }
        return numberOfDefinitions;
    }
}
