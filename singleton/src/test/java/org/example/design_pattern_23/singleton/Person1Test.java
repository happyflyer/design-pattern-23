package org.example.design_pattern_23.singleton;

import org.junit.Test;

public class Person1Test {
    @Test
    public void test() {
        Person1 person1 = new Person1();
        person1.setName("zhangsan");
        Person1 person2 = new Person1();
        person2.setName("lisi");
        System.out.println(person1.getName());
        System.out.println(person2.getName());
    }
}
