package com.jboilerplate.data.db;

import com.orm.SugarRecord;

import java.util.ArrayList;

public class DataBaseHelper {
    /**
     * save a record
     * @param isbn
     * @param title
     * @param edition
     */
    public void saveBookInfo(String isbn, String title, String edition){
        Book book = new Book(isbn, title, edition);
        book.save();
//      or SugarRecord.save(book); // if using the @Table annotation
    }

    /**
     * bulk insert
     * @param books
     */
    public void saveBookInfoList(ArrayList<Book> books){
        SugarRecord.saveInTx(books);
    }

    /**
     * load a record via index
     * @param index
     * @return
     */
    public Book loadBookInfo(int index){
        return Book.findById(Book.class, index);
    }

    /** update a record
     * update
     * @param index
     * @param isbn
     * @param title
     * @param edition
     */
    public void updateBookInfo(int index, String isbn, String title, String edition){
        Book book = Book.findById(Book.class, index);
        book.isbn = isbn;
        book.title = title; // modify the values
        book.edition = edition;
        book.save(); // updates the previous entry with new values.
    }

    /**
     * update existing record based on unique-values
     * @param isbnAsUniqueId
     * @param title
     * @param edition
     */
    public void updateBookInfo(String isbnAsUniqueId, String title, String edition){
        // Update book with isbn123
        Book sameBook = new Book(isbnAsUniqueId, title, edition);
        sameBook.update();
//      or SugarRecord.update(sameBook); // if using the @Table annotation
    }

    /**
     * delete a record
     * @param index
     * @return
     */
    public boolean deleteBookInfo(int index){
        Book book = Book.findById(Book.class, index);
        return book.delete();
//      or SugarRecord.delete(book); // if using the @Table annotation
    }


}
