package org.example.design_pattern_23.state.example3;

/**
 * @author lifei
 */
public class State7 extends State {
    @Override
    public void doOneThing(Person person) {
        if (person.getHour() == 7) {
            System.out.println("吃早餐");
        } else {
            person.setState(new State12());
            person.doSomething();
        }
    }
}
