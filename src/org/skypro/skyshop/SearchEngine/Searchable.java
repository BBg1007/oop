package org.skypro.skyshop.SearchEngine;

public interface Searchable {

    public String searchTerm();

    public String getType();

    public String getName();

    default String getStringRepresentation() {
        return this.getName() + " - " + this.getType();
    }


}
