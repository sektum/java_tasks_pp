package com.epam.mykhailo_hrois.task4;

import java.math.BigDecimal;
import java.util.Objects;

public class Smartphone extends TechGoods {
    private String OS;

    Smartphone(){
    }

    public Smartphone(int id, BigDecimal price, String brand, String OS) {
        super(id, price, brand);
        this.OS = OS;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Smartphone{");
        sb.append("id=").append(getId());
        sb.append(", price=").append(getPrice());
        sb.append(", brand=").append(getBrand());
        sb.append(", OS=").append(OS);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Smartphone)) return false;
        if (!super.equals(o)) return false;
        Smartphone that = (Smartphone) o;
        return getId() == that.getId() &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getBrand(), that.getBrand()) &&
                Objects.equals(getOS(), that.getOS());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getOS());
    }
}
