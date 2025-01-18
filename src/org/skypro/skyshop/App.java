package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct.SimpleProduct;

public class App {
    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket(5);
        Product product = new SimpleProduct("Вилка",6000);
        Product product1 = new DiscountedProduct("Вилка", 6800,6);
        Product product2 = new FixPriceProduct("Цепь");
        Product product3 = new DiscountedProduct("Звездочка", 2300,9);
        Product product4 = new SimpleProduct("Рама", 15000);
        productBasket.addProduct(product);
        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);

        //3. Печать содержимого корзины с несколькими товарами:
        productBasket.printList();
        //4. Получение стоимости корзины с несколькими товарами:
        System.out.println(productBasket.fullPrice());
        //5. Поиск товара, который есть в корзине (в условии возвращает boolean):
        System.out.println(productBasket.findProduct("Цепь"));
        //6. Поиск товара, которого нет в корзине.
        System.out.println(productBasket.findProduct("Рама"));
        //7. Очистка корзины:
        productBasket.clearBasket();
        //8. Печать содержимого пустой корзины:
        productBasket.printList();
        //9. Получение стоимости пустой корзины:
        System.out.println(productBasket.fullPrice());
        //10. Поиск товара по имени в пустой корзине:
        System.out.println(productBasket.findProduct("Колесо"));


    }
}