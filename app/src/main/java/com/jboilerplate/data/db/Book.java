package com.jboilerplate.data.db;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by user on 11/29/2017.
 */

public class Book extends SugarRecord {
    @Unique
    String isbn;
    String title;
    String edition;

    // Default constructor is necessary for SugarRecord
    public Book() {

    }

    public Book(String isbn, String title, String edition) {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
    }

    public String toString(){
        return "book ISBN: " + isbn + " | book title: " + title + " | book edition: " + edition;
    }
}
