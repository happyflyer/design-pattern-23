package org.example.design_pattern_23.flyweight;

import org.junit.Test;

public class TeacherTest {
    @Test
    public void test() {
        TeacherFactory factory = new TeacherFactory();
        Teacher teacher1 = factory.getTeacher("0102034");
        Teacher teacher2 = factory.getTeacher("0102035");
        Teacher teacher3 = factory.getTeacher("0102034");
        Teacher teacher4 = factory.getTeacher("0102037");
        System.out.println(teacher1);
        System.out.println(teacher2);
        System.out.println(teacher3);
        System.out.println(teacher4);
        System.out.println(teacher1 == teacher3);
    }
}
