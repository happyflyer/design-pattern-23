package org.example.design_pattern_23.observer;

import org.junit.Test;

public class PersonTest {
    @Test
    public void test() {
        Person person = new Person();
        person.addObserver(new MyObserver1("观察者1"));
        person.addObserver(new MyObserver1("观察者2"));
        System.out.println(person.countObservers());
        person.setName("lifengxing");
        person.setAge(23);
        person.setSex("男");
    }
}
