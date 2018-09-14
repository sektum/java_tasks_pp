package com.epam.mykhailo_hrois.task4;

import java.math.BigDecimal;
import java.util.Objects;

public class Keyboard extends TechGoods {
    private String type;

    Keyboard() {
    }

    public Keyboard(int id, BigDecimal price, String brand, String type) {
        super(id, price, brand);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Keyboard)) return false;
        if (!super.equals(o)) return false;
        Keyboard keyboard = (Keyboard) o;
        return getId() == keyboard.getId() &&
                Objects.equals(getPrice(), keyboard.getPrice()) &&
                Objects.equals(getBrand(), keyboard.getBrand()) &&
                Objects.equals(getType(), keyboard.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getType());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Keyboard{");
        sb.append("id=").append(getId());
        sb.append(", price=").append(getPrice());
        sb.append(", brand=").append(getBrand());
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
