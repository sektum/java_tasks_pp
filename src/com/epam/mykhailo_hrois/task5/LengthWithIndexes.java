package com.epam.mykhailo_hrois.task5;

public class LengthWithIndexes {
    private Integer length;
    private Integer firstIndex;
    private Integer secondIndex;

    public LengthWithIndexes(Integer length, Integer firstIndex, Integer secondIndex) {
        this.length = length;
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(Integer firstIndex) {
        this.firstIndex = firstIndex;
    }

    public Integer getSecondIndex() {
        return secondIndex;
    }

    public void setSecondIndex(Integer secondIndex) {
        this.secondIndex = secondIndex;
    }
}
