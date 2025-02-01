package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Exeptions.BestResultNotFound;

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

        for (int i = 0; i < searchables.length; i++) {

            if (searchables[i] == null) {
                searchables[i] = searchable;
                System.out.println(searchables[i].getName()+" добавлено.");
                return;
            }
        }
        System.out.println("Невозможно добавить. Нет места.");

    }



    public void printSearchResult(Searchable[] searchResult) {
        for (Searchable searchable : searchResult) {

            if (searchable != null) {
                System.out.println(searchable.getStringRepresentation());
            }

        }

    }

    public Searchable searchBestMatch(String search) throws BestResultNotFound {

        Searchable bestMatch = null;
        int bestMatchCount = 0;

        for (Searchable searchable : searchables) {

            int index = 0;
            int count = 0;
            if (searchable != null) {
            int indexSubstring = searchable.searchTerm().toLowerCase().indexOf(search.toLowerCase(),index);
            while (indexSubstring != -1) {
                count++;
                index=indexSubstring + search.length();
                indexSubstring = searchable.searchTerm().toLowerCase().indexOf(search.toLowerCase(),index);
                if (count>bestMatchCount) {
                    bestMatchCount = count;
                    bestMatch = searchable;
                }
                }
            }
        }
            if (bestMatch == null) {
             throw new BestResultNotFound(search);
            }

        return bestMatch;
    }






















}
