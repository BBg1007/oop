package org.skypro.skyshop.article;

import org.skypro.skyshop.SearchEngine.Searchable;

import java.util.Objects;

public class Article implements Searchable {

    private final String title;
    private final String text;

    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    @Override
    public String searchTerm() {
        return title + text;
    }

    @Override
    public String getType() {
        return "ARTICLE";
    }

    @Override
    public String toString() {
        return title + System.lineSeparator() + text;
    }

    @Override
    public String getName() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }
}
