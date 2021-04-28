package org.example.design_pattern_23.state.example1;

import org.junit.Test;

public class PersonTest {
    @Test
    public void test() {
        Person person = new Person();
        person.setHour(7);
        person.doSomething();
        person.setHour(12);
        person.doSomething();
        person.setHour(18);
        person.doSomething();
        person.setHour(8);
        person.doSomething();
    }
}
