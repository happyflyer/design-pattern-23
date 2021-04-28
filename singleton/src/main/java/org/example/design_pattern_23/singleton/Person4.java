package org.example.design_pattern_23.singleton;

/**
 * 懒汉式
 *
 * @author lifei
 */
public class Person4 {
    private static Person4 person;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Person4() {
    }

    public static synchronized Person4 getPerson4() {
        if (person == null) {
            person = new Person4();
        }
        return person;
    }
}
