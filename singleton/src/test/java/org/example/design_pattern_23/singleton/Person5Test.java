package org.example.design_pattern_23.singleton;

import org.junit.Test;

public class Person5Test {
    @Test
    public void test() {
        Person5 person1 = Person5.getPerson5();
        person1.setName("zhangsan");
        Person5 person2 = Person5.getPerson5();
        person2.setName("lisi");
        System.out.println(person1.getName());
        System.out.println(person2.getName());
    }
}
