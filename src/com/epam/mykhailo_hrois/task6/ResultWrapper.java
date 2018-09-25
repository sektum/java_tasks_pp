package com.epam.mykhailo_hrois.task6;

public class ResultWrapper {
    private byte[] currentBytes;
    private int firstIndex;
    private int secondIndex;

    public byte[] getCurrentBytes() {
        return currentBytes;
    }

    public void setCurrentBytes(byte[] currentBytes) {
        this.currentBytes = currentBytes;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public int getSecondIndex() {
        return secondIndex;
    }

    public void setSecondIndex(int secondIndex) {
        this.secondIndex = secondIndex;
    }
}
