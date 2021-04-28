package org.example.design_pattern_23.singleton;

/**
 * 饿汉式
 *
 * @author lifei
 */
public class Person2 {
    public static final Person2 person = new Person2();
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Person2() {
    }

    public static Person2 getPerson2() {
        return person;
    }
}
