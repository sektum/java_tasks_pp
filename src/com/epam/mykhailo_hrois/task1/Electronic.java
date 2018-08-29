package com.epam.mykhailo_hrois.task1;

import java.util.Objects;

public class Electronic extends Product {
    private boolean isWireless;
    private double voltage;

    public Electronic() {

    }

    public Electronic(String name, double price, boolean isAvailable, boolean isInBasket, String country, boolean isWireless, double voltage) {
        super(name, price, isAvailable, isInBasket, country);
        this.isWireless = isWireless;
        this.voltage = voltage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Electronic)) return false;
        if (!super.equals(o)) return false;
        Electronic that = (Electronic) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                isWireless() == that.isWireless() &&
                Double.compare(that.getVoltage(), getVoltage()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isWireless(), getVoltage());
    }

    public double getVoltage() {
        return voltage;
    }

    public void setVoltage(double voltage) {
        this.voltage = voltage;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean wireless) {
        isWireless = wireless;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", isAvailable=" + isAvailable() +
                ", isInBasket=" + isInBasket() +
                ", country='" + getCountry() + '\'' +
                '}' + '\n' + "Electronic{" +
                "isWireless=" + isWireless +
                ", voltage=" + voltage +
                '}';
    }
}
