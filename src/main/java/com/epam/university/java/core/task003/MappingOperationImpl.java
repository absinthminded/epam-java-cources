package com.epam.university.java.core.task003;

public class MappingOperationImpl implements MappingOperation {

    @Override
    public String map(String source) {
        StringBuilder input1 = new StringBuilder();

        input1.append(source);

        source = input1.reverse().toString();

        return source;
    }
}

