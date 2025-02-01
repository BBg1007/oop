package org.skypro.skyshop;

import org.skypro.skyshop.Exeptions.BestResultNotFound;
import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.SearchEngine.Searchable;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct.SimpleProduct;

import java.util.List;



public class App {
    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket();
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
        productBasket.printBasket();
        //4. Получение стоимости корзины с несколькими товарами:
        System.out.println(productBasket.fullPrice());
        //5. Поиск товара, который есть в корзине (в условии возвращает boolean):
        System.out.println(productBasket.findProduct("Цепь"));
        //6. Поиск товара, которого нет в корзине.
        System.out.println(productBasket.findProduct("Рама"));
        //7. Очистка корзины:
        productBasket.clearBasket();
        //8. Печать содержимого пустой корзины:
        productBasket.printBasket();

        //9. Получение стоимости пустой корзины:
        System.out.println(productBasket.fullPrice());
        //10. Поиск товара по имени в пустой корзине:
        System.out.println(productBasket.findProduct("Колесо"));
        System.out.println();


        SearchEngine searchEngine = new SearchEngine();
        Article article = new Article("Модели велосипедов для не высоких людей", "Горный велосипед PLANDY год 2024, рама 14, на рост 140-175см или Lorak Glory 100, фиолетовый, 26 дюймов, 17 размер рамы под рост 160-175 см");
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
        List<Searchable> search1 = searchEngine.search("колесо");
        searchEngine.printSearchResult(search1);
        System.out.println();
        List<Searchable> search2 = searchEngine.search("вилка");
        searchEngine.printSearchResult(search2);
        List<Searchable> search = searchEngine.search("вело");
        searchEngine.printSearchResult(search);

        //Код для дз темы "Исключения" :

        try {
            Product product5 = new SimpleProduct("", 5000);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            Product product6 = new DiscountedProduct("Горный велосипед", 45000, 125);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            Product product7 = new DiscountedProduct("Колесо", 0, 4);
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            System.out.println(searchEngine.searchBestMatch("колесо").getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }
        try {
            System.out.println(searchEngine.searchBestMatch("вилка").getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e);
        }
        //Демонстрация по теме Коллекции:

        productBasket.addProduct(product);
        productBasket.addProduct(product1);
        productBasket.addProduct(product2);
        productBasket.addProduct(product3);
        productBasket.addProduct(product4);

//1. Удалить существующий продукт из корзины.
        List<Product> deleted = productBasket.deleteProduct("Вилка");
//2. Вывести удаленные продукты на экран.
        System.out.println("Удаленные продукты: " + deleted);
//3.Вывести содержимое корзины с помощью метода printBasket
        System.out.println("Содержимое корзины: ");
        productBasket.printBasket();
//4.5. Удалить несуществующий продукт. Проверить, что список удаленных продуктов пустой и вывести сообщение “Список пуст”.
        productBasket.deleteProduct("Вилка");
//6. Вывести содержимое корзины на экран.
        productBasket.printBasket();

//Демонстрация изменений класса SimpleProduct:

        Product product5 = new SimpleProduct("Велосипед горный", 60000);
        Product product6 = new DiscountedProduct("Велосипед детский, трехколесный.", 15000, 5);
        Product product7 = new DiscountedProduct("Велосипед классический", 25000, 10);
        searchEngine.add(product5);
        searchEngine.add(product6);
        searchEngine.add(product7);
        search = searchEngine.search("вело");
        searchEngine.printSearchResult(search);


    }

}