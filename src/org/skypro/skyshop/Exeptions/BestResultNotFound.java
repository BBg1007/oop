package org.skypro.skyshop.Exeptions;

import java.io.IOException;

public class BestResultNotFound extends IOException {

    private String search;

    public BestResultNotFound(String search) {
        this.search = search;
    }

    @Override
    public String toString(){
        return "По запросу "+search+" ничего не найдено.";
    }
}


