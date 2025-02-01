package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


public class ProductBasket {
    private List<Product> productBasket;


    public ProductBasket() {
        this.productBasket = new LinkedList<Product>();
    }

    public void addProduct(Product product) {
        productBasket.add(product);

    }


    public int fullPrice() {
        int sum = 0;

        for (Product p : productBasket) {
            sum += p.getPrice();
        }

        return sum;
    }


    public void printBasket() {
        if (isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }
        for (Product p : productBasket) {
            System.out.println(p.toString());
        }
        System.out.println("Итого: " + fullPrice());
        System.out.println("Специальных товаров: " + specialProductCounter());
    }

    boolean isEmpty() {

        if (productBasket.size() == 0) {
            return true;
        }

        return false;
    }

    public boolean findProduct(String nameProduct) {
        if (isEmpty()) {
            return false;
        }

        for (Product p : productBasket) {
            if (nameProduct.toLowerCase().equals(p.getName().toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    private int specialProductCounter() {
        int counter = 0;
        for (Product p : productBasket) {
            if (p.isSpecial()) {
                counter++;
            }
        }
        return counter;
    }

    public void clearBasket() {
        productBasket.clear();
    }

    public List<Product> deleteProduct(String name) {
        List<Product> deletedProducts = new LinkedList<Product>();

        for (int i = 0; i < productBasket.size(); i++) {
            if (productBasket.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
                deletedProducts.add(productBasket.get(i));
                productBasket.remove(productBasket.get(i));
                i--;
            }
        }
        if (deletedProducts.size() == 0) {
            System.out.println("Список пуст");
        }

        return deletedProducts;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductBasket that = (ProductBasket) o;
        return Objects.equals(productBasket, that.productBasket);
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(productBasket);
    }
}


