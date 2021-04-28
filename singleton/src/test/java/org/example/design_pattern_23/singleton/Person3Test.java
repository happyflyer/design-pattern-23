package org.example.design_pattern_23.singleton;

import org.junit.Test;

public class Person3Test {
    @Test
    public void test() {
        Person3 person1 = Person3.getPerson3();
        person1.setName("zhangsan");
        Person3 person2 = Person3.getPerson3();
        person2.setName("lisi");
        System.out.println(person1.getName());
        System.out.println(person2.getName());
    }
}
