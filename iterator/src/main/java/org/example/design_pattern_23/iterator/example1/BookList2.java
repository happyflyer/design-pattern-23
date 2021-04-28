package org.example.design_pattern_23.iterator.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lifei
 */
public class BookList2 {
    private final List<Book> bookList;

    public BookList2() {
        this.bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public void removeBook(Book book) {
        bookList.remove(book);
    }

    public List<Book> getBookList() {
        return this.bookList;
    }
}
