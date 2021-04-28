package org.example.design_pattern_23.state.example3;

/**
 * @author lifei
 */
public class NoState extends State {
    @Override
    public void doOneThing(Person person) {
        System.out.println(person.getHour() + "未定义");
    }
}
