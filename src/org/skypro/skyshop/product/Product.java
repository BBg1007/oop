package org.skypro.skyshop.product;

import java.util.Objects;

public class Product {
    private final String name;
    private final int price;
    //По скольку в данном задании не нужно изменять цену товара - присвоил модификатор final.

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Товар: " + name + " " + "Цена " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
