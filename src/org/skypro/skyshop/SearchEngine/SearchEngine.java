package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Exeptions.BestResultNotFound;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchEngine {

    public Set<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new HashSet<>();
    }

    public Set<Searchable> search(String textForSearch) {
        Set<Searchable> searchResult;
        searchResult = searchables.stream()
                .filter(searchable -> searchable.searchTerm().toLowerCase().contains(textForSearch.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableByLengthComparator())));


        return searchResult;
    }

    public void add(Searchable searchable) {
        this.searchables.add(searchable);
    }


    public void printSearchResult(Set<Searchable> searchResult) {
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
