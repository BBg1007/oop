package org.skypro.skyshop.SearchEngine;

public class SearchEngine {

    public Searchable[] searchables;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];
    }

    public Searchable[] search(String textForSearch) {
        Searchable[] searchResult = new Searchable[5];

        for (int i = 0, count = 0; i < searchables.length && count < 4; i++) {
            if (searchables[i] != null) {
                if (searchables[i].searchTerm().toLowerCase().contains(textForSearch)) {
                    searchResult[count] = searchables[i];
                    count++;
                }
            }
        }
        return searchResult;
    }

    public void add(Searchable searchable) {

        if (isFull()) {
            System.out.println("Невозможно добавить. Нет места.");
            return;
        }

        for (int i = 0; i < searchables.length; i++) {

            if (searchables[i] == null) {
                searchables[i] = searchable;
                return;
            }

        }

    }

    private boolean isFull() {
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                return false;
            }
        }
        return true;
    }

    public void printSearchResult(Searchable[] searchResult) {
        for (int i = 0; i < searchResult.length; i++) {

            if (searchResult[i] != null) {
                System.out.println(searchResult[i].getStringRepresentation());
            }

        }

    }


}
