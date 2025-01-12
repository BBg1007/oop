package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket(5);
        //1. Добавление продуктов в корзину:
        productBasket.addSimpleProduct("Колесо", 6000);
        productBasket.DiscountedProduct("Вилка", 6800,6);
        productBasket.FixPriceProduct("Цепь");
        productBasket.DiscountedProduct("Звездочка", 2300,9);
        productBasket.addSimpleProduct("Руль, прямой", 4600);
        //2. Добавление продукта в заполненную корзину, в которой нет свободного места:
        productBasket.addSimpleProduct("Рама", 15000);
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