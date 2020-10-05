package com.epam.university.java.core.task032;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CountingProxyImpl implements CountingProxy {
    Map<String, Integer> map = new HashMap<>();
    private final SomeActionExecutorImpl target;

    public CountingProxyImpl(SomeActionExecutorImpl target) {
        this.target = target;
    }

    @Override
    public int getInvocationsCount(String methodName) {

        return map.get(methodName);
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        String name = method.getName();
        map.merge(name, 1, Integer::sum);
        return method.invoke(target, objects);
    }
}
