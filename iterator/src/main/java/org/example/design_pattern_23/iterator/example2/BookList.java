package org.example.design_pattern_23.iterator.example2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author lifei
 */
public class BookList {
    private final List<Book> bookList;
    private int index;

    public BookList() {
        this.bookList = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.bookList.add(book);
    }

    public void removeBook(Book book) {
        bookList.remove(book);
    }

    public Iterator<Book> getIterator() {
        return new Itr();
    }

    private class Itr implements Iterator<Book> {
        @Override
        public boolean hasNext() {
            return index < bookList.size();
        }

        @Override
        public Book next() {
            return bookList.get(index++);
        }

        @Override
        public void remove() {
        }

        @Override
        public void forEachRemaining(Consumer action) {
        }
    }
}
