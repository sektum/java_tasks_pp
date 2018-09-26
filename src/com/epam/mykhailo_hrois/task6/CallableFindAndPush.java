package com.epam.mykhailo_hrois.task6;

import java.util.List;
import java.util.concurrent.Callable;

public class CallableFindAndPush implements Callable<ResultWrapper> {
    private ResultWrapper resultWrapper = new ResultWrapper();
    private final String path;
    private boolean isSameLength;
    private int index;

    public CallableFindAndPush(String path) {
        this.path = path;
    }

    public ResultWrapper getResultWrapper() {
        return resultWrapper;
    }

    @Override
    public ResultWrapper call() throws Exception {
        List<byte[]> resultList = ReadFileIntoByteArrays.readFile(path);
        for (byte[] sequence : resultList) {
            if (sequence.length > resultWrapper.getCurrentBytes().length) {
                resultWrapper.setCurrentBytes(sequence);
                resultWrapper.setFirstIndex(index);
                isSameLength = false;
            } else if (sequence.length == resultWrapper.getCurrentBytes().length && !isSameLength) {
                resultWrapper.setSecondIndex(index);
                isSameLength = true;
            }
            index += sequence.length;
        }
        return resultWrapper;
    }
}
