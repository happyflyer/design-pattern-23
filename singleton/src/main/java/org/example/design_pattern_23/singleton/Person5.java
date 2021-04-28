package org.example.design_pattern_23.singleton;

/**
 * 懒汉式
 *
 * @author lifei
 */
public class Person5 {
    private static Person5 person;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Person5() {
    }

    public static Person5 getPerson5() {
        if (person == null) {
            synchronized (Person5.class) {
                if (person == null) {
                    person = new Person5();
                }
            }
        }
        return person;
    }
}
