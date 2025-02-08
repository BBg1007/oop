package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Exeptions.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {

    public List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<Searchable>();
    }

    public Map<String,Searchable> search(String textForSearch) {
        Map<String,Searchable> searchResult = new TreeMap<>();

        for (int i = 0; i < searchables.size(); i++) {
            if (searchables.get(i) != null) {
                if (searchables.get(i).searchTerm().toLowerCase().contains(textForSearch.toLowerCase())) {
                    searchResult.put(searchables.get(i).getName(),searchables.get(i));

                }
            }
        }
        return searchResult;
    }

    public void add(Searchable searchable) {
        this.searchables.add(searchable);
    }


    public void printSearchResult(Map<String,Searchable> searchResult) {
        for (Searchable searchable : searchResult.values()) {

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
                int indexSubstring = searchable.searchTerm().toLowerCase().indexOf(search.toLowerCase(), index);
                while (indexSubstring != -1) {
                    count++;
                    index = indexSubstring + search.length();
                    indexSubstring = searchable.searchTerm().toLowerCase().indexOf(search.toLowerCase(), index);
                    if (count > bestMatchCount) {
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
