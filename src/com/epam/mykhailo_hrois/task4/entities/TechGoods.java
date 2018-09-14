package com.epam.mykhailo_hrois.task4.entities;

import java.math.BigDecimal;
import java.util.Objects;

public class TechGoods extends Goods {
    private String brand;

    TechGoods() {
    }

    public TechGoods(int id, BigDecimal price, String brand) {
        super(id, price);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TechGoods)) return false;
        if (!super.equals(o)) return false;
        TechGoods techGoods = (TechGoods) o;
        return getId() == techGoods.getId() &&
                Objects.equals(getPrice(), techGoods.getPrice()) &&
                Objects.equals(getBrand(), techGoods.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getBrand());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TechGoods{");
        sb.append("id=").append(getId());
        sb.append(", price=").append(getPrice());
        sb.append(", brand=").append(brand);
        sb.append('}');
        return sb.toString();
    }
}
