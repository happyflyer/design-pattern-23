package org.example.design_pattern_23.memento.example2;

import org.junit.Test;

public class Person1Test {
    @Test
    public void test() {
        Person person = new Person("lifengxing", "男", 30);
        Memento memento = person.createMemento();
        System.out.println(person);
        person.setAge(20);
        System.out.println(person);
        person.setMemento(memento);
        System.out.println(person);
    }
}
