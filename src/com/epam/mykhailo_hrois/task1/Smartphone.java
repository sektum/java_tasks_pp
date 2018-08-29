package com.epam.mykhailo_hrois.task1;

import java.util.Objects;

public class Smartphone extends Electronic {
    private String OS;
    private String core;
    private double RAM;
    private double storage;
    private double screenSize;
    private int simNumber;

    public Smartphone() {

    }

    public Smartphone(String name, double price, boolean isAvailable, boolean isInBasket, String country, boolean isWireless,
                      double voltage, String OS, String core, double RAM, double storage, double screenSize, int simNumber) {
        super(name, price, isAvailable, isInBasket, country, isWireless, voltage);
        this.OS = OS;
        this.core = core;
        this.RAM = RAM;
        this.storage = storage;
        this.screenSize = screenSize;
        this.simNumber = simNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Smartphone)) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCountry(), that.getCountry()) &&
                isWireless() == that.isWireless() &&
                Double.compare(that.getVoltage(), getVoltage()) == 0 &&
                Double.compare(that.getRAM(), getRAM()) == 0 &&
                Double.compare(that.getStorage(), getStorage()) == 0 &&
                Double.compare(that.getScreenSize(), getScreenSize()) == 0 &&
                getSimNumber() == that.getSimNumber() &&
                Objects.equals(getOS(), that.getOS()) &&
                Objects.equals(getCore(), that.getCore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOS(), getCore(), getRAM(), getStorage(), getScreenSize(), getSimNumber());
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", isAvailable=" + isAvailable() +
                ", isInBasket=" + isInBasket() +
                ", country='" + getCountry() + '\'' +
                "isWireless=" + isWireless() +
                ", voltage=" + getVoltage() +
                "OS='" + OS + '\'' +
                ", core='" + core + '\'' +
                ", RAM=" + RAM +
                ", storage=" + storage +
                ", screenSize=" + screenSize +
                ", simNumber=" + simNumber +
                '}';
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    public double getRAM() {
        return RAM;
    }

    public void setRAM(double RAM) {
        this.RAM = RAM;
    }

    public double getStorage() {
        return storage;
    }

    public void setStorage(double storage) {
        this.storage = storage;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(int simNumber) {
        this.simNumber = simNumber;
    }
}
