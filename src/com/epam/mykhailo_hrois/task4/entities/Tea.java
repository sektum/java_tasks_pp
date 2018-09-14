package com.epam.mykhailo_hrois.task4.entities;

import java.math.BigDecimal;
import java.util.Objects;

public class Tea extends GroceryGoods {
    private String color;

    Tea() {
    }

    public Tea(int id, BigDecimal price, double caloricity, String color) {
        super(id, price, caloricity);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tea)) return false;
        if (!super.equals(o)) return false;
        Tea tea = (Tea) o;
        return getId() == tea.getId() &&
                Objects.equals(getPrice(), tea.getPrice()) &&
                Double.compare(tea.getCaloricity(), getCaloricity()) == 0 &&
                Objects.equals(getColor(), tea.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getColor());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tea{");
        sb.append("id=").append(getId());
        sb.append(", price=").append(getPrice());
        sb.append(", caloricity=").append(getCaloricity());
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
