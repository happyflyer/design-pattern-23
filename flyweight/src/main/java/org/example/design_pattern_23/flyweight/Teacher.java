package org.example.design_pattern_23.flyweight;

/**
 * @author lifei
 */
public class Teacher extends Person {
    private String number;

    public Teacher(String number) {
        super();
        this.number = number;
    }

    public Teacher(String name, int age, String sex, String number) {
        super(name, age, sex);
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "number='" + number + '\'' +
                '}';
    }
}
