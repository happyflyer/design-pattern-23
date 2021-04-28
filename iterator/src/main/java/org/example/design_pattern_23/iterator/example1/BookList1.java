package org.example.design_pattern_23.iterator.example1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lifei
 */
public class BookList1 {
    private final List<Book> bookList;
    private int index;

    public BookList1() {
        this.bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public void removeBook(Book book) {
        bookList.remove(book);
    }

    public boolean hasNext() {
        return index < bookList.size();
    }

    public Book getNext() {
        return this.bookList.get(index++);
    }
}
