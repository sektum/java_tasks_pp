package com.epam.mykhailo_hrois.task1;

import java.util.Objects;

public class Electronic extends Product {
    private boolean isWireless;
    private double voltage;

    public Electronic(){
        super();
        this.isWireless = false;
    }

    public Electronic(boolean isWireless, double voltage){
        this.isWireless = isWireless;
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "isWireless=" + isWireless +
                ", voltage=" + voltage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Electronic)) return false;
        if (!super.equals(o)) return false;
        Electronic that = (Electronic) o;
        return isWireless == that.isWireless &&
                Double.compare(that.getVoltage(), getVoltage()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isWireless, getVoltage());
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }
}
