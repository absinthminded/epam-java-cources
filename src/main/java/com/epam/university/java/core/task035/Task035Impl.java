package com.epam.university.java.core.task035;

import com.epam.university.java.core.task034.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;

public class Task035Impl implements Task035 {
    @Override
    public Person readWithJackson(ObjectMapper mapper, String jsonString) {
        return null;
    }

    @Override
    public Person readWithGson(GsonBuilder builder, String jsonString) {
        return null;
    }
}
