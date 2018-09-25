package com.epam.mykhailo_hrois.task6;

import java.util.concurrent.Callable;

public class CallableFindAndPush implements Callable<ResultWrapper> {
    private static ResultWrapper resultWrapper = new ResultWrapper();
    private final static int MULTI_COUNT = 2;
    private final byte[] sequence;

    public CallableFindAndPush(byte[] sequence) {
        this.sequence = sequence;
    }

    public static ResultWrapper getResultWrapper() {
        return resultWrapper;
    }

    @Override
    public ResultWrapper call() throws Exception {
        if(sequence.length > resultWrapper.getCurrentBytes().length){
            resultWrapper.setCurrentBytes(sequence);
        }
        return resultWrapper;
    }
}
