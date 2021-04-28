package org.example.design_pattern_23.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lifei
 */
public class Person4 implements Cloneable {
    private String name;
    private int age;
    private String sex;
    private List<String> friends;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }

    @Override
    public String toString() {
        return "Person4{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", friends=" + friends +
                '}';
    }

    @Override
    protected Person4 clone() {
        try {
            Person4 person = (Person4) super.clone();
            List<String> friends = new ArrayList<>(this.getFriends());
            person.setFriends(friends);
            return person;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
