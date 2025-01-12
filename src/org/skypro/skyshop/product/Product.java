package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product {
    private final String name;

    //По скольку в данном задании не нужно изменять цену товара - присвоил модификатор final.

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isSpecial();


    public abstract int getPrice();


    @Override
    public String toString() {
        return "Товар: " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
