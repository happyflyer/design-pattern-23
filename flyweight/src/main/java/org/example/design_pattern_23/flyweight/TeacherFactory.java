package org.example.design_pattern_23.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lifei
 */
public class TeacherFactory {
    private final Map<String, Teacher> pool;

    public TeacherFactory() {
        this.pool = new HashMap<>();
    }

    public Teacher getTeacher(String number) {
        Teacher teacher = this.pool.get(number);
        if (teacher == null) {
            teacher = new Teacher(number);
            this.pool.put(number, teacher);
        }
        return teacher;
    }
}
