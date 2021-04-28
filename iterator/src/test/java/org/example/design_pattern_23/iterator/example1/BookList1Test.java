package org.example.design_pattern_23.iterator.example1;

import org.junit.Test;

public class BookList1Test {
    @Test
    public void test() {
        BookList1 bookList = new BookList1();
        Book book1 = new Book("010203", "Java编程思想", 90);
        Book book2 = new Book("010204", "Java从入门到精通", 60);
        bookList.addBook(book1);
        bookList.addBook(book2);
        while (bookList.hasNext()) {
            System.out.println(bookList.getNext());
        }
    }
}
