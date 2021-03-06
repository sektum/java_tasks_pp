package com.epam.mykhailo_hrois.task1;

import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private boolean isAvailable;
    private boolean isInBasket;
    private String country;

    public Product(String name, double price, boolean isAvailable, boolean isInBasket, String country) {
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
        this.isInBasket = isInBasket;
        this.country = country;
    }

    public Product() {

    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", isAvailable=" + isAvailable +
                ", isInBasket=" + isInBasket +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.getPrice(), getPrice()) == 0 &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getCountry(), product.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getCountry());
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isInBasket() {
        return isInBasket;
    }

    public void setInBasket(boolean inBasket) {
        isInBasket = inBasket;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
