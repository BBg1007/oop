package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private Map<String, List<Product>> productBasket;


    public ProductBasket() {
        this.productBasket = new LinkedHashMap<String, List<Product>>();
    }

    public void addProduct(Product product) {
        productBasket.computeIfAbsent(product.getName(), k -> new LinkedList<>()).add(product);

    }


    public int fullPrice() {
        int sum = 0;

        for (List<Product> products : productBasket.values()) {
            for (Product product : products) {
                sum += product.getPrice();
            }
        }

        return sum;
    }


    public void printBasket() {
        if (productBasket.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }
        for (List<Product> products : productBasket.values()) {
            for (Product product : products) {
                System.out.println(product);
            }
        }
        System.out.println("Итого: " + fullPrice());
        System.out.println("Специальных товаров: " + specialProductCounter());
    }


    public boolean findProduct(String nameProduct) {
        if (productBasket.containsKey(nameProduct)) {
            return true;
        }

        return false;
    }

    private int specialProductCounter() {
        int counter = 0;

        for (List<Product> products : productBasket.values()) {
            for (Product product : products) {
                if (product.isSpecial()) {
                    counter++;
                }
            }
        }

        return counter;
    }

    public void clearBasket() {
        productBasket.clear();
    }

    public List<Product> deleteProduct(String name) {
        List<Product> deletedProducts = new LinkedList<Product>();

        if (productBasket.containsKey(name)) {
            deletedProducts = productBasket.get(name);
            productBasket.remove(name);
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


