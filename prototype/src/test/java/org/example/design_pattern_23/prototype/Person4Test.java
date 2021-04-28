package org.example.design_pattern_23.prototype;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Person4Test {
    @Test
    public void test() {
        Person4 person1 = new Person4();
        person1.setName("lifengxing");
        List<String> friends = new ArrayList<>();
        friends.add("James");
        friends.add("Yao");
        person1.setFriends(friends);
        Person4 person2 = person1.clone();
        person2.setName("厉风行");
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person1.getFriends());
        System.out.println(person2.getFriends());
        friends.add("Mike");
        person1.setFriends(friends);
        System.out.println(person1.getFriends());
        System.out.println(person2.getFriends());
    }
}
