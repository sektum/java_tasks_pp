package com.epam.mykhailo_hrois.task4.entities;

import java.math.BigDecimal;
import java.util.Objects;

public class Goods {
    private int id;
    private BigDecimal price;

    Goods() {
    }

    public Goods(int id, BigDecimal price) {
        this.id = id;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Goods{");
        sb.append("id=").append(id);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Goods)) return false;
        Goods goods = (Goods) o;
        return getId() == goods.getId() &&
                Objects.equals(getPrice(), goods.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPrice());
    }
}
