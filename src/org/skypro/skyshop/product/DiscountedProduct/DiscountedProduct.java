package org.skypro.skyshop.product.DiscountedProduct;

import org.skypro.skyshop.product.Product;

import java.util.Objects;

public class DiscountedProduct extends Product {
    int basePrice;
    int discountValue;

    public DiscountedProduct(String name, int basePrice, int discountValue) {
        super(name);
        this.basePrice = basePrice;
        this.discountValue = discountValue;
    }


    @Override
    public boolean isSpecial() {
        return true;
    }


    @Override
    public int getPrice() {
        return basePrice * discountValue / 100;
    }

    @Override
    public String toString() {
        return getName() + " : " + getPrice() + "(" + discountValue + "%)";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return basePrice == that.basePrice && discountValue == that.discountValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), basePrice, discountValue);
    }
}
