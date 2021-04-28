package org.example.design_pattern_23.singleton;

/**
 * 懒汉式
 *
 * @author lifei
 */
public class Person3 {
    private static Person3 person;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Person3() {
    }

    public static Person3 getPerson3() {
        if (person == null) {
            person = new Person3();
        }
        return person;
    }
}
