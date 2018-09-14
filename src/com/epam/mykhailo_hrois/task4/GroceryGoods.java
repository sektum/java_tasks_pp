package com.epam.mykhailo_hrois.task4;

import java.math.BigDecimal;
import java.util.Objects;

public class GroceryGoods extends Goods {
    private double caloricity;

    GroceryGoods() {
    }

    public GroceryGoods(int id, BigDecimal price, double caloricity) {
        super(id, price);
        this.caloricity = caloricity;
    }

    public double getCaloricity() {
        return caloricity;
    }

    public void setCaloricity(double caloricity) {
        this.caloricity = caloricity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroceryGoods)) return false;
        if (!super.equals(o)) return false;
        GroceryGoods that = (GroceryGoods) o;
        return getId() == that.getId() &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Double.compare(that.getCaloricity(), getCaloricity()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCaloricity());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GroceryGoods{");
        sb.append("id=").append(getId());
        sb.append(", price=").append(getPrice());
        sb.append(", caloricity=").append(caloricity);
        sb.append('}');
        return sb.toString();
    }
}
