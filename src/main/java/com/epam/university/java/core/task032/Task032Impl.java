package com.epam.university.java.core.task032;


import java.lang.reflect.Proxy;

public class Task032Impl implements Task032 {

    @Override
    public CountingProxy createProxyWrapper() {
        CountingProxy countingProxy = new CountingProxyImpl(new SomeActionExecutorImpl());
        return countingProxy;
    }

    @Override
    public SomeActionExecutor createExecutorWithProxy(CountingProxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException();
        }

        SomeActionExecutor executor = (SomeActionExecutor) Proxy.newProxyInstance(
                Task032Impl.class.getClassLoader(),
                new Class[] {SomeActionExecutor.class},
                proxy);
        return executor;
    }
}
