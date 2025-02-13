package org.skypro.skyshop.SearchEngine;

import java.util.Comparator;

public class SearchableByLengthComparator implements Comparator<Searchable> {


    @Override
    public int compare(Searchable s1, Searchable s2) {
        if (Integer.compare(s2.getName().length(), s1.getName().length()) != 0) {
            return Integer.compare(s2.getName().length(), s1.getName().length());
        }
        return s1.getName().compareTo(s2.getName());
    }
}
