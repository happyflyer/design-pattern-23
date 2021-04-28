package org.example.design_pattern_23.memento.example2;

import org.junit.Test;

public class Person2Test {
    @Test
    public void test() {
        Person person = new Person("lifengxing", "男", 30);
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(person.createMemento());
        System.out.println(person);
        person.setAge(20);
        System.out.println(person);
        person.setMemento(caretaker.getMemento());
        System.out.println(person);
    }
}
