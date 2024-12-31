package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {
    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket(5);
        //1. Добавление продуктов в корзину:
        productBasket.addProduct("Колесо",6000);
        productBasket.addProduct("Вилка",6800);
        productBasket.addProduct("Цепь",1200);
        productBasket.addProduct("Звездочка",2300);
        productBasket.addProduct("Руль, прямой",4600);
        //2. Добавление продукта в заполненную корзину, в которой нет свободного места:
        productBasket.addProduct("Рама",15000);
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