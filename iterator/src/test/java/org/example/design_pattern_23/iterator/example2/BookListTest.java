package org.example.design_pattern_23.iterator.example2;

import org.junit.Test;

import java.util.Iterator;

public class BookListTest {
    @Test
    public void test() {
        BookList bookList = new BookList();
        Book book1 = new Book("010203", "Java编程思想", 90);
        Book book2 = new Book("010204", "Java从入门到精通", 60);
        bookList.addBook(book1);
        bookList.addBook(book2);
        Iterator<Book> iter = bookList.getIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
