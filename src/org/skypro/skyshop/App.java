package org.skypro.skyshop;

import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.SearchEngine.Searchable;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket(5);
        Product product = new SimpleProduct("Вилка", 6000);
        Product product1 = new DiscountedProduct("Вилка", 6800, 6);
        Product product2 = new FixPriceProduct("Цепь");
        Product product3 = new DiscountedProduct("Звездочка", 2300, 9);
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
        System.out.println();


        SearchEngine searchEngine = new SearchEngine(10);
        Article article = new Article("Модели волесипедов для не высоких людей", "Горный велосипед PLANDY год 2024, рама 14, на рост 140-175см или Lorak Glory 100, фиолетовый, 26 дюймов, 17 размер рамы под рост 160-175 см");
        Article article1 = new Article("Виды вилок для велосипеда", "Жесткие и Амортизационные (Пружинные, Воздушные, Воздушно-масляные и Пружинно-масляные");
        Article article2 = new Article("Типы рам велосипедов", "Жёсткий (ригидный), Хардтейл, Двухподвес.");
        searchEngine.add(article2);
        searchEngine.add(article1);
        searchEngine.add(article);
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product);
        Searchable[] search1 = searchEngine.search("колесо");
        searchEngine.printSearchResult(search1);
        System.out.println();
        Searchable[] search2 = searchEngine.search("вилка");
        searchEngine.printSearchResult(search2);
        Searchable[] search = searchEngine.search("вело");
        searchEngine.printSearchResult(search);


    }
}