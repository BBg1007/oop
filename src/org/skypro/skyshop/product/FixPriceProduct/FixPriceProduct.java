package org.skypro.skyshop.product.FixPriceProduct;

import org.skypro.skyshop.product.Product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE = 5000;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getName()+ ": Фиксированная цена: "+FIX_PRICE;
    }
}
