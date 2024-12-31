package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] productBasket;
    private int size;

    public ProductBasket(int basketSize) {
        this.productBasket = new Product[basketSize];
        size=0;
    }

    public void addProduct(String productName, int productPrice) {
        if (size >= productBasket.length) {
            System.out.println("Невозможно добавить продукт, корзина переполнена.");
        }
        for (int i = 0; i < productBasket.length ; i++) {
            if (productBasket[i] == null) {
                productBasket[i] = new Product(productName, productPrice);
                size++;
                break;

            }
        }
    }

    public int fullPrice() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
         sum += productBasket[i].getPrice();
        }
        return sum;
    }


    public void printList() {
        if (isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }
            for (int i = 0; i < size; i++) {
                System.out.println(productBasket[i]);
            }
    }

    public boolean isEmpty() {
        for (int i = 0; i < size; i++) {
            if (productBasket[i].getName() != null) {
                return false;
            }
        }
        return true;
    }

    public boolean findProduct(String nameProduct) {
        if (isEmpty()) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (productBasket[i].getName().equals(nameProduct)) {
                return true;
            }
        }

        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < size; i++) {
            productBasket[i] = null;
        }
        size = 0;
    }



}


