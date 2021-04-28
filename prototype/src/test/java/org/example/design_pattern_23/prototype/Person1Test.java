package org.example.design_pattern_23.prototype;

import org.junit.Test;

public class Person1Test {
    @Test
    public void test() {
        Person1 person1 = new Person1();
        person1.setName("lifengxing");
        person1.setAge(30);
        person1.setSex("男");
        Person1 person2 = new Person1();
        person2.setName("beifeng");
        person2.setAge(30);
        person2.setSex("男");
        System.out.println(person1);
        System.out.println(person2);
    }
}
