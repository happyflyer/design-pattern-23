package org.example.design_pattern_23.memento.example1;

import org.junit.Test;

public class PersonTest {
    @Test
    public void test() {
        Person person = new Person("lifengxing", "男", 30);
        Person backup = new Person();
        backup.setName(person.getName());
        backup.setSex(person.getSex());
        backup.setAge(person.getAge());
        System.out.println(person);
        person.setAge(20);
        System.out.println(person);
        person.setName(backup.getName());
        person.setSex(backup.getSex());
        person.setAge(backup.getAge());
        System.out.println(person);
    }
}
