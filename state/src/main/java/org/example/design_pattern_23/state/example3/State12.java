package org.example.design_pattern_23.state.example3;

/**
 * @author lifei
 */
public class State12 extends State {
    @Override
    public void doOneThing(Person person) {
        if (person.getHour() == 12) {
            System.out.println("吃午饭");
        } else {
            person.setState(new State18());
            person.doSomething();
        }
    }
}
