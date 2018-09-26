package com.epam.mykhailo_hrois.task6;

import java.util.Scanner;
import java.util.concurrent.*;

public class Demo {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        ResultWrapper result = null;
        Callable<ResultWrapper> resultWrapperCallable = new CallableFindAndPush(scanner.next());
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<ResultWrapper> future = executor.submit(resultWrapperCallable);
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
        System.out.println(result);
        System.out.println("Length: " + result.getCurrentBytes().length);
        System.out.println("First index: " + result.getFirstIndex());
        System.out.println("Second index: " + result.getSecondIndex());
    }
}
