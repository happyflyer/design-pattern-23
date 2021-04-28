package org.example.design_pattern_23.prototype;

import org.junit.Test;

public class Person2Test {
    @Test
    public void test() {
        Person2 person1 = new Person2();
        person1.setName("lifengxing");
        person1.setAge(30);
        person1.setSex("男");
        Person2 person2 = person1.clone();
        person2.setName("厉风行");
        System.out.println(person1);
        System.out.println(person2);
    }
}
