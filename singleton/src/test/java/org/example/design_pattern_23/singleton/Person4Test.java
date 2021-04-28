package org.example.design_pattern_23.singleton;

import org.junit.Test;

public class Person4Test {
    @Test
    public void test() {
        Person4 person1 = Person4.getPerson4();
        person1.setName("zhangsan");
        Person4 person2 = Person4.getPerson4();
        person2.setName("lisi");
        System.out.println(person1.getName());
        System.out.println(person2.getName());
    }
}
