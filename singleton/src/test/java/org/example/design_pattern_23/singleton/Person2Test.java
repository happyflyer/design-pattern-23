package org.example.design_pattern_23.singleton;

import org.junit.Test;

public class Person2Test {
    @Test
    public void test() {
        Person2 person1 = Person2.getPerson2();
        person1.setName("zhangsan");
        Person2 person2 = Person2.getPerson2();
        person2.setName("lisi");
        System.out.println(person1.getName());
        System.out.println(person2.getName());
    }
}
