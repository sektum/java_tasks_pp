package com.epam.mykhailo_hrois.task6;

import java.util.Scanner;
import java.util.concurrent.*;

public class Demo {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder stringBuilder;
        ResultWrapper result = null;
        Callable<ResultWrapper> resultWrapperCallable = null;
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<ResultWrapper> future = null;
        while (!executor.isShutdown()) {
            stringBuilder = new StringBuilder();
            String input = scanner.next();
            if(input.equals("stop")){
                executor.shutdown();
            }
            else {
                resultWrapperCallable = new CallableFindAndPush(input);
                future = executor.submit(resultWrapperCallable);
                try {
                    result = future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                stringBuilder.append(result);
                stringBuilder.append(System.lineSeparator());
                stringBuilder.append("Length: ").append(result.getCurrentBytes().length);
                stringBuilder.append(System.lineSeparator());
                stringBuilder.append("First index: ").append(result.getFirstIndex());
                stringBuilder.append(System.lineSeparator());
                stringBuilder.append("Second index: ").append(result.getSecondIndex());
                System.out.println(stringBuilder);
            }
        }
    }
}
