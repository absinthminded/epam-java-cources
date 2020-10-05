package com.epam.university.java.core.task037;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task037Impl implements Task037 {
    @Override
    public Collection<String> switcher(Callable<String> ticker, Callable<String> tacker) {
        if (ticker == null || tacker == null) {
            throw new IllegalArgumentException();
        }

        List<Callable<String>> tasks = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            tasks.add(ticker);
            tasks.add(tacker);
        }

        List<String> result = new LinkedList<>();
        ExecutorService executorService = Executors.newWorkStealingPool(2);

        try {
            List<Future<String>> futures = executorService.invokeAll(tasks);
            futures.forEach(future -> {
                try {
                    result.add(future.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        return result;
    }
}
